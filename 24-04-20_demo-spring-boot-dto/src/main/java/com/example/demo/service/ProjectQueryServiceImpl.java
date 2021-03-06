package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ProjectQueryDTO;
import com.example.demo.entity.Project;
import com.example.demo.repo.ProjectRepository;

@Service
public class ProjectQueryServiceImpl implements ProjectQueryService
{
	private ProjectRepository projectRepo;
	
	public ProjectQueryServiceImpl(ProjectRepository projectRepo) 
	{
		this.projectRepo = projectRepo;
	}
	
	@Override
	public ProjectQueryDTO saveProject(ProjectQueryDTO projQueryDTO) 
	{
		Project project = new Project();
		project.setAgentName(projQueryDTO.getAgentName());
		project.setName(projQueryDTO.getName());
		project.setDesc("EMPSOULSSKLS");
		projectRepo.save(project);
		return projQueryDTO;
	}

	@Override
	public ProjectQueryDTO getProject(Integer id) 
	{
		if(projectRepo.findById(id).isPresent())
		{
			Project project = projectRepo.findById(id).get();
			ProjectQueryDTO projectQuery = new ProjectQueryDTO(project.getName(),project.getAgentName());
			return projectQuery;
		}
		return null;
	}

	@Override
	public List<ProjectQueryDTO> getAllProjects() 
	{
		List<ProjectQueryDTO> projectsList = new ArrayList<>();
		projectRepo.findAll().forEach(project -> {
			projectsList.add(new ProjectQueryDTO(project.getName(),project.getAgentName()));
		});
		return projectsList;
	}

	@Override
	public Project updateProject(Project project) 
	{
		Optional<Project> project1 = projectRepo.findById(project.getId());
		if(project1.isPresent())
		{
			return projectRepo.save(project);
		}
		return null;
	}

	/*@Override
	public Iterable<Project> findByName(String name) 
	{
		return projectRepo.findByName(name);
	}*/

	@Override
	public Iterable<Project> findByAgentName(String agentName) 
	{
		return projectRepo.findByAgentName(agentName);
	}

	@Override
	@Transactional
	public void removeByName(String name) 
	{
		projectRepo.removeByName(name);
	}

	@Override
	public ProjectQueryDTO findByName(String name) 
	{
		Iterable<Project> project = projectRepo.findByName(name);
		ProjectQueryDTO proj = new ProjectQueryDTO();
		for(Project p : project)
		{
			proj.setName(p.getName());
			proj.setAgentName(p.getAgentName());
		}
		
		return proj;
	}
}
