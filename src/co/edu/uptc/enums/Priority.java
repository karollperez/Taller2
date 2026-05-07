package co.edu.uptc.enums;

/**
 * Enum que representa los niveles de prioridad
 */
public enum Priority {

    LOW(0),
    MEDIUM(1),
    HIGH(2),
    CRITICAL(3);

    private int level;

    Priority(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}