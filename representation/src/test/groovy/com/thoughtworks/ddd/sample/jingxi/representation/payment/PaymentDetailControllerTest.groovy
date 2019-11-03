package com.thoughtworks.ddd.sample.jingxi.representation.payment


import com.thoughtworks.ddd.sample.jingxi.application.payment.PaymentDetailApplicationService
import com.thoughtworks.ddd.sample.jingxi.application.payment.command.PaymentDetailCreateCommand
import com.thoughtworks.ddd.sample.jingxi.domain.common.auditing.AuditingInfo
import com.thoughtworks.ddd.sample.jingxi.domain.payment.model.PaymentDetail
import org.hamcrest.Matchers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Ignore
import spock.lang.Specification

import java.time.LocalDate
import java.time.LocalDateTime

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@AutoConfigureMockMvc
@WebMvcTest(PaymentDetailController.class)
class PaymentDetailControllerTest extends Specification {

  @Autowired
  private MockMvc mvc

  @MockBean
  PaymentDetailApplicationService applicationService

  @Ignore
  def "we can create a payment detail"() {
    given: "a payment detail request"

    and: ""
    applicationService.create(_ as PaymentDetailCreateCommand) >> prepareACreatedPay()

    when: "we perform this payment detail entry request"
    String payload = "{\n" +
      "  \"type\": \"PURCHASE\",\n" +
      "  \"targetWarehouse\": \"WMS56Y932K\",\n" +
      "  \"items\": [\n" +
      "    {\n" +
      "      \"skuCode\": \"V4C5D6E2\",\n" +
      "      \"quantity\": 100\n" +
      "    },\n" +
      "    {\n" +
      "      \"skuCode\": \"V4C5D6E1\",\n" +
      "      \"quantity\": 50\n" +
      "    }\n" +
      "  ],\n" +
      "  \"shipmentInfo\": {\n" +
      "    \"sendDate\": \"2019-05-19\",\n" +
      "    \"transactionNo\": \"TRX-SXX2019051805XDJ34D8L9\"\n" +
      "  }\n" +
      "}"
    def result = mvc.perform(MockMvcRequestBuilders.post("/payments")
      .contentType(MediaType.APPLICATION_JSON_UTF8)
      .content(payload))

    then: "we will get a payment detail"
    result.andExpect(status().isOk())
      .andExpect(jsonPath('$.id', Matchers.notNullValue()))

  }

  private static final PaymentDetail prepareACreatedPay() {
    PaymentDetail order = new PaymentDetail(
      "1",
      "a",
      123.45,
      LocalDate.now(),
      new AuditingInfo("someone", LocalDateTime.now())
    )

    return order
  }

}
