package com.projectdetails.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@Document(collection = "projectFeatureDetails")

public class ProjectFeatureModel {

    public ProjectFeatureModel()
    {
        this.featureId= UUID.randomUUID().toString();
    }

    private String featureId;
    private String projectId;
    private String featureName;
    private String featureDescription;
    private String featureStatus;
    private String featureReview;
    private Date featureStartDate;
    private Date featureEndDate;
}
