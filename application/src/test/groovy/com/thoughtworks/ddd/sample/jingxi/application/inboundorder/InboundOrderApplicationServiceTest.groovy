package com.thoughtworks.ddd.sample.jingxi.application.inboundorder

import com.thoughtworks.ddd.sample.jingxi.application.common.publish.EventPublisher
import com.thoughtworks.ddd.sample.jingxi.application.inboundorder.command.InboundOrderCreateCommand
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.*
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.repository.InboundOrderRepository
import spock.lang.Specification

import java.time.LocalDate
import java.time.LocalDateTime

class InboundOrderApplicationServiceTest extends Specification {

    def inboundOrderRepository = Mock(InboundOrderRepository)

    def eventPublisher = Mock(EventPublisher)

    def inboundOrderApplicationService = new InboundOrderApplicationService(inboundOrderRepository, eventPublisher)

    def "we could create an inbound order"() {
        given: "an inbound-order-create-command"
          def createCommand = new InboundOrderCreateCommand(InboundType.PURCHASE,
                  new ShipmentInfo("E02394L934D3", LocalDate.now()),
                  [new InboundOrderItem(skuCode: "N7130S2S0U876", quantity: 1000L)],
                  "E0023J018439K129",
                  "V2EK2304W991",
                  "ZHAO Jialiang",
                  LocalDateTime.now())

        when: "we create inbound order by the request"
          def inboundOrderDto = inboundOrderApplicationService.create(createCommand)

        then: "we will get an inbound order"
          inboundOrderDto != null
          inboundOrderDto.id != null
        and: "its status should be draft"
          inboundOrderDto.status == OrderStatus.DRAFT

        and: "there will be an inbound-order-created-event"
          1 * eventPublisher.publish(_)

        and:
          1 * inboundOrderRepository.store({
              verifyAll(it, InboundOrder) {
                  it.type == OrderType.INBOUND
                  it.status == OrderStatus.DRAFT
              }
              it
          } as InboundOrder) >> prepareADraftOrder()

    }

    private static def prepareADraftOrder() {
        InboundOrder order = new InboundOrder(new Warehouse("W-NAME", "W-CODE"),
                [new InboundOrderItem(skuCode: "S23461YH123P", quantity: 1000L)],
                new Supplier("V023D91", "JMO"),
                new ShipmentInfo("E00934R3123D234", LocalDate.now()),
                InboundType.PURCHASE,
                new AuditingInfo("CAI Jun", LocalDateTime.now())
        )
        order.setId(Math.random().longValue())
        order.setStatus(OrderStatus.DRAFT)
        order
    }
}
