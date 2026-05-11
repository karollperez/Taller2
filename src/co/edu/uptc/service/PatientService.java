package co.edu.uptc.service;

import co.edu.uptc.domain.Patient;
import co.edu.uptc.repository.PatientRepository;

/**
 * Servicio de pacientes.
 * Permite registrar, buscar y organizar pacientes.
 *
 * @author Karoll Daniela Pérez Ortiz
 * @version 1.0
 * @since JDK 21
 */
public class PatientService {

    /**
     * Repositorio de pacientes.
     */
    private PatientRepository repository;

    /**
     * Constructor de la clase PatientService.
     * Inicializa el repositorio de pacientes.
     */
    public PatientService() {
        repository = new PatientRepository();
    }

    /**
     * Registra un paciente.
     *
     * @param patient paciente a registrar
     * @return true si fue registrado, false si ya existe
     */
    public boolean registerPatient(Patient patient) {
        return repository.addPatient(patient);
    }

    /**
     * Busca un paciente por su identificación.
     *
     * @param id identificación del paciente
     * @return paciente encontrado
     */
    public Patient findPatient(int id) {
        return repository.findPatient(id);
    }
    
    
    /**
     * Elimina un paciente.
     *
     * @param id identificación del paciente
     * @return true si fue eliminado, false si no existe
     */
    public boolean deletePatient(int id) {
        return repository.deletePatient(id);
    }
    
    
    /**
     * Obtiene los pacientes ordenados.
     * Se organizan según su prioridad.
     *
     * @return lista de pacientes ordenados
     */
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