package co.edu.uptc.domain;

import java.util.Set;
import co.edu.uptc.enums.*;

/**
 * <b>Descripción: </b> Clase de modelo que representa la información de un paciente <br>
 * Contiene datos personales, tipo de identificación, prioridad y su historial de medicamentos.
 * 
 * @author 
 */
public class Patient {

    /** Atributo que determina el tipo de identificación del paciente */
    private IdentificationType identificationType;

    /** Atributo que determina el ID único del paciente */
    private int idPatient;

    /** Atributo que determina el nombre del paciente */
    private String firstName;

    /** Atributo que determina el apellido del paciente */
    private String lastName;

    /** Atributo que determina el correo electrónico del paciente */
    private String email;

    /** Atributo que determina la prioridad del paciente */
    private Priority priority;

    /** Atributo que almacena el historial de medicamentos (sin duplicados y en orden) */
    private Set<String> medicationHistory;

    /**
     * <b>Description: </b> Constructor de la clase<br>
     * 
     * @param identificationType Tipo de identificación del paciente
     * @param idPatient Identificación única del paciente
     * @param firstName Nombre del paciente
     * @param lastName Apellido del paciente
     * @param email Correo electrónico del paciente
     * @param priority Prioridad del paciente
     * @param medicationHistory Historial de medicamentos del paciente
     */
    public Patient(IdentificationType identificationType, int idPatient, String firstName, String lastName, String email,
            Priority priority, Set<String> medicationHistory) {
        super();
        this.identificationType = identificationType;
        this.idPatient = idPatient;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.priority = priority;
        this.medicationHistory = medicationHistory;
    }

    /**
     * <b>Description: </b> Retorna el tipo de identificación del paciente
     * @return identificationType Tipo de identificación
     */
    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    /**
     * <b>Description: </b> Asigna el tipo de identificación del paciente<br>
     * @param identificationType Nuevo tipo de identificación
     */
    public void setIdentificationType(IdentificationType identificationType) {
        this.identificationType = identificationType;
    }

    /**
     * <b>Description: </b> Retorna el ID del paciente
     * @return idPatient Identificación del paciente
     */
    public int getIdPatient() {
        return idPatient;
    }

    /**
     * <b>Description: </b> Asigna un nuevo ID al paciente<br>
     * @param idPatient Nuevo identificador del paciente
     */
    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    /**
     * <b>Description: </b> Retorna el nombre del paciente
     * @return firstName Nombre del paciente
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * <b>Description: </b> Asigna el nombre del paciente<br>
     * @param firstName Nuevo nombre del paciente
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * <b>Description: </b> Retorna el apellido del paciente
     * @return lastName Apellido del paciente
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * <b>Description: </b> Asigna el apellido del paciente<br>
     * @param lastName Nuevo apellido del paciente
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * <b>Description: </b> Retorna el correo electrónico del paciente
     * @return email Correo del paciente
     */
    public String getEmail() {
        return email;
    }

    /**
     * <b>Description: </b> Asigna el correo electrónico del paciente<br>
     * @param email Nuevo correo del paciente
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * <b>Description: </b> Retorna la prioridad del paciente
     * @return priority Prioridad del paciente
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * <b>Description: </b> Asigna la prioridad del paciente<br>
     * @param priority Nueva prioridad del paciente
     */
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    /**
     * <b>Description: </b> Retorna el historial de medicamentos
     * @return medicationHistory Conjunto de medicamentos del paciente
     */
    public Set<String> getMedicationHistory() {
        return medicationHistory;
    }

    /**
     * <b>Description: </b> Asigna el historial de medicamentos<br>
     * @param medicationHistory Nuevo historial de medicamentos
     */
    public void setMedicationHistory(Set<String> medicationHistory) {
        this.medicationHistory = medicationHistory;
    }
}