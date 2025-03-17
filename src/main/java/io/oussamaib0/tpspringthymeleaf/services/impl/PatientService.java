package io.oussamaib0.tpspringthymeleaf.services.impl;

import io.oussamaib0.tpspringthymeleaf.entities.Patient;
import io.oussamaib0.tpspringthymeleaf.repository.PatientRepository;
import io.oussamaib0.tpspringthymeleaf.services.IPatientService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PatientService implements IPatientService {
    private final PatientRepository patientRepository;

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public Patient getPatient(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Page<Patient> findByNameContainsIgnoreCase(String keyword, Pageable pageable) {
        return patientRepository.findByNameContainsIgnoreCase(keyword, pageable);
    }
}
