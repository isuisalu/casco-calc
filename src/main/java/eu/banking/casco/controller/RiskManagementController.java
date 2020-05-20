package eu.banking.casco.controller;

import eu.banking.casco.model.AvgPurchasePrice;
import eu.banking.casco.model.MakeCoefficient;
import eu.banking.casco.model.RiskCoefficient;
import eu.banking.casco.repository.AvgPurchasePriceRepository;
import eu.banking.casco.repository.MakeCoefficientRepository;
import eu.banking.casco.repository.RiskCoefficientRepository;
import eu.banking.casco.service.CascoCalculationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PreDestroy;
import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Log4j2
@RequiredArgsConstructor
@RestController
public class RiskManagementController {

    private final RiskCoefficientRepository riskCoefficientRepository;
    private final MakeCoefficientRepository makeCoefficientRepository;
    private final AvgPurchasePriceRepository avgPurchasePriceRepository;
    private final CascoCalculationService cascoCalculationService;
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    @GetMapping("risks")
    public HttpEntity<?> getRiskCoefficients() {
        List<RiskCoefficient> risks = riskCoefficientRepository.findAll();
        return new ResponseEntity<>(risks, HttpStatus.OK);
    }
    @PostMapping("risk")
    public RiskCoefficient addRiskCoefficient(@RequestBody @Valid RiskCoefficient risk) {
        return riskCoefficientRepository.save(risk);
    }
    @PutMapping("risk/{id}")
    public HttpEntity<?> updateRiskCoefficient(@PathVariable("id") final long id,
                                               @RequestBody @Valid RiskCoefficient risk) {
        risk.setId(id);
        RiskCoefficient saved = riskCoefficientRepository.save(risk);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }
    @DeleteMapping("risk/{id}")
    public HttpEntity<?> deleteRiskCoefficient(@PathVariable("id") final long id) {
        riskCoefficientRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("make_risks")
    public HttpEntity<?> getMakeCoefficients() {
        List<MakeCoefficient> risks = makeCoefficientRepository.findAll();
        return new ResponseEntity<>(risks, HttpStatus.OK);
    }
    @PostMapping("make_risk")
    public HttpEntity<?> addMakeCoefficient(@RequestBody @Valid MakeCoefficient make) {
        MakeCoefficient saved = makeCoefficientRepository.save(make);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }
    @PutMapping("make_risk/{id}")
    public HttpEntity<?> updateMakeCoefficient(@PathVariable("id") final long id,
                                       @RequestBody @Valid MakeCoefficient make) {
        make.setId(id);
        MakeCoefficient saved = makeCoefficientRepository.save(make);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }
    @DeleteMapping("make_risk/{id}")
    HttpEntity<?> deleteMakeCoefficient(@PathVariable("id") final long id) {
        makeCoefficientRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("prices")
    public HttpEntity<?> getAvgPurchasePrices() {
        List<AvgPurchasePrice> risks = avgPurchasePriceRepository.findAll();
        return new ResponseEntity<>(risks, HttpStatus.OK);
    }
    @PostMapping("price")
    public HttpEntity<?> addAvgPurchasePrice(@RequestBody @Valid AvgPurchasePrice price) {
        AvgPurchasePrice saved = avgPurchasePriceRepository.save(price);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }
    @PutMapping("price/{id}")
    public HttpEntity<?> updateAvgPurchasePrice(@PathVariable("id") final long id,
                                               @RequestBody @Valid AvgPurchasePrice price) {
        price.setId(id);
        AvgPurchasePrice saved = avgPurchasePriceRepository.save(price);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }
    @DeleteMapping("price/{id}")
    HttpEntity<?> deleteAvgPurchasePrice(@PathVariable("id") final long id) {
        avgPurchasePriceRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("recalculate")
    HttpEntity<?> recalculate() {
        executor.submit(new Runnable() {
            public void run() {
                cascoCalculationService.reCalculateCascos();
            }
        });
        return ResponseEntity.noContent().build();
    }

    @PreDestroy
    public void shutdown() {
        executor.shutdown();
    }
}
