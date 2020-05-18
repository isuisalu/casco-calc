package eu.banking.casco.repository.impl;

import eu.banking.casco.model.Casco;
import eu.banking.casco.repository.CascoRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.*;

@Log4j2
@Repository
public class CascoRepositoryImpl implements CascoRepository {
    private String fileName = "casco.csv";

    private Map<String, Casco> cascos = new HashMap<>();

    @Override
    public Casco findByPlateNumber(String plateNumber) {
        return cascos.get(plateNumber);
    }

    @Override
    public List<Casco> findAll() {
        return new ArrayList<>(cascos.values());
    }

    public void save(Casco casco) {
        Objects.requireNonNull(casco);
        Objects.requireNonNull(casco.getCar());
        cascos.put(casco.getCar().getPlateNumber(), casco);

        try {
            File outFile = new File(fileName);
            boolean exists = outFile.exists();
            FileWriter writer = new FileWriter(outFile, true);
            PrintWriter printWriter = new PrintWriter(writer);
            if (!exists) {
                printWriter.println("#plate_number,annual,monyhly");
            }
            printWriter.printf("%s,%.2f,%.2f\n", casco.getCar().getPlateNumber(),
                    casco.getAnnual().doubleValue(), casco.getMonthly().doubleValue());
            printWriter.flush();
            printWriter.close();
        } catch (Exception e) {
            log.error("Error during car save:", e);
            throw new RuntimeException(e);
        }
    }
}
