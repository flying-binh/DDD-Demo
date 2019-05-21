package com.thoughtworks.ddd.sample.jingxi.infrastructure.inboundorder.repository.jpa;

import com.thoughtworks.ddd.sample.jingxi.infrastructure.inboundorder.po.InboundOrderPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InboundOrderJapRepository extends JpaRepository<InboundOrderPo, Long> {
}
