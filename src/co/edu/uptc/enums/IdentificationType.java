package co.edu.uptc.enums;

/**
 * Enum que representa los tipos de identificación.
 * Define los documentos permitidos en el sistema.
 *
 * @author Karoll Daniela Pérez Ortiz
 * @version 1.0
 * @since JDK 21
 */
public enum IdentificationType {

    CC("Cedula de ciudadania"),
    TI("Tarjeta de identidad"),
    CE("Cedula de extranjeria"),
    PA("Pasaporte");

    /**
     * Descripción del tipo de identificación.
     */
    private String description;

    /**
     * Constructor del enum IdentificationType.
     *
     * @param description descripción del tipo de identificación
     */
    IdentificationType(String description) {
        this.description = description;
    }

    /**
     * Obtiene la descripción del tipo de identificación.
     *
     * @return descripción del tipo de identificación
     */
    public String getDescription() {
        return description;
    }
}