package eu.banking.casco.service.impl;

import eu.banking.casco.service.CascoCalculationService;
import eu.banking.casco.service.DataImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Profile("prod")
@RequiredArgsConstructor
@Component
public class StartupServiceImpl implements ApplicationContextAware {

    private final DataImportService dataImportService;
    private final CascoCalculationService cascoCalculationService;

    private ConfigurableApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        dataImportService.importAll();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (ConfigurableApplicationContext)applicationContext;
    }
}
