package com.projectdetails.dto;

import com.projectdetails.model.ProjectFeatureModel;
import lombok.Data;

import java.util.List;

@Data
public class ProjectFeatureServiceResponse {
    private String message;
    private String statusCode;
    private List<ProjectFeatureModel> data;

}
