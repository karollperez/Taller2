package co.edu.uptc.domain;

import co.edu.uptc.enums.IdentificationType;

/**
 * Clase que representa un médico
 */
public class Doctor {

    private IdentificationType identificationType;
    private int medicalId;
    private String firstName;
    private String lastName;
    private String specialty;
    private int yearsOfExperience;

    public Doctor(IdentificationType identificationType,
                  int medicalId,
                  String firstName,
                  String lastName,
                  String specialty,
                  int yearsOfExperience) {

        this.identificationType = identificationType;
        this.medicalId = medicalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getMedicalId() {
        return medicalId;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {

        return identificationType +
                " - " +
                medicalId +
                " | " +
                getFullName() +
                " | Especialidad: " +
                specialty +
                " | Experiencia: " +
                yearsOfExperience;
    }
}