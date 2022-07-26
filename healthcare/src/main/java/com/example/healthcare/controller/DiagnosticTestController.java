//package com.example.healthcare.controller;
//
//import com.example.healthcare.entities.DiagnosticTest;
//import com.example.healthcare.service.DiagnosticTestService;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//import java.util.Set;
//
//@Slf4j
//@RestController
//@RequestMapping("DiagnosticTest")
//public class DiagnosticTestController {
//    @Autowired
//    private DiagnosticTestService diagnosticTestService;
//
//    @ApiOperation("Get all the test")
//    @GetMapping("/getall")
//
//    public List<DiagnosticTest> getAllTest(){
//        log.info("Fetch all the tests");
//        return diagnosticTestService.getAllTest();
//    }
//
//    @ApiOperation("Add new Test")
//    @PostMapping("/adddiagnostictest")
//    public ResponseEntity<DiagnosticTest> addNewTest(@Valid @RequestBody DiagnosticTest test){
//        DiagnosticTest newTest = diagnosticTestService.addNewTest(test);
//        log.info("Added new test");
//        return new ResponseEntity<>(newTest, HttpStatus.CREATED);
//    }
//
//    @ApiOperation("Get test of Diagnostic center")
//    @GetMapping("/gettestofdiagnosticcenter/{centerId}")
//    public Set<DiagnosticTest> getTestOfDiagnosticCenter(@PathVariable int centerId){
//        log.info("Fectch Test of Diagnostic Center");
//        return diagnosticTestService.getTestOfDiagnosticCenter(centerId);
//    }
//
//    @ApiOperation("Update test")
//    @PutMapping("/updatediagnostictest/{id}")
//    public ResponseEntity<DiagnosticTest> updateTestDetails(@PathVariable int id,@Valid @RequestBody DiagnosticTest test){
//        DiagnosticTest updateDiagnosticTest = diagnosticTestService.updateTestDetails(id,test);
//        log.info("Update Diagnostic Test Details");
//        return new ResponseEntity<>(updateDiagnosticTest,HttpStatus.ACCEPTED);
//    }
//
//    @ApiOperation("Remove test from diagnostic center")
//    @DeleteMapping("/removediagnostictest")
//    public ResponseEntity<DiagnosticTest> removeTestFormDiagnosticCenter(@Valid @RequestBody DiagnosticTest test){
//        DiagnosticTest removeTest = diagnosticTestService.removeTestFormDiagnosticTest(test);
//        log.info("Remove test");
//        return new ResponseEntity<>(removeTest,HttpStatus.NO_CONTENT);
//    }
//
//}
