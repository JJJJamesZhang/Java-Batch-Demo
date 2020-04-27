package com.company.demojavabatch.service;

import com.company.demojavabatch.entity.Project;
import com.company.demojavabatch.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Transactional(rollbackFor = Exception.class)
    public void create(Project project){
        projectRepository.create(project.getProjectId(),project.getProjectName());
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(Project project){
        projectRepository.update(project.getProjectId(),project.getProjectName());
    }

    public Project get(String projectId){
        return projectRepository.findById(projectId).get();
    }

    public List<Project> list(){
        return projectRepository.findAll();
    }

    public void deleteById(String projectId){
        projectRepository.deleteById(projectId);
    }
}
