package io.oussamaib0.tpspringthymeleaf;

import io.oussamaib0.tpspringthymeleaf.entities.Patient;
import io.oussamaib0.tpspringthymeleaf.repository.PatientRepository;
import io.oussamaib0.tpspringthymeleaf.services.IPatientService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
@AllArgsConstructor
public class TpSpringThymeleafApplication implements CommandLineRunner {
    private final IPatientService patientService;

    public static void main(String[] args) {
        SpringApplication.run(TpSpringThymeleafApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            patientService.savePatient(
                    Patient.builder()
                            .id(null)
                            .name("Patient " + i)
                            .score((int) (Math.random() * 100))
                            .isSick(Math.random() > 0.5)
                            .birthDate(new Date())
                            .build()
            );
        }
    }
}
