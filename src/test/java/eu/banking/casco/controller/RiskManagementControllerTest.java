package eu.banking.casco.controller;

import eu.banking.casco.model.RiskCoefficient;
import eu.banking.casco.repository.AvgPurchasePriceRepository;
import eu.banking.casco.repository.MakeCoefficientRepository;
import eu.banking.casco.repository.RiskCoefficientRepository;
import eu.banking.casco.service.CascoCalculationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RiskManagementController.class)
@AutoConfigureMockMvc
public class RiskManagementControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RiskCoefficientRepository riskCoefficientRepository;
    @MockBean
    private MakeCoefficientRepository makeCoefficientRepository;
    @MockBean
    private AvgPurchasePriceRepository avgPurchasePriceRepository;
    @MockBean
    private CascoCalculationService cascoCalculationService;

    @Test
    public void testGet() throws Exception {
        RiskCoefficient coefficient = new RiskCoefficient();
        coefficient.setName("age_risk");
        coefficient.setValue(BigDecimal.valueOf(0.9));
        when(riskCoefficientRepository.findAll())
                .thenReturn(List.of(coefficient));

        ResultActions result = mockMvc.perform(get("/risks")
                .accept(APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].value", is(0.9)));
    }
}
