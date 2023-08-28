package com.projectdetails.service.impl;

import com.projectdetails.dto.ProjectFeatureServiceRequest;
import com.projectdetails.dto.ProjectFeatureServiceResponse;
import com.projectdetails.model.ProjectFeatureModel;
import com.projectdetails.repository.ProjectFeatureServiceRepo;
import com.projectdetails.service.ProjectFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectFeatureServiceImpl implements ProjectFeatureService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    ProjectFeatureServiceRepo projectFeatureServiceRepo;

    @Override
    public ProjectFeatureServiceResponse fetchAllFeatureByProjectId(String projectId) {
        ProjectFeatureServiceResponse projectFeatureServiceResponse=new ProjectFeatureServiceResponse();
        List<ProjectFeatureModel> projectFeatureModelList;
        try{
            Query query=new Query();
            query.addCriteria(Criteria.where("projectId").is(projectId));
            projectFeatureModelList=mongoTemplate.find(query,ProjectFeatureModel.class);
            if(projectFeatureModelList.size()==0)
            {
                projectFeatureServiceResponse.setData(null);

            }else
            {
                projectFeatureServiceResponse.setData(projectFeatureModelList);

            }
            projectFeatureServiceResponse.setMessage("Success");
            projectFeatureServiceResponse.setStatusCode("200");

        }
        catch(Exception ex)
        {
            projectFeatureServiceResponse.setMessage("Exception: "+ex.getMessage());
            projectFeatureServiceResponse.setStatusCode("200");
        }

        return projectFeatureServiceResponse;
    }

    @Override
    public ProjectFeatureServiceResponse saveFeature(ProjectFeatureServiceRequest projectFeatureServiceRequest) {

        ProjectFeatureServiceResponse projectFeatureServiceResponse=new ProjectFeatureServiceResponse();
        try{
            ProjectFeatureModel projectFeatureModel =new ProjectFeatureModel();
            projectFeatureModel.setProjectId(projectFeatureServiceRequest.getProjectId());
            projectFeatureModel.setFeatureName(projectFeatureServiceRequest.getFeatureName());
            projectFeatureModel.setFeatureDescription(projectFeatureServiceRequest.getFeatureDescription());
            projectFeatureModel.setFeatureStatus(projectFeatureServiceRequest.getFeatureStatus());
            projectFeatureModel.setFeatureReview(projectFeatureServiceRequest.getFeatureReview());
            projectFeatureModel.setFeatureStartDate(projectFeatureServiceRequest.getFeatureStartDate());
            projectFeatureModel.setFeatureEndDate(projectFeatureServiceRequest.getFeatureEndDate());
            projectFeatureServiceRepo.save(projectFeatureModel);
            projectFeatureServiceResponse.setStatusCode("200");
            projectFeatureServiceResponse.setMessage("Feature created successfully");
        }
        catch (Exception ex)
        {
            projectFeatureServiceResponse.setStatusCode("200");
            projectFeatureServiceResponse.setMessage("Exception: "+ex.getMessage());

        }
        return projectFeatureServiceResponse;
    }
}
