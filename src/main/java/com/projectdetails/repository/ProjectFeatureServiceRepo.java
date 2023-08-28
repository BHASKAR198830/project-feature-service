package com.projectdetails.repository;

import com.projectdetails.model.ProjectFeatureModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectFeatureServiceRepo extends MongoRepository<ProjectFeatureModel,String> {

}
