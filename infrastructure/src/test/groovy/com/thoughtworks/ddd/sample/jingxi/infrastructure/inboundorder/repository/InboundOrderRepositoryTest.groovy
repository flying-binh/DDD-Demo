package com.thoughtworks.ddd.sample.jingxi.infrastructure.inboundorder.repository

import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.AuditingInfo
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundOrder
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundOrderItem
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.InboundType
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.ShipmentInfo
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.Supplier
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.model.Warehouse
import com.thoughtworks.ddd.sample.jingxi.domain.inboundorder.repository.InboundOrderRepository
import com.thoughtworks.ddd.sample.jingxi.infrastructure.inboundorder.po.InboundOrderPo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.context.annotation.Import
import spock.lang.Specification

import java.time.LocalDate
import java.time.LocalDateTime

@DataJpaTest
@Import(InboundOrderRepositoryImpl)
class InboundOrderRepositoryTest extends Specification {

    @Autowired
    InboundOrderRepository inboundOrderRepository

    @Autowired
    TestEntityManager testEntityManager

    def "store an inbound-order"() {
        given: "an inbound order"
          def inboundOrder = new InboundOrder(
                  Warehouse.builder().code("W9013JU34").build(),
                  [
                          new InboundOrderItem(skuCode: "S038L001K976", quantity: 100L)
                  ],
                  Supplier.builder().code("S00K738H17").build(),
                  new ShipmentInfo("V91C00123M785D1003", LocalDate.now()),
                  InboundType.PURCHASE,
                  new AuditingInfo("Trump", LocalDateTime.now()))

        when: "store this inbound order"
          def result = inboundOrderRepository.store(inboundOrder)
        then: "the order will be persisted"
          result != null
          result.id != null
        and: "we can find this order in db"
          def order = testEntityManager.find(InboundOrderPo, result.id)
          order != null
          order.id == result.id
    }
}
