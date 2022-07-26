package com.example.healthcare.service;

import com.example.healthcare.entities.DiagnosticCenter;
import com.example.healthcare.entities.DiagnosticTest;
import com.example.healthcare.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface DiagnosticTestService {


    //public List<DiagnosticTest> removeDiagnosticTest(Integer id);
    public List<DiagnosticTest> getAllTest();

    public DiagnosticTest addNewTest(DiagnosticTest test);

    public Set<DiagnosticTest> getTestOfDiagnosticCenter(int centerId);

    public DiagnosticTest updateTestDetails(int id,DiagnosticTest test);

    public DiagnosticTest removeTestFormDiagnosticTest(DiagnosticTest test);
}
