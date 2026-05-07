package co.edu.uptc.service;

import co.edu.uptc.domain.MedicalAppointment;
import co.edu.uptc.repository.AppointmentRepository;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Servicio de citas médicas
 */
public class AppointmentService {

    private AppointmentRepository repository;

    public AppointmentService() {
        repository = new AppointmentRepository();
    }

    public boolean registerAppointment(
            MedicalAppointment appointment) {

        boolean added =
                repository.addAppointment(appointment);

        if (added) {

            appointment.getPatient()
                    .addAppointment(appointment);
        }

        return added;
    }
    public ArrayList<MedicalAppointment> getAppointmentsOrdered() {

        ArrayList<MedicalAppointment> appointments =
                repository.getAppointments();

        appointments.sort(Comparator
                .comparing(MedicalAppointment::getTimeAppointment)
                .thenComparing(a -> -a.getPriority().getLevel()));

        return appointments;
    }
}