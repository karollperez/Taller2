package co.edu.uptc.domain;

import co.edu.uptc.enums.IdentificationType;

/**
 * Clase que representa un médico.
 * Permite almacenar sus datos básicos.
 *
 * @author Karoll Daniela Pérez Ortiz
 * @version 1.0
 * @since JDK 21
 */
public class Doctor {
	
	

    /**
     * Tipo de identificación del médico.
     */
    private IdentificationType identificationType;

    /**
     * Identificación médica.
     */
    private int medicalId;

    /**
     * Nombre del médico.
     */
    private String firstName;

    /**
     * Apellido del médico.
     */
    private String lastName;

    /**
     * Especialidad del médico.
     */
    private String specialty;

    /**
     * Años de experiencia.
     */
    private int yearsOfExperience;

    /**
     * Constructor de la clase Doctor.
     *
     * @param identificationType tipo de identificación
     * @param medicalId identificación médica
     * @param firstName nombre del médico
     * @param lastName apellido del médico
     * @param specialty especialidad médica
     * @param yearsOfExperience años de experiencia
     */
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

    /**
     * Obtiene la identificación médica.
     *
     * @return identificación médica
     */
    public int getMedicalId() {
        return medicalId;
    }

    /**
     * Obtiene los años de experiencia.
     *
     * @return años de experiencia
     */
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    /**
     * Obtiene el nombre completo del médico.
     *
     * @return nombre completo
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * Retorna la información del médico.
     *
     * @return información del médico
     */
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