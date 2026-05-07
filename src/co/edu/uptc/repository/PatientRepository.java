package co.edu.uptc.repository;

import co.edu.uptc.domain.Patient;

import java.util.HashMap;

/**
 * Repositorio de pacientes
 */
public class PatientRepository {

    private HashMap<Integer, Patient> patients;
    private HashMap<String, Patient> emails;

    public PatientRepository() {
        patients = new HashMap<>();
        emails = new HashMap<>();
    }

    public boolean addPatient(Patient patient) {

        if (patients.containsKey(patient.getIdPatient())) {
            return false;
        }

        if (emails.containsKey(patient.getEmail())) {
            return false;
        }

        patients.put(patient.getIdPatient(), patient);
        emails.put(patient.getEmail(), patient);

        return true;
    }

    public Patient findPatient(int id) {
        return patients.get(id);
    }

    public HashMap<Integer, Patient> getPatients() {
        return patients;
    }
    
    public boolean deletePatient(int id) {

        Patient patient = patients.remove(id);

        if (patient != null) {

            emails.remove(patient.getEmail());
            return true;
        }

        return false;
    }
}