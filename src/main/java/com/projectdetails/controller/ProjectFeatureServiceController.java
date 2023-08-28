package com.projectdetails.controller;

import com.projectdetails.dto.ProjectFeatureServiceRequest;
import com.projectdetails.dto.ProjectFeatureServiceResponse;
import com.projectdetails.model.ProjectFeatureModel;
import com.projectdetails.service.ProjectFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.List;

@RestController
@RequestMapping("/api/feature")
public class ProjectFeatureServiceController {

    @Autowired
    ProjectFeatureService projectFeatureService ;


    @PostMapping("/hello-world")
    public String helloWorld(@RequestBody String name)
    {
        return name;
    }


    @PostMapping("/save-feature")
    public ProjectFeatureServiceResponse saveFeature(@RequestBody ProjectFeatureServiceRequest projectFeatureServiceRequest)
    {
        ProjectFeatureServiceResponse projectFeatureServiceResponse =new ProjectFeatureServiceResponse();
        projectFeatureServiceResponse=projectFeatureService.saveFeature(projectFeatureServiceRequest);
        return projectFeatureServiceResponse;


    }

    @GetMapping("/fetchbyprojectid/{projectId}")
    public ProjectFeatureServiceResponse fetchfeaturebyprojectid(@PathVariable String projectId)
    {
        ProjectFeatureServiceResponse projectFeatureServiceResponse=new ProjectFeatureServiceResponse();
        projectFeatureServiceResponse=projectFeatureService.fetchAllFeatureByProjectId(projectId);
        return projectFeatureServiceResponse;
    }

    @GetMapping("/featurebyprojectid/{projectId}")
    public List<ProjectFeatureModel> featurebyprojectid(@PathVariable String projectId)
    {
        ProjectFeatureServiceResponse projectFeatureServiceResponse=new ProjectFeatureServiceResponse();
        projectFeatureServiceResponse=projectFeatureService.fetchAllFeatureByProjectId(projectId);
        return projectFeatureServiceResponse.getData();
    }




}
