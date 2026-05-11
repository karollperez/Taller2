package co.edu.uptc.domain;

import co.edu.uptc.enums.IdentificationType;
import co.edu.uptc.enums.Priority;

import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * Clase que representa un paciente.
 * Permite almacenar sus datos personales e historial.
 *
 * @author Karoll Daniela Pérez Ortiz
 * @version 1.0
 * @since JDK 21
 */
public class Patient {

    /**
     * Tipo de identificación del paciente.
     */
    private IdentificationType identificationType;

    /**
     * Número de identificación del paciente.
     */
    private int idPatient;

    /**
     * Nombre del paciente.
     */
    private String firstName;

    /**
     * Apellido del paciente.
     */
    private String lastName;

    /**
     * Correo electrónico del paciente.
     */
    private String email;

    /**
     * Historial de medicamentos del paciente.
     */
    private LinkedHashSet<String> medicationHistory;

    /**
     * Historial de citas médicas.
     */
    private ArrayList<MedicalAppointment> appointmentHistory;

    /**
     * Prioridad asignada al paciente.
     */
    private Priority priority;

    /**
     * Constructor de la clase Patient.
     *
     * @param identificationType tipo de identificación
     * @param idPatient número de identificación
     * @param firstName nombre del paciente
     * @param lastName apellido del paciente
     * @param email correo electrónico
     * @param priority prioridad del paciente
     */
    public Patient(IdentificationType identificationType,
                   int idPatient,
                   String firstName,
                   String lastName,
                   String email,
                   Priority priority) {

        this.identificationType = identificationType;
        this.idPatient = idPatient;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.priority = priority;

        medicationHistory = new LinkedHashSet<>();
        appointmentHistory = new ArrayList<>();
    }

    /**
     * Agrega un medicamento al historial.
     *
     * @param medication medicamento a agregar
     */
    public void addMedication(String medication) {
        medicationHistory.add(medication);
    }

    /**
     * Elimina un medicamento del historial.
     *
     * @param medication medicamento a eliminar
     */
    public void removeMedication(String medication) {
        medicationHistory.remove(medication);
    }
    
    /**
     * Agrega una cita médica al historial.
     *
     * @param appointment cita médica a agregar
     */
    public void addAppointment(MedicalAppointment appointment) {
        appointmentHistory.add(appointment);
    }

    /**
     * Obtiene el tipo de identificación.
     *
     * @return tipo de identificación
     */
    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    /**
     * Obtiene el número de identificación.
     *
     * @return número de identificación
     */
    public int getIdPatient() {
        return idPatient;
    }

    /**
     * Obtiene el correo electrónico.
     *
     * @return correo electrónico
     */
    public String getEmail() {
        return email;
    }

    /**
     * Obtiene la prioridad del paciente.
     *
     * @return prioridad del paciente
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * Obtiene el historial de medicamentos.
     *
     * @return historial de medicamentos
     */
    public LinkedHashSet<String> getMedicationHistory() {
        return medicationHistory;
    }

    /**
     * Obtiene el historial de citas médicas.
     *
     * @return historial de citas
     */
    public ArrayList<MedicalAppointment> getAppointmentHistory() {
        return appointmentHistory;
    }

    /**
     * Obtiene el nombre completo del paciente.
     *
     * @return nombre completo
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * Retorna la información del paciente.
     *
     * @return información del paciente
     */
    @Override
    public String toString() {

        return "Tipo documento: " +
                identificationType +
                "\nNumero documento: " +
                idPatient +
                "\nNombre completo: " +
                getFullName() +
                "\nEmail: " +
                email +
                "\nPrioridad: " +
                priority +
                "\nHistorial medicamentos: " +
                medicationHistory +
                "\n";
    }
}