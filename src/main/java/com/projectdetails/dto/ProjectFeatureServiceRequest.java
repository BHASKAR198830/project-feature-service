package com.projectdetails.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectFeatureServiceRequest {
    private String projectId;
    private String featureName;
    private String featureDescription;
    private String featureStatus;
    private String featureReview;
    private Date featureStartDate;
    private Date featureEndDate;
}
