package io.oussamaib0.tpspringthymeleaf.services;

import io.oussamaib0.tpspringthymeleaf.entities.Patient;

import java.util.List;

public interface IPatientService {
    Patient savePatient(Patient patient);

    Patient updatePatient(Patient patient);

    void deletePatient(Long id);

    Patient getPatient(Long id);

    List<Patient> getAllPatients();
}
