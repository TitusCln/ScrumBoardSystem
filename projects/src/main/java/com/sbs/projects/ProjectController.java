package com.sbs.projects;


import com.sbs.contracts.dto.ProjectDTO;
import com.sbs.contracts.dto.SprintDTO;
import com.sbs.projects.services.ProjectService;
import com.sbs.projects.services.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private SprintService sprintService;

    @GetMapping(value = "/com/sbs/projects", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ProjectDTO> getAllProjects(@RequestParam(name = "withSprints", defaultValue = "false") Boolean withSprints) {
        return projectService.getAll(withSprints);
    }

    @GetMapping(value = "/com/sbs/projects/{projectId}")
    public ProjectDTO getProjectById(@PathVariable Long projectId, @RequestParam(name = "withSprints", defaultValue = "false") Boolean withSprints) {
        return projectService.getById(projectId, withSprints);
    }

    @PostMapping(value = "/com/sbs/projects")
    public ProjectDTO createProject(@RequestBody ProjectDTO project) {
        return projectService.create(project);
    }

    @PutMapping(value = "/com/sbs/projects/{projectId}")
    public ProjectDTO updateProject(@PathVariable Long projectId, @RequestBody ProjectDTO project) {
        return projectService.update(projectId, project);
    }

    @DeleteMapping(value = "/com/sbs/projects/{projectId}")
    public void deleteProject(@PathVariable Long projectId) {
        projectService.deleteById(projectId);
    }

    @GetMapping(value = "/com/sbs/projects/{projectId}/sprints")
    public Iterable<SprintDTO> getAllSprints(@PathVariable Long projectId) {
        return sprintService.getAll(projectId);
    }

    @GetMapping(value = "/com/sbs/projects/{projectId}/sprints/{sprintId}")
    public SprintDTO getSprint(@PathVariable Long projectId, @PathVariable Long sprintId) {
        return sprintService.getById(projectId, sprintId);
    }

    @PostMapping(value = "/com/sbs/projects/{projectId}/sprints")
    public SprintDTO createSprint(@PathVariable Long projectId, @RequestBody SprintDTO sprint) {
        return sprintService.create(projectId, sprint);
    }

    @PutMapping(value = "/com/sbs/projects/{projectId}/sprints/{sprintId}")
    public SprintDTO updateSprint(@PathVariable Long projectId, @PathVariable Long sprintId, @RequestBody SprintDTO sprint) {
        return sprintService.update(projectId, sprintId, sprint);
    }

    @DeleteMapping(value = "/com/sbs/projects/{projectId}/sprints/{sprintId}")
    public void deleteSprint(@PathVariable Long projectId, @PathVariable Long sprintId) {
        sprintService.delete(projectId, sprintId);
    }
}