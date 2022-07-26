package com.example.healthcare.service;


import com.example.healthcare.exception.DiagnosticCenterNotFoundException;
import com.example.healthcare.exception.DiagnosticTestNotFoundException;
import com.example.healthcare.entities.Appointment;
import com.example.healthcare.entities.DiagnosticCenter;
import com.example.healthcare.entities.DiagnosticTest;
import com.example.healthcare.entities.Patient;
import com.example.healthcare.dao.AppointmentRepository;
import com.example.healthcare.dao.DiagnosticCenterRepository;
import com.example.healthcare.dao.DiagnosticTestRepository;
import com.example.healthcare.dao.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    private AppointmentRepository appointmentrepository;
    private PatientRepository patientRepository;
    private DiagnosticCenterService diagnosticCenterService;
    private DiagnosticCenterRepository diagnosticCenterRepository;
    private DiagnosticTestRepository diagnosticTestRepository;
    private PatientService patientService;
    private  DiagnosticTestService diagnosticTestService;



    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentrepository.findAll();
    }
    @Override
    public Appointment addAppointment(Appointment appointment)
    {
        appointmentrepository.save(appointment);
        return appointment;
    }
    @Override
    public Set<Appointment> viewAppointments(String patientName)
    {
        Patient patient=patientRepository.findByName(patientName).get(0);
        return (Set<Appointment>) patient.getAppointmentList();

    }
    public Optional<Appointment> viewAppointment (int appointmentid)
    {
        Optional<Appointment> optionalAppointment= appointmentrepository.findById(appointmentid);
        if (optionalAppointment.isPresent())
            return optionalAppointment;
        else
            return optionalAppointment;
    }
    public Appointment updateAppointment(Appointment appointment){
        Appointment appointment1 = null;
        Optional<Appointment> optionalAppointment = appointmentrepository.findById(appointment.getId());
        if (optionalAppointment.isPresent())
            appointment1 = optionalAppointment.get();
        appointment1.setDate(appointment.getDate());
        appointment1.setApprovalStatus(appointment.isApprovalStatus());

        appointmentrepository.save(appointment1);
        return appointment1;
    }

//    @Override
//    public List<Appointment> getAppointmentList(int centreid, String test, boolean status) {
//        return null;
//    }

//    @Override
//    public List<Appointment> getAppointmentList(int centreid, String test, boolean status) {
//        return null;
//    }

        public List<Appointment> getAppointmentList(int centreId ,String test,boolean status)
    {
        Optional<DiagnosticCenter> diagnosticCenter=diagnosticCenterRepository.findById(centreId);
        List<Appointment> appointments=diagnosticCenterService.getListOfAppointments(diagnosticCenter.get().getName());
        List<Appointment> appointments1=appointments.stream().filter(appointment -> appointment.isApprovalStatus()==status).filter(appointment -> appointment.getTestResults().equals(diagnosticTestRepository.findByTestName(test))).collect(Collectors.toList());
        return appointments1;
    }
//    public Appointment removeAppointment(Appointment appointment)
//    {
//        Optional<Appointment> appointmentOptional=appointmentrepository.findById(appointment.getId());
//        if(appointmentOptional.isPresent()) {
//            appointmentrepository.deleteById(appointment.getId());
//            return appointment;
//        }
//        else{
//            return null;
//        }
//    }



    @Override
    public List<Appointment> removeAppointment(Integer id) {
        Appointment ac = null;
        Optional<Appointment> optionalAppointment = appointmentrepository.findById(id);
        if (optionalAppointment.isPresent())
            ac = optionalAppointment.get();
        appointmentrepository.deleteById(id);
        return appointmentrepository.findAll();
    }

    @Override
    public Appointment addAppointment(int patientId, int testCenterid, int testId, String date) throws DiagnosticTestNotFoundException, DiagnosticCenterNotFoundException {
        System.out.println(patientId);
        System.out.println(testCenterid);
        System.out.println(testId);
        System.out.println(date);
        Patient patient=patientService.viewPatient(patientId);
        System.out.println(patient.toString());
       DiagnosticCenter diagnosticCenter=diagnosticCenterService.getDiagnosticCenterById(testCenterid);
        System.out.println(diagnosticCenter);
       DiagnosticTest diagnosticTest= diagnosticCenterService.getDiagnosticTestById(testId);
        System.out.println(diagnosticTest);
       Appointment appointment=new Appointment();
       appointment.setApprovalStatus(false);
       appointment.setPatient((Set<Patient>) patient);
       appointment.setDate(date);
      appointment.setDiagnosticCenter((Set<DiagnosticCenter>) diagnosticCenter);
       appointment.setDiagnosticTests(diagnosticTest);
        System.out.println(appointment.toString());
       appointmentrepository.save(appointment);
       return appointment;


    }

}



