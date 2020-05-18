package eu.banking.casco.repository;

import eu.banking.casco.model.Casco;

import java.util.List;

public interface CascoRepository {
    Casco findByPlateNumber(String plateNumber);
    List<Casco> findAll();
    void save(Casco casco);
}
