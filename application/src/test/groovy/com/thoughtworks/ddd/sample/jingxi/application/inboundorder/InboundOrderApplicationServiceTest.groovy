package com.thoughtworks.ddd.sample.jingxi.application.inboundorder

import com.thoughtworks.ddd.sample.jingxi.application.inboundorder.command.InboundOrderCreateCommand
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.OrderStatus
import spock.lang.Specification

class InboundOrderApplicationServiceTest extends Specification {

    def inboundOrderApplicationService = new InboundOrderApplicationService()

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

    }
}
