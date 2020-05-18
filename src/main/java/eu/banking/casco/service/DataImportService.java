package eu.banking.casco.service;

public interface DataImportService {
    void importCars(String fileName);
    void importRiskData(String fileName);
    void importAll();
}
