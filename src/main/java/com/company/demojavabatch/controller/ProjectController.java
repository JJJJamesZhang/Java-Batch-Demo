package com.company.demojavabatch.controller;

import com.company.demojavabatch.entity.Project;
import com.company.demojavabatch.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping(value = "get/{projectId}")
    public Project get(@PathVariable("projectId") String projectId){
        return projectService.get(projectId);
    }

    @GetMapping(value = "list")
    public List<Project> list(){
        return projectService.list();
    }

    @PostMapping(value = "create")
    public void create(@RequestBody Project project){
        projectService.create(project);
    }

    @DeleteMapping(value = "delete/{projectId}")
    public void delete(@PathVariable("projectId") String projectId){
        projectService.deleteById(projectId);
    }

    @PutMapping(value = "/update")
    public void update(@RequestBody Project project){
        projectService.update(project);
    }
}
