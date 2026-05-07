package co.edu.uptc.domain;

import co.edu.uptc.enums.Priority;

/**
 * Clase que representa una cita médica
 */
public class MedicalAppointment {

    private int idMedicalAppointment;
    private String timeAppointment;
    private Patient patient;
    private Doctor doctor;
    private Priority priority;

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

    public int getIdMedicalAppointment() {
        return idMedicalAppointment;
    }

    public String getTimeAppointment() {
        return timeAppointment;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Cita #" + idMedicalAppointment +
                " | Hora: " + timeAppointment +
                " | Paciente: " + patient.getFullName() +
                " | Prioridad: " + priority;
    }
}