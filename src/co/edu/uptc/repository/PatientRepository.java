package co.edu.uptc.repository;

import co.edu.uptc.domain.Patient;

import java.util.HashMap;

/**
 * Repositorio de pacientes.
 * Permite almacenar y gestionar los pacientes registrados.
 *
 * @author Karoll Daniela Pérez Ortiz
 * @version 1.0
 * @since JDK 21
 */
public class PatientRepository {

    /**
     * Colección de pacientes registrados.
     */
    private HashMap<Integer, Patient> patients;

    /**
     * Colección de correos electrónicos registrados.
     */
    private HashMap<String, Patient> emails;

    /**
     * Constructor de la clase PatientRepository.
     * Inicializa las colecciones de pacientes.
     */
    public PatientRepository() {
        patients = new HashMap<>();
        emails = new HashMap<>();
    }

    /**
     * Agrega un paciente al repositorio.
     * Verifica que no exista el mismo documento o correo.
     *
     * @param patient paciente a agregar
     * @return true si fue agregado, false si ya existe
     */
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

    /**
     * Busca un paciente por su identificación.
     *
     * @param id identificación del paciente
     * @return paciente encontrado
     */
    public Patient findPatient(int id) {
        return patients.get(id);
    }

    /**
     * Obtiene la colección de pacientes registrados.
     *
     * @return colección de pacientes
     */
    public HashMap<Integer, Patient> getPatients() {
        return patients;
    }
    
    /**
     * Elimina un paciente del repositorio.
     *
     * @param id identificación del paciente
     * @return true si fue eliminado, false si no existe
     */
    public boolean deletePatient(int id) {

        Patient patient = patients.remove(id);

        if (patient != null) {

            emails.remove(patient.getEmail());
            return true;
        }

        return false;
    }
}