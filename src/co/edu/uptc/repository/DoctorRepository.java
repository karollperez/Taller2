package co.edu.uptc.repository;

import co.edu.uptc.domain.Doctor;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Repositorio de médicos
 */
public class DoctorRepository {

    private HashMap<Integer, Doctor> doctors;

    public DoctorRepository() {
        doctors = new HashMap<>();
    }

    public boolean addDoctor(Doctor doctor) {

        if (doctors.containsKey(doctor.getMedicalId())) {
            return false;
        }

        doctors.put(doctor.getMedicalId(), doctor);
        return true;
    }

    public Doctor findDoctor(int id) {
        return doctors.get(id);
    }

    public ArrayList<Doctor> getDoctors() {
        return new ArrayList<>(doctors.values());
    }
}