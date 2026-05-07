package co.edu.uptc.domain;

import co.edu.uptc.enums.IdentificationType;
import co.edu.uptc.enums.Priority;

import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * Clase que representa un paciente
 */
public class Patient {

    private IdentificationType identificationType;
    private int idPatient;
    private String firstName;
    private String lastName;
    private String email;
    private LinkedHashSet<String> medicationHistory;
    private ArrayList<MedicalAppointment> appointmentHistory;
    private Priority priority;

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

    public void addMedication(String medication) {
        medicationHistory.add(medication);
    }

    public void addAppointment(MedicalAppointment appointment) {
        appointmentHistory.add(appointment);
    }

    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public String getEmail() {
        return email;
    }

    public Priority getPriority() {
        return priority;
    }

    public LinkedHashSet<String> getMedicationHistory() {
        return medicationHistory;
    }

    public ArrayList<MedicalAppointment> getAppointmentHistory() {
        return appointmentHistory;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

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