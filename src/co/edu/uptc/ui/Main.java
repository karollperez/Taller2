package co.edu.uptc.ui;

import co.edu.uptc.domain.*;
import co.edu.uptc.enums.*;
import co.edu.uptc.service.*;

import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 * Clase principal del sistema de la clínica.
 * Permite gestionar pacientes, médicos, citas médicas
 * y medicamentos mediante un menú interactivo.
 *
 * @author Karoll Daniela Pérez Ortiz
 * @version 1.0
 * @since JDK 21
 */
public class Main {

    /**
     * Método principal del sistema.
     * Ejecuta el menú principal y controla las opciones
     * disponibles para el registro y gestión de información.
     *
     * Funcionalidades disponibles:
     * <ul>
     * <li>Registrar pacientes</li>
     * <li>Registrar médicos</li>
     * <li>Registrar citas médicas</li>
     * <li>Agregar y eliminar medicamentos</li>
     * <li>Visualizar información ordenada</li>
     * <li>Eliminar pacientes y médicos</li>
     * </ul>
     *
     * @param args argumentos de ejecución del programa
     */
    public static void main(String[] args) {

        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        AppointmentService appointmentService =
                new AppointmentService();


        int option = 0;

        do {

        	String menu =
        	        "CLINICA EL LAGUITO\n\n" +
        	        "1. Registrar paciente\n" +
        	        "2. Registrar doctor\n" +
        	        "3. Registrar cita\n" +
        	        "4. Agregar medicamento\n" +
        	        "5. Ver citas ordenadas\n" +
        	        "6. Ver médicos ordenados\n" +
        	        "7. Ver pacientes registrados\n" +
        	        "8. Eliminar paciente\n" +
        	        "9. Eliminar doctor\n" +
        	        "10. Eliminar medicamento\n" +
        	        "11. Salir";

        	String optionInput = (String) JOptionPane.showInputDialog(
        	        null,
        	        menu,
        	        "MENÚ PRINCIPAL",
        	        JOptionPane.QUESTION_MESSAGE,
        	        null,
        	        null,
        	        ""
        	);

        	if (optionInput == null) {
        	    optionInput = "";
        	}
        	
        	if (optionInput.trim().isEmpty()) {

        	    JOptionPane.showMessageDialog(
        	            null,
        	            "Debes ingresar una opción"
        	    );

        	    continue;
        	}
        	
        	while (!optionInput.matches("\\d+")) {

        	    JOptionPane.showMessageDialog(
        	            null,
        	            "Solo se permiten numeros"
        	    );
        	    
        	    optionInput = JOptionPane.showInputDialog(
        	            null,
        	            menu,
        	            "MENÚ PRINCIPAL",
        	            JOptionPane.QUESTION_MESSAGE
        	    );

        	    if (optionInput == null) {
        	        break;
        	    }
        	}

        	if (optionInput == null) {
        	    continue;
        	}

        	option = Integer.parseInt(optionInput);

            switch (option) {
            
            
         // Registro de pacientes
            case 1:

                IdentificationType patientType =
                        (IdentificationType) JOptionPane.showInputDialog(
                                null,
                                "Seleccione el tipo de identificación",
                                "TIPO IDENTIFICACIÓN",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                IdentificationType.values(),
                                IdentificationType.CC
                        );

                if (patientType == null) {
                    break;
                }

                String idInput;

                do {

                    idInput = JOptionPane.showInputDialog(
                            null,
                            "Número identificación:"
                    );

                    if (idInput == null) {
                        break;
                    }

                    if (!idInput.matches("\\d+")) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Solo se permiten numeros"
                        );
                    }

                } while (!idInput.matches("\\d+"));

                if (idInput == null) {
                    break;
                }

                int idPatient = Integer.parseInt(idInput);

                String firstName;

                do {

                    firstName = JOptionPane.showInputDialog(
                            null,
                            "Nombre:"
                    );

                    if (firstName == null) {
                        break;
                    }

                    if (!firstName.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Solo puedes ingresar caracteres"
                        );
                    }

                } while (!firstName.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"));

                if (firstName == null) {
                    break;
                }

                String lastName = JOptionPane.showInputDialog(
                        null,
                        "Apellido:"
                );

                if (lastName == null) {
                    break;
                }

                String email = JOptionPane.showInputDialog(
                        null,
                        "Email:"
                );

                if (email == null) {
                    break;
                }

                Priority patientPriority =
                        (Priority) JOptionPane.showInputDialog(
                                null,
                                "Seleccione la prioridad",
                                "PRIORIDAD",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                Priority.values(),
                                Priority.LOW
                        );

                if (patientPriority == null) {
                    break;
                }

                Patient patient = new Patient(
                        patientType,
                        idPatient,
                        firstName,
                        lastName,
                        email,
                        patientPriority
                );

                boolean addedPatient =
                        patientService.registerPatient(patient);

                if (addedPatient) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Paciente registrado"
                    );

                } else {

                    JOptionPane.showMessageDialog(
                            null,
                            "Paciente duplicado"
                    );
                }

                break;

            // Registro de doctores
            case 2:

                IdentificationType doctorType =
                        (IdentificationType) JOptionPane.showInputDialog(
                                null,
                                "Seleccione el tipo de identificación",
                                "TIPO IDENTIFICACIÓN",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                IdentificationType.values(),
                                IdentificationType.CC
                        );

                if (doctorType == null) {
                    break;
                }

                String doctorIdInput = JOptionPane.showInputDialog(
                        null,
                        "Número identificación:"
                );

                if (doctorIdInput == null) {
                    break;
                }

                int doctorId = Integer.parseInt(doctorIdInput);

                String doctorName = JOptionPane.showInputDialog(
                        null,
                        "Nombre:"
                );

                if (doctorName == null) {
                    break;
                }

                String doctorLastName =
                        JOptionPane.showInputDialog(
                                null,
                                "Apellido:"
                        );

                if (doctorLastName == null) {
                    break;
                }

                String specialty =
                        JOptionPane.showInputDialog(
                                null,
                                "Especialidad:"
                        );

                if (specialty == null) {
                    break;
                }

                String experienceInput =
                        JOptionPane.showInputDialog(
                                null,
                                "Años experiencia:"
                        );

                if (experienceInput == null) {
                    break;
                }

                int experience = Integer.parseInt(experienceInput);

                Doctor doctor = new Doctor(
                        doctorType,
                        doctorId,
                        doctorName,
                        doctorLastName,
                        specialty,
                        experience
                );

                boolean addedDoctor =
                        doctorService.registerDoctor(doctor);

                if (addedDoctor) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Doctor registrado"
                    );

                } else {

                    JOptionPane.showMessageDialog(
                            null,
                            "Doctor duplicado"
                    );
                }

                break;

             // Registro de citas médicas
            case 3:

                String appointmentInput =
                        JOptionPane.showInputDialog(
                                null,
                                "ID cita:"
                        );

                if (appointmentInput == null) {
                    break;
                }

                int appointmentId =
                        Integer.parseInt(appointmentInput);

                String hour = JOptionPane.showInputDialog(
                        null,
                        "Hora cita:"
                );

                if (hour == null) {
                    break;
                }

                String patientIdInput =
                        JOptionPane.showInputDialog(
                                null,
                                "ID paciente:"
                        );

                if (patientIdInput == null) {
                    break;
                }

                int patientId =
                        Integer.parseInt(patientIdInput);

                String docIdInput =
                        JOptionPane.showInputDialog(
                                null,
                                "ID doctor:"
                        );

                if (docIdInput == null) {
                    break;
                }

                int docId =
                        Integer.parseInt(docIdInput);

                Patient existingPatient =
                        patientService.findPatient(patientId);

                Doctor existingDoctor =
                        doctorService.findDoctor(docId);

                if (existingPatient == null ||
                        existingDoctor == null) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Paciente o doctor no existe"
                    );

                    break;
                }

                Priority priority =
                        (Priority) JOptionPane.showInputDialog(
                                null,
                                "Seleccione la prioridad",
                                "PRIORIDAD",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                Priority.values(),
                                Priority.LOW
                        );

                if (priority == null) {
                    break;
                }

                MedicalAppointment appointment =
                        new MedicalAppointment(
                                appointmentId,
                                hour,
                                existingPatient,
                                existingDoctor,
                                priority
                        );

                boolean addedAppointment =
                        appointmentService
                                .registerAppointment(appointment);

                if (addedAppointment) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Cita registrada"
                    );

                } else {

                    JOptionPane.showMessageDialog(
                            null,
                            "Cita duplicada"
                    );
                }

                break;

                
            // Agregar medicamento a un paciente
            case 4:

                String patientMedicationInput =
                        JOptionPane.showInputDialog(
                                null,
                                "ID paciente:"
                        );

                if (patientMedicationInput == null) {
                    break;
                }

                int patientMedicationId =
                        Integer.parseInt(patientMedicationInput);

                Patient p =
                        patientService.findPatient(
                                patientMedicationId
                        );

                if (p != null) {

                    String med =
                            JOptionPane.showInputDialog(
                                    null,
                                    "Medicamento:"
                            );

                    if (med == null) {
                        break;
                    }

                    p.addMedication(med);

                    JOptionPane.showMessageDialog(
                            null,
                            "Medicamento agregado"
                    );

                } else {

                    JOptionPane.showMessageDialog(
                            null,
                            "Paciente no encontrado"
                    );
                }

                break;
                
             // Mostrar citas ordenadas por prioridad
                case 5:

                	ArrayList<MedicalAppointment> appointments =
                    appointmentService
                            .getAppointmentsOrdered();

            if (appointments.isEmpty()) {

                JOptionPane.showMessageDialog(
                        null,
                        "No hay citas registradas"
                );

                break;
            }

            String infoAppointments = "";

                    int turno = 1;

                    for (MedicalAppointment m : appointments) {

                        infoAppointments +=
                                "Turno #" + turno +
                                "\nPaciente: " + m.getPatient().getFullName() +
                                "\nDoctor: " + m.getDoctor().getFullName() +
                                "\nHora: " + m.getTimeAppointment() +
                                "\nPrioridad: " + m.getPriority() +
                                "\n----------------------\n";

                        turno++;
                    }

                    JOptionPane.showMessageDialog(
                            null,
                            infoAppointments
                    );

                    break;

               // Mostrar médicos ordenados
                case 6:

                	ArrayList<Doctor> doctors =
                    doctorService.getDoctorsOrdered();

            if (doctors.isEmpty()) {

                JOptionPane.showMessageDialog(
                        null,
                        "No hay doctores registrados"
                );

                break;
            }

            String infoDoctors = "";

                    for (Doctor d : doctors) {

                        infoDoctors +=
                                d +
                                "\n";
                    }

                    JOptionPane.showMessageDialog(
                            null,
                            infoDoctors
                    );

                    break;

               // Mostrar pacientes registrados
                case 7:

                	ArrayList<Patient> patients =
                    patientService.getPatientsOrdered();

            if (patients.isEmpty()) {

                JOptionPane.showMessageDialog(
                        null,
                        "No hay pacientes registrados"
                );

                break;
            }

            String infoPatients = "";

                    for (Patient patientInfo : patients) {

                        infoPatients +=
                                patientInfo +
                                "\n------------------------\n";
                    }

                    JOptionPane.showMessageDialog(
                            null,
                            infoPatients
                    );

                    break;
                    
               // Eliminar paciente
                case 8:

                    ArrayList<Patient> patientsDelete =
                            patientService.getPatientsOrdered();

                    if (patientsDelete.isEmpty()) {

                        JOptionPane.showMessageDialog(
                                null,
                                "No hay pacientes registrados"
                        );

                        break;
                    }

                    String deletePatientInput =
                            JOptionPane.showInputDialog(
                                    null,
                                    "ID paciente a eliminar:"
                            );

                    if (deletePatientInput == null) {
                        break;
                    }

                    if (!deletePatientInput.matches("\\d+")) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Solo se permiten numeros"
                        );

                        break;
                    }

                    boolean deletedPatient =
                            patientService.deletePatient(
                                    Integer.parseInt(deletePatientInput)
                            );

                    if (deletedPatient) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Paciente eliminado"
                        );

                    } else {

                        JOptionPane.showMessageDialog(
                                null,
                                "Paciente no encontrado"
                        );
                    }

                    break;
                    
                 
               // Eliminar doctor
                case 9:

                    ArrayList<Doctor> doctorsDelete =
                            doctorService.getDoctorsOrdered();

                    if (doctorsDelete.isEmpty()) {

                        JOptionPane.showMessageDialog(
                                null,
                                "No hay doctores registrados"
                        );

                        break;
                    }

                    String deleteDoctorInput =
                            JOptionPane.showInputDialog(
                                    null,
                                    "ID doctor a eliminar:"
                            );

                    if (deleteDoctorInput == null) {
                        break;
                    }

                    if (!deleteDoctorInput.matches("\\d+")) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Solo se permiten numeros"
                        );

                        break;
                    }

                    boolean deletedDoctor =
                            doctorService.deleteDoctor(
                                    Integer.parseInt(deleteDoctorInput)
                            );

                    if (deletedDoctor) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Doctor eliminado"
                        );

                    } else {

                        JOptionPane.showMessageDialog(
                                null,
                                "Doctor no encontrado"
                        );
                    }

                    break;
                    
               // Eliminar medicamento del historial      
                case 10:

                    ArrayList<Patient> patientsMedication =
                            patientService.getPatientsOrdered();

                    if (patientsMedication.isEmpty()) {

                        JOptionPane.showMessageDialog(
                                null,
                                "No hay pacientes registrados"
                        );

                        break;
                    }

                    String medicationPatientInput =
                            JOptionPane.showInputDialog(
                                    null,
                                    "ID paciente:"
                            );

                    if (medicationPatientInput == null) {
                        break;
                    }

                    if (!medicationPatientInput.matches("\\d+")) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Solo se permiten numeros"
                        );

                        break;
                    }

                    Patient medicationPatient =
                            patientService.findPatient(
                                    Integer.parseInt(medicationPatientInput)
                            );

                    if (medicationPatient == null) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Paciente no encontrado"
                        );

                        break;
                    }

                    if (medicationPatient.getMedicationHistory().isEmpty()) {

                        JOptionPane.showMessageDialog(
                                null,
                                "El paciente no tiene medicamentos registrados"
                        );

                        break;
                    }

                    String medicationDelete =
                            JOptionPane.showInputDialog(
                                    null,
                                    "Medicamento a eliminar:"
                            );

                    if (medicationDelete == null) {
                        break;
                    }

                    medicationPatient.removeMedication(
                            medicationDelete
                    );

                    JOptionPane.showMessageDialog(
                            null,
                            "Medicamento eliminado"
                    );

                    break;
            }

            
       //salir del programa
        } while (option != 11);

        JOptionPane.showMessageDialog(
                null,
                "Sistema finalizado"
        );
    }
}

