package co.edu.uptc.repository;

import co.edu.uptc.domain.Doctor;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Repositorio de médicos.
 * Permite almacenar y gestionar los médicos registrados.
 *
 * @author Karoll Daniela Pérez Ortiz
 * @version 1.0
 * @since JDK 21
 */
public class DoctorRepository {

    /**
     * Colección de médicos registrados.
     */
    private HashMap<Integer, Doctor> doctors;

    /**
     * Constructor de la clase DoctorRepository.
     * Inicializa la colección de médicos.
     */
    public DoctorRepository() {
        doctors = new HashMap<>();
    }

    /**
     * Agrega un médico al repositorio.
     * Verifica que no exista previamente.
     *
     * @param doctor médico a agregar
     * @return true si se agregó, false si ya existe
     */
    public boolean addDoctor(Doctor doctor) {

        if (doctors.containsKey(doctor.getMedicalId())) {
            return false;
        }

        doctors.put(doctor.getMedicalId(), doctor);
        return true;
    }

    /**
     * Busca un médico por su identificación.
     *
     * @param id identificación del médico
     * @return médico encontrado
     */
    public Doctor findDoctor(int id) {
        return doctors.get(id);
    }

    /**
     * Obtiene la lista de médicos registrados.
     *
     * @return lista de médicos
     */
    public ArrayList<Doctor> getDoctors() {
        return new ArrayList<>(doctors.values());
    }
    
    /**
     * Elimina un médico del repositorio.
     *
     * @param id identificación del médico
     * @return true si fue eliminado, false si no existe
     */
    public boolean deleteDoctor(int id) {

        return doctors.remove(id) != null;
    }
}