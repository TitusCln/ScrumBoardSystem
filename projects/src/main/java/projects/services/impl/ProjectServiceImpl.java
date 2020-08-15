package projects.services.impl;

import com.sbs.dto.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.models.ProjectRespository;
import projects.services.ProjectService;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRespository projectRespository;

    @Override
    public Iterable<Project> getAll() {

        return StreamSupport.stream(projectRespository.findAll().spliterator(), true)
                .map(projects.models.Project::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Project getById(Long id) {
        return projectRespository.findById(id).get().toDTO();
    }

    @Override
    public Project create(Project project) {
        return projectRespository.save(new projects.models.Project(project)).toDTO();
    }

    @Override
    public Project update(Long id, Project newProject) {
        return projectRespository.findById(id).map(project -> {
            project.setName(newProject.getName());
            return projectRespository.save(project).toDTO();
        }).get();
    }

    @Override
    public void deleteById(Long id) {
        projectRespository.deleteById(id);
    }
}
