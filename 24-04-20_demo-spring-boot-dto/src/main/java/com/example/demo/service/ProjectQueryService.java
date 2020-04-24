package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ProjectQueryDTO;
import com.example.demo.entity.Project;

public interface ProjectQueryService 
{
	public ProjectQueryDTO saveProject(ProjectQueryDTO projQueryDTO);
	
	public ProjectQueryDTO getProject(Integer id);
	
	public List<ProjectQueryDTO> getAllProjects();
	
	public Project updateProject(Project project);
}
