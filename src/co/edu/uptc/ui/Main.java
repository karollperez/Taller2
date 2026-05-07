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

            option = Integer.parseInt(JOptionPane.showInputDialog(
                    "CLINICA EL LAGUITO\n\n" +
                            "1. Registrar paciente\n" +
                            "2. Registrar doctor\n" +
                            "3. Registrar cita\n" +
                            "4. Agregar medicamento\n" +
                            "5. Ver citas ordenadas\n" +
                            "6. Ver médicos ordenados\n" +
                            "7. Salir"
            ));

            switch (option) {

            case 1:

                String patientTypeInput =
                        JOptionPane.showInputDialog(
                                "Tipo identificación:\n" +
                                "CC\nTI\nCE\nPA"
                        );

                IdentificationType patientType =
                        IdentificationType.valueOf(
                                patientTypeInput.toUpperCase()
                        );

                int idPatient = Integer.parseInt(
                        JOptionPane.showInputDialog(
                                "Número identificación:"
                        )
                );

                String firstName = JOptionPane.showInputDialog(
                        "Nombre:"
                );

                String lastName = JOptionPane.showInputDialog(
                        "Apellido:"
                );

                String email = JOptionPane.showInputDialog(
                        "Email:"
                );

                String priorityInput =
                        JOptionPane.showInputDialog(
                                "Prioridad:\n" +
                                "LOW\nMEDIUM\nHIGH\nCRITICAL"
                        );

                Priority patientPriority =
                        Priority.valueOf(
                                priorityInput.toUpperCase()
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

                String doctorTypeInput =
                        JOptionPane.showInputDialog(
                                "Tipo identificación:\n" +
                                "CC\nTI\nCE\nPA"
                        );

                IdentificationType doctorType =
                        IdentificationType.valueOf(
                                doctorTypeInput.toUpperCase()
                        );

                int doctorId = Integer.parseInt(
                        JOptionPane.showInputDialog(
                                "Número identificación:"
                        )
                );

                String doctorName = JOptionPane.showInputDialog(
                        "Nombre:"
                );

                String doctorLastName =
                        JOptionPane.showInputDialog(
                                "Apellido:"
                        );

                String specialty =
                        JOptionPane.showInputDialog(
                                "Especialidad:"
                        );

                int experience = Integer.parseInt(
                        JOptionPane.showInputDialog(
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
                            JOptionPane.showInputDialog("ID cita:")
                    );

                    String hour = JOptionPane.showInputDialog(
                            "Hora cita:"
                    );

                    int patientId = Integer.parseInt(
                            JOptionPane.showInputDialog("ID paciente:")
                    );

                    int docId = Integer.parseInt(
                            JOptionPane.showInputDialog("ID doctor:")
                    );

                    Patient existingPatient =
                            patientService.findPatient(patientId);

                    Doctor existingDoctor =
                            doctorService.findDoctor(docId);

                    if (existingPatient == null ||
                            existingDoctor == null) {

                        JOptionPane.showMessageDialog(null,
                                "Paciente o doctor no existe");

                        break;
                    }

                    Priority priority = Priority.valueOf(
                            JOptionPane.showInputDialog(
                                    "LOW, MEDIUM, HIGH, CRITICAL")
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
                        JOptionPane.showMessageDialog(null,
                                "Cita registrada");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Cita duplicada");
                    }

                    break;

                case 4:

                    int patientMedicationId =
                            Integer.parseInt(
                                    JOptionPane.showInputDialog(
                                            "ID paciente:")
                            );

                    Patient p =
                            patientService.findPatient(
                                    patientMedicationId);

                    if (p != null) {

                        String med =
                                JOptionPane.showInputDialog(
                                        "Medicamento:"
                                );

                        p.addMedication(med);

                        JOptionPane.showMessageDialog(null,
                                "Medicamento agregado");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Paciente no encontrado");
                    }

                    break;

                case 5:

                    ArrayList<MedicalAppointment> appointments =
                            appointmentService
                                    .getAppointmentsOrdered();

                    String infoAppointments = "";

                    for (MedicalAppointment m : appointments) {
                        infoAppointments += m + "\n";
                    }

                    JOptionPane.showMessageDialog(null,
                            infoAppointments);

                    break;

                case 6:

                    ArrayList<Doctor> doctors =
                            doctorService.getDoctorsOrdered();

                    String infoDoctors = "";

                    for (Doctor d : doctors) {
                        infoDoctors += d + "\n";
                    }

                    JOptionPane.showMessageDialog(null,
                            infoDoctors);

                    break;
            }

        } while (option != 7);

        JOptionPane.showMessageDialog(null,
                "Sistema finalizado");
    }
}