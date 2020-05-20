package eu.banking.casco.controller;

import eu.banking.casco.model.Casco;
import eu.banking.casco.repository.CascoRepository;
import eu.banking.casco.service.CascoCalculationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
public class CascoController {

    private final CascoRepository cascoRepository;

    @GetMapping("cascos")
    public HttpEntity<?> getCars() {
        List<Casco> cascos = cascoRepository.findAll();
        return new ResponseEntity<>(cascos, HttpStatus.OK);
    }
}
