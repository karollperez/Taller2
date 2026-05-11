package co.edu.uptc.service;

import co.edu.uptc.domain.MedicalAppointment;
import co.edu.uptc.repository.AppointmentRepository;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Servicio de citas médicas.
 * Permite registrar y organizar las citas.
 *
 * @author Karoll Daniela Pérez Ortiz
 * @version 1.0
 * @since JDK 21
 */
public class AppointmentService {

    /**
     * Repositorio de citas médicas.
     */
    private AppointmentRepository repository;

    /**
     * Constructor de la clase AppointmentService.
     * Inicializa el repositorio de citas.
     */
    public AppointmentService() {
        repository = new AppointmentRepository();
    }

    /**
     * Registra una cita médica.
     * Si se registra correctamente, se agrega
     * al historial del paciente.
     *
     * @param appointment cita médica a registrar
     * @return true si fue registrada, false si ya existe
     */
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

    /**
     * Obtiene las citas médicas ordenadas.
     * Se organizan por prioridad y hora.
     *
     * @return lista de citas ordenadas
     */
    public ArrayList<MedicalAppointment> getAppointmentsOrdered() {

        ArrayList<MedicalAppointment> appointments =
                repository.getAppointments();

        appointments.sort(
                Comparator
                        .comparing(
                                (MedicalAppointment a) ->
                                        -a.getPriority().getLevel()
                        )
                        .thenComparing(
                                MedicalAppointment::getTimeAppointment
                        )
        );

        return appointments;
    }
}