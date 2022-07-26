package com.example.healthcare.controller;

import com.example.healthcare.entities.Appointment;
import com.example.healthcare.service.AppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/add")
    public ResponseEntity<Appointment> addAppointment(@Valid @RequestBody Appointment appointment)
    {
        appointmentService.addAppointment(appointment);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

//    @GetMapping("/viewAllAppointment/{patientName}")
//    public Set<Appointment>viewAllAppointment(@PathVariable String patientName)
//    {
//        Set<Appointment> appointments=appointmentService.viewAppointments();
//        return new ResponseEntity<>(appointments,HttpStatus.ACCEPTED);
//        return ResponseEntity.ok(this.appointmentService.viewAppointments(patientName));
//        return appointmentService.viewAppointments(patientName);
//    }

//    @DeleteMapping("/delete-by-id")
//    public ResponseEntity<Appointment> removeAppointment(@RequestBody Appointment appointment)
//    {
//        Appointment appointments=appointmentService.removeAppointment(appointment);
//        return new ResponseEntity<>(appointments,HttpStatus.NO_CONTENT);
//    }
//    @GetMapping("/view/{id}")
//    public ResponseEntity<Optional<Appointment>> viewAppointment(@PathVariable  int id)
//    {
//
//        Optional<Appointment> appointments =appointmentService.viewAppointment(id);
//        return new ResponseEntity<>(appointments,HttpStatus.UPGRADE_REQUIRED);
//    }


    @DeleteMapping("/remove/{id}")
    public List<Appointment> removeAppointment(@PathVariable Integer id)
    {
        return appointmentService.removeAppointment(id);
    }


    @GetMapping("/getall")
    public ResponseEntity<List<Appointment>> getAllAppointments()
    {
        return ResponseEntity.ok(this.appointmentService.getAllAppointments());

    }

    @PutMapping ("/update")
    public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment)
    {
        Appointment appointments =appointmentService.updateAppointment(appointment);
        return new ResponseEntity<>(appointments,HttpStatus.UPGRADE_REQUIRED);
    }
    @GetMapping("view list of appointment  ")
    public ResponseEntity<List<Appointment>> getAppointmentList(@PathVariable int id, @PathVariable String test,@PathVariable boolean Status)
    {
        return ResponseEntity.ok(this.appointmentService.getAppointmentList(id,test,Status));
    }
}