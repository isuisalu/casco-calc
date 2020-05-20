package eu.banking.casco.service;

public interface DataImportService {
    void importRiskData();
    void importCars();
    void importCars(String fileName);
    void importRiskData(String fileName);
    void importAll();
}
