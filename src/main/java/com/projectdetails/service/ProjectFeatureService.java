package com.projectdetails.service;

import com.projectdetails.dto.ProjectFeatureServiceRequest;
import com.projectdetails.dto.ProjectFeatureServiceResponse;

public interface ProjectFeatureService {

    ProjectFeatureServiceResponse fetchAllFeatureByProjectId (String projectId);
    ProjectFeatureServiceResponse saveFeature(ProjectFeatureServiceRequest projectFeatureServiceRequest);

}
