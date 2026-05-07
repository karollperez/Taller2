package co.edu.uptc.service;

import co.edu.uptc.domain.Patient;
import co.edu.uptc.repository.PatientRepository;

/**
 * Servicio de pacientes
 */
public class PatientService {

    private PatientRepository repository;

    public PatientService() {
        repository = new PatientRepository();
    }

    public boolean registerPatient(Patient patient) {
        return repository.addPatient(patient);
    }

    public Patient findPatient(int id) {
        return repository.findPatient(id);
    }
    
    
    
    
    public java.util.ArrayList<Patient> getPatientsOrdered() {

        java.util.ArrayList<Patient> patients =
                new java.util.ArrayList<>(
                        repository.getPatients().values()
                );

        patients.sort(
                java.util.Comparator.comparing(
                        (Patient p) -> -p.getPriority().getLevel()
                )
        );

        return patients;
    }
}