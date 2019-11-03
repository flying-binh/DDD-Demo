package com.thoughtworks.ddd.sample.jingxi.infrastructure.contract.repository.jpa;

import com.thoughtworks.ddd.sample.jingxi.infrastructure.contract.po.PaymentDetailPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetailJpaRepository extends JpaRepository<PaymentDetailPo, String> {
}
