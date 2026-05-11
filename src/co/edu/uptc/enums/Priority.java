package co.edu.uptc.enums;

/**
 * Enum que representa los niveles de prioridad.
 * Define el nivel de urgencia dentro del sistema.
 *
 * @author Karoll Daniela Pérez Ortiz
 * @version 1.0
 * @since JDK 21
 */
public enum Priority {

    LOW(0),
    MEDIUM(1),
    HIGH(2),
    CRITICAL(3);

    /**
     * Nivel numérico de la prioridad.
     */
    private int level;

    /**
     * Constructor del enum Priority.
     *
     * @param level nivel de prioridad
     */
    Priority(int level) {
        this.level = level;
    }

    /**
     * Obtiene el nivel de prioridad.
     *
     * @return nivel de prioridad
     */
    public int getLevel() {
        return level;
    }
}