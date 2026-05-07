package co.edu.uptc.service;

import co.edu.uptc.domain.Doctor;
import co.edu.uptc.repository.DoctorRepository;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Servicio de médicos
 */
public class DoctorService {

    private DoctorRepository repository;

    public DoctorService() {
        repository = new DoctorRepository();
    }

    public boolean registerDoctor(Doctor doctor) {
        return repository.addDoctor(doctor);
    }

    public Doctor findDoctor(int id) {
        return repository.findDoctor(id);
    }
    
    public boolean deleteDoctor(int id) {
        return repository.deleteDoctor(id);
    }

    public ArrayList<Doctor> getDoctorsOrdered() {

        ArrayList<Doctor> doctors = repository.getDoctors();

        doctors.sort(Comparator
                .comparing(Doctor::getYearsOfExperience)
                .thenComparing(Doctor::getFullName));

        return doctors;
    }
}