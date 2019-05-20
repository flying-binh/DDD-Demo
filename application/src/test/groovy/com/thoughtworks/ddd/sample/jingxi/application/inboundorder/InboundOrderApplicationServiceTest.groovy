package com.thoughtworks.ddd.sample.jingxi.application.inboundorder

import com.thoughtworks.ddd.sample.jingxi.application.inboundorder.command.InboundOrderCreateCommand
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.AuditingInfo
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundOrder
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundOrderItem
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundType
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.OrderStatus
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.OrderType
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.ShipmentInfo
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.Supplier
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.Warehouse
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.repository.InboundOrderRepository
import spock.lang.Specification

import java.time.LocalDate
import java.time.LocalDateTime

class InboundOrderApplicationServiceTest extends Specification {

    def inboundOrderRepository = Mock(InboundOrderRepository)

    def inboundOrderApplicationService = new InboundOrderApplicationService(inboundOrderRepository)

    def "we could create an inbound order"() {
        given: "an inbound-order-create-command"
          def createCommand = new InboundOrderCreateCommand()

        when: "we create inbound order by the request"
          def inboundOrderDto = inboundOrderApplicationService.create(createCommand)

        then: "we will get an inbound order"
          inboundOrderDto != null
          inboundOrderDto.id != null
        and: "its status should be draft"
          inboundOrderDto.status == OrderStatus.DRAFT

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
                [new InboundOrderItem("S23461YH123P", 1000L)],
                new Supplier("V023D91", "JMO"),
                new ShipmentInfo("E00934R3123D234", LocalDate.now()),
                InboundType.PURCHASE,
                new AuditingInfo("CAI Jun", LocalDateTime.now())
        )
        order.setId(UUID.randomUUID().toString())
        order.setStatus(OrderStatus.DRAFT)
        order
    }
}
