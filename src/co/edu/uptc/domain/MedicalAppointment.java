package co.edu.uptc.domain;

import co.edu.uptc.enums.Priority;

/**
 * Clase que representa una cita médica.
 * Contiene la información del paciente, médico y prioridad.
 *
 * @author Karoll Daniela Pérez Ortiz
 * @version 1.0
 * @since JDK 21
 */
public class MedicalAppointment {

    /**
     * Identificador de la cita médica.
     */
    private int idMedicalAppointment;

    /**
     * Hora de la cita.
     */
    private String timeAppointment;

    /**
     * Paciente asignado a la cita.
     */
    private Patient patient;

    /**
     * Médico encargado de la cita.
     */
    private Doctor doctor;

    /**
     * Prioridad de la cita médica.
     */
    private Priority priority;

    /**
     * Constructor de la clase MedicalAppointment.
     *
     * @param idMedicalAppointment identificador de la cita
     * @param timeAppointment hora de la cita
     * @param patient paciente asignado
     * @param doctor médico encargado
     * @param priority prioridad de la cita
     */
    public MedicalAppointment(int idMedicalAppointment,
                              String timeAppointment,
                              Patient patient,
                              Doctor doctor,
                              Priority priority) {

        this.idMedicalAppointment = idMedicalAppointment;
        this.timeAppointment = timeAppointment;
        this.patient = patient;
        this.doctor = doctor;
        this.priority = priority;
    }

    /**
     * Obtiene el identificador de la cita.
     *
     * @return identificador de la cita
     */
    public int getIdMedicalAppointment() {
        return idMedicalAppointment;
    }

    /**
     * Obtiene la hora de la cita.
     *
     * @return hora de la cita
     */
    public String getTimeAppointment() {
        return timeAppointment;
    }

    /**
     * Obtiene el paciente asignado.
     *
     * @return paciente de la cita
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Obtiene el médico encargado.
     *
     * @return médico de la cita
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Obtiene la prioridad de la cita.
     *
     * @return prioridad de la cita
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * Retorna la información de la cita médica.
     *
     * @return información de la cita
     */
    @Override
    public String toString() {
        return "Cita #" + idMedicalAppointment +
                " | Hora: " + timeAppointment +
                " | Paciente: " + patient.getFullName() +
                " | Prioridad: " + priority;
    }
}