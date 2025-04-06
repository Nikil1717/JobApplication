package com.nikil.job_application.service;

import com.nikil.job_application.model.JobApplication;
import com.nikil.job_application.repository.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepository repository;

    public JobApplication submitApplication(JobApplication application) {
        return repository.save(application);
    }

    public List<JobApplication> getAllApplications() {
        return repository.findAll();
    }

    public Optional<JobApplication> getApplicationById(Long id) {
        return repository.findById(id);
    }

    public void deleteApplication(Long id) {
        repository.deleteById(id);
    }

    public JobApplication updateApplication(Long id, JobApplication updatedApplication) {
        return repository.findById(id).map(app -> {
            app.setApplicantName(updatedApplication.getApplicantName());
            app.setEmail(updatedApplication.getEmail());
            app.setPhone(updatedApplication.getPhone());
            app.setPosition(updatedApplication.getPosition());
            app.setResumeUrl(updatedApplication.getResumeUrl());
            return repository.save(app);
        }).orElse(null);
    }
}

