package eu.banking.casco.repository;

import eu.banking.casco.CascoCalcApplication;
import eu.banking.casco.model.RiskCoefficient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@Profile("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = NONE,
        classes = {CascoCalcApplication.class, TestConfiguration.class})
public class RiskCoefficientRepositoryTest {
    @Autowired
    private RiskCoefficientRepository riskCoefficientRepository;

    @Test
    public void testRepository() {
        RiskCoefficient risk = new RiskCoefficient();
        risk.setName(RiskCoefficientRepository.VEHICLE_AGE_RISK);
        risk.setValue(BigDecimal.valueOf(1.2));

        riskCoefficientRepository.save(risk);

        assertThat(riskCoefficientRepository
                .findByName(RiskCoefficientRepository.VEHICLE_AGE_RISK)
                .getValue().doubleValue(), is(1.2));
    }
}
