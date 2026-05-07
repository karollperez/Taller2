package co.edu.uptc.enums;

/**
 * Enum de tipos de identificación
 */
public enum IdentificationType {

    CC("Cedula de ciudadania"),
    TI("Tarjeta de identidad"),
    CE("Cedula de extranjeria"),
    PA("Pasaporte");

    private String description;

    IdentificationType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}