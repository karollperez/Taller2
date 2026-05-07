package co.edu.uptc.ui;

import co.edu.uptc.domain.*;
import co.edu.uptc.enums.*;
import co.edu.uptc.service.*;

import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 * Clase principal del sistema
 */
public class Main {

    public static void main(String[] args) {

        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        AppointmentService appointmentService =
                new AppointmentService();

        // MATRIZ DE TURNOS
        String[][] medicalAgenda = new String[5][8];

        int option;

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
                    "8. Salir";

            option = Integer.parseInt(
                    JOptionPane.showInputDialog(null,
                            menu,
                            "MENÚ PRINCIPAL",
                            JOptionPane.QUESTION_MESSAGE)
            );

            switch (option) {

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

                    int idPatient = Integer.parseInt(
                            JOptionPane.showInputDialog(
                                    null,
                                    "Número identificación:"
                            )
                    );

                    String firstName = JOptionPane.showInputDialog(
                            null,
                            "Nombre:"
                    );

                    String lastName = JOptionPane.showInputDialog(
                            null,
                            "Apellido:"
                    );

                    String email = JOptionPane.showInputDialog(
                            null,
                            "Email:"
                    );

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

                    int doctorId = Integer.parseInt(
                            JOptionPane.showInputDialog(
                                    null,
                                    "Número identificación:"
                            )
                    );

                    String doctorName = JOptionPane.showInputDialog(
                            null,
                            "Nombre:"
                    );

                    String doctorLastName =
                            JOptionPane.showInputDialog(
                                    null,
                                    "Apellido:"
                            );

                    String specialty =
                            JOptionPane.showInputDialog(
                                    null,
                                    "Especialidad:"
                            );

                    int experience = Integer.parseInt(
                            JOptionPane.showInputDialog(
                                    null,
                                    "Años experiencia:"
                            )
                    );

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

                case 3:

                    int appointmentId = Integer.parseInt(
                            JOptionPane.showInputDialog(
                                    null,
                                    "ID cita:"
                            )
                    );

                    String hour = JOptionPane.showInputDialog(
                            null,
                            "Hora cita:"
                    );

                    int patientId = Integer.parseInt(
                            JOptionPane.showInputDialog(
                                    null,
                                    "ID paciente:"
                            )
                    );

                    int docId = Integer.parseInt(
                            JOptionPane.showInputDialog(
                                    null,
                                    "ID doctor:"
                            )
                    );

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

                case 4:

                    int patientMedicationId =
                            Integer.parseInt(
                                    JOptionPane.showInputDialog(
                                            null,
                                            "ID paciente:"
                                    )
                            );

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

                case 5:

                    ArrayList<MedicalAppointment> appointments =
                            appointmentService
                                    .getAppointmentsOrdered();

                    String infoAppointments = "";

                    for (MedicalAppointment m : appointments) {

                        infoAppointments +=
                                m +
                                "\n";
                    }

                    JOptionPane.showMessageDialog(
                            null,
                            infoAppointments
                    );

                    break;

                case 6:

                    ArrayList<Doctor> doctors =
                            doctorService.getDoctorsOrdered();

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

                case 7:

                    ArrayList<Patient> patients =
                            patientService.getPatientsOrdered();

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
            }

        } while (option != 8);

        JOptionPane.showMessageDialog(
                null,
                "Sistema finalizado"
        );
    }
}

