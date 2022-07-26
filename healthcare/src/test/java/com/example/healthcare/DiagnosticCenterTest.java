package com.example.healthcare;

import com.example.healthcare.exception.DiagnosticCenterNotFoundException;
import com.example.healthcare.exception.DiagnosticTestNotFoundException;
import com.example.healthcare.entities.DiagnosticCenter;
import com.example.healthcare.service.DiagnosticCenterService;
import com.example.healthcare.service.TestService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Rollback(value = true)
public class DiagnosticCenterTest {

    @Autowired DiagnosticCenterService diagnosticCenterService;
    @Autowired TestService testService;

    @Test
    public void getAllDiagnosticCentersTest(){
        DiagnosticCenter dc= new DiagnosticCenter("HC Diagnostic","88888888888","Kolkata","abcd.@gmail.com");
        diagnosticCenterService.addDiagnosticCenter(dc);
        Assert.assertNotNull(diagnosticCenterService.getAllDiagnosticCenters());
    }

    @Test
    public void addDiagnosticCenterTest(){
        DiagnosticCenter dc= new DiagnosticCenter("HC Diagnostic","88888888888","Kolkata","abcd.@gmail.com");
        Assert.assertEquals(dc,diagnosticCenterService.addDiagnosticCenter(dc));
    }

    @Test
    public void getDiagnosticCenterByIdTest() throws DiagnosticTestNotFoundException, DiagnosticCenterNotFoundException {


        DiagnosticCenter dc= diagnosticCenterService.getDiagnosticCenterById(1);
        Assert.assertEquals("Sen Diagnostics",dc.getName());

    }

    @Test
    public void updateDiagnosticCenterTest() throws DiagnosticTestNotFoundException, DiagnosticCenterNotFoundException {
        DiagnosticCenter diagnosticCenter= diagnosticCenterService.getDiagnosticCenterById(4);
        diagnosticCenter.setName("Eastern Diagnostics");
        DiagnosticCenter dc = diagnosticCenterService.updateDiagnosticCenter(diagnosticCenter);
        Assert.assertEquals(dc.getName(),diagnosticCenter.getName());


    }

    @Test
    public void viewTestDetailsTest(){
        //Integer i=7;
        //DiagnosticTest dt= diagnosticCenterService.viewTestDetails(i,"ESR");
        //Assert.assertNotNull(dt);
    }

    @Test
    public void addTestTest( ) {

    }

    @Test
    public void getDiagnosticCenterTest(){
        DiagnosticCenter dc= new DiagnosticCenter("HC Diagnostic","88888888888","Kolkata","abcd.@gmail.com");
        Assert.assertEquals(dc.getName(),"HC Diagnostic");

    }

    @Test
    public void removeDiagnosticCenterTest() {

    }

    @Test
    public void getListOfAppointmentsTest() {

    }

}

