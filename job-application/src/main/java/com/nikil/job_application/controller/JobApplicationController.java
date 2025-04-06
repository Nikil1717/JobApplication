package com.nikil.job_application.controller;

import com.nikil.job_application.model.JobApplication;
import com.nikil.job_application.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*") // Allow frontend to access API
public class JobApplicationController {

    @Autowired
    private JobApplicationService service;

    @PostMapping
    public JobApplication submitApplication(@RequestBody JobApplication application) {
        return service.submitApplication(application);
    }

    @GetMapping
    public List<JobApplication> getAllApplications() {
        return service.getAllApplications();
    }

    @GetMapping("/{id}")
    public JobApplication getApplicationById(@PathVariable Long id) {
        return service.getApplicationById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public JobApplication updateApplication(@PathVariable Long id, @RequestBody JobApplication updatedApplication) {
        return service.updateApplication(id, updatedApplication);
    }

    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable Long id) {
        service.deleteApplication(id);
    }
}
