package eu.banking.casco.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.banking.casco.model.Car;
import eu.banking.casco.repository.CarRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CarsController.class)
@AutoConfigureMockMvc
public class CarsControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CarRepository carRepository;
    @Autowired
    private ObjectMapper mapper;

    @Test
    public void testPost() throws Exception {
        Car car = new Car();
        car.setPlateNumber("111XXX");
        car.setProducer("volvo");
        car.setFirstRegistration(2011);
        car.setPurchasePrice(12000);
        car.setMileage(20000);
        car.setPreviousIndemnity(BigDecimal.valueOf(2100));
        car.setId(1L);

        when(carRepository.save(any()))
                .thenReturn(car);

        String json = mapper.writeValueAsString(car);

        mockMvc.perform(post("/car")
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
                .content(json))
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)));
    }
}
