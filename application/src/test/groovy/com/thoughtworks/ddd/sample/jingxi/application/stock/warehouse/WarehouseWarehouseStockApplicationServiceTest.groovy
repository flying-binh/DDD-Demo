package com.thoughtworks.ddd.sample.jingxi.application.stock.warehouse

import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.event.InboundOrderSubmittedEvent
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundType
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.Increment
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.SkuStock
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.model.WarehouseStock
import com.thoughtworks.ddd.sample.jingxi.domain.stock.warehouse.repository.WarehouseStockRepository
import spock.lang.Specification

import java.time.LocalDateTime

import static org.assertj.core.util.Sets.newHashSet

class WarehouseWarehouseStockApplicationServiceTest extends Specification {

    WarehouseStockApplicationService applicationService
    def stockRepository = Mock(WarehouseStockRepository)

    void setup() {
        applicationService = new WarehouseStockApplicationService(stockRepository)
    }

    def "we need to increase the sku inventory when an inbound order was submitted"() {

        given: "inbound order submitted event"

          def event = new InboundOrderSubmittedEvent(1L, InboundType.PURCHASE,
                  "Changan001",
                  [],
                  "SU San",
                  LocalDateTime.now())

        when: "we received this event"

          applicationService.listenInboundOrderSubmitted(event)

        then: "we need tot register the skus to the warehouse"

          1 * stockRepository.store(_ as WarehouseStock)

        and: "inbound the sku stock of in this warehouse"

          1 * stockRepository.merge(*_ as List<Increment>)

        and:
          1 * stockRepository.getOne("Changan001") >> new WarehouseStock(
                  "Changan001",
                  newHashSet([new SkuStock("S001", 1000, 2000),
                              new SkuStock("S002", 100, 1000),
                              new SkuStock("S003", 50, 10)]))
    }

}
