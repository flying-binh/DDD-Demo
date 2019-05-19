package com.thoughtworks.ddd.sample.jingxi.application.inboundorder.representation.inboundorder

import com.google.gson.Gson
import org.hamcrest.Matchers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Specification
import utils.DataHelper

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@AutoConfigureMockMvc
@WebMvcTest(InboundOrderController)
class InboundOrderControllerTest extends Specification {

    @Autowired
    private MockMvc mvc

    def "we can create a warehouse entry"() {
        given: "a warehouse entry request"

        when: "we perform this warehouse entry request"
        String payload = DataHelper.loadFixtureData("inbound-order/create-inbound-order.json")
        print new Gson().fromJson(payload, InboundOrderCreateRequest)
          def result = mvc.perform(MockMvcRequestBuilders.post("/inbound-orders")
                  .contentType(MediaType.APPLICATION_JSON_UTF8)
                  .content(payload))

        then: "we will get a warehouse entry"
          result.andExpect(status().isOk())
                  .andExpect(jsonPath('$.id', Matchers.notNullValue()))

    }

}
