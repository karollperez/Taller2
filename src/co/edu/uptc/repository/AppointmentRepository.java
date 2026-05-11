package co.edu.uptc.repository;

import co.edu.uptc.domain.MedicalAppointment;

import java.util.ArrayList;

/**
 * Repositorio de citas médicas.
 * Permite almacenar y consultar las citas registradas.
 *
 * @author Karoll Daniela Pérez Ortiz
 * @version 1.0
 * @since JDK 21
 */
public class AppointmentRepository {

    /**
     * Lista de citas médicas registradas.
     */
    private ArrayList<MedicalAppointment> appointments;

    /**
     * Constructor de la clase AppointmentRepository.
     * Inicializa la lista de citas médicas.
     */
    public AppointmentRepository() {
        appointments = new ArrayList<>();
    }

    /**
     * Agrega una cita médica al repositorio.
     * Verifica que no exista otra cita con el mismo identificador.
     *
     * @param appointment cita médica a agregar
     * @return true si la cita fue agregada, false si ya existe
     */
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

    /**
     * Obtiene la lista de citas médicas.
     *
     * @return lista de citas médicas
     */
    public ArrayList<MedicalAppointment> getAppointments() {
        return appointments;
    }
}