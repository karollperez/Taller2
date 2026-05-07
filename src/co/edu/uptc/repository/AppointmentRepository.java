package co.edu.uptc.repository;

import co.edu.uptc.domain.MedicalAppointment;

import java.util.ArrayList;

/**
 * Repositorio de citas médicas
 */
public class AppointmentRepository {

    private ArrayList<MedicalAppointment> appointments;

    public AppointmentRepository() {
        appointments = new ArrayList<>();
    }

    public boolean addAppointment(MedicalAppointment appointment) {

        for (MedicalAppointment m : appointments) {

            if (m.getIdMedicalAppointment() ==
                    appointment.getIdMedicalAppointment()) {

                return false;
            }
        }

        appointments.add(appointment);
        return true;
    }

    public ArrayList<MedicalAppointment> getAppointments() {
        return appointments;
    }
}