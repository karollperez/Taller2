package co.edu.uptc.service;

import co.edu.uptc.domain.Doctor;
import co.edu.uptc.repository.DoctorRepository;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Servicio de médicos.
 * Permite registrar, buscar y organizar médicos.
 *
 * @author Karoll Daniela Pérez Ortiz
 * @version 1.0
 * @since JDK 21
 */
public class DoctorService {

    /**
     * Repositorio de médicos.
     */
    private DoctorRepository repository;

    /**
     * Constructor de la clase DoctorService.
     * Inicializa el repositorio de médicos.
     */
    public DoctorService() {
        repository = new DoctorRepository();
    }

    /**
     * Registra un médico.
     *
     * @param doctor médico a registrar
     * @return true si fue registrado, false si ya existe
     */
    public boolean registerDoctor(Doctor doctor) {
        return repository.addDoctor(doctor);
    }

    /**
     * Busca un médico por su identificación.
     *
     * @param id identificación del médico
     * @return médico encontrado
     */
    public Doctor findDoctor(int id) {
        return repository.findDoctor(id);
    }
    
    /**
     * Elimina un médico.
     *
     * @param id identificación del médico
     * @return true si fue eliminado, false si no existe
     */
    public boolean deleteDoctor(int id) {
        return repository.deleteDoctor(id);
    }

    /**
     * Obtiene los médicos ordenados.
     * Se organizan por experiencia y nombre.
     *
     * @return lista de médicos ordenados
     */
    public ArrayList<Doctor> getDoctorsOrdered() {

        ArrayList<Doctor> doctors = repository.getDoctors();

        doctors.sort(Comparator
                .comparing(Doctor::getYearsOfExperience)
                .thenComparing(Doctor::getFullName));

        return doctors;
    }
}