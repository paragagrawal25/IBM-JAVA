package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProjectQueryDTO;
import com.example.demo.entity.Project;
import com.example.demo.service.ProjectQueryService;

@RestController
@RequestMapping("/api")
public class ProjectQueryController 
{
	private ProjectQueryService projQuery;

	@Autowired
	public ProjectQueryController(ProjectQueryService projQuery) 
	{
		super();
		this.projQuery = projQuery;
	}
	
	@PostMapping("/projects")
	public ProjectQueryDTO saveProject(@RequestBody ProjectQueryDTO projDto)
	{
		return projQuery.saveProject(projDto);
	}
	
	@GetMapping("/projects")
	public ResponseEntity<Object> getAll()
	{
		return new ResponseEntity<>(projQuery.getAllProjects(),HttpStatus.OK);
	}
	
	@GetMapping("/projects/{id}")
	public ResponseEntity<Object> getProjectById(@PathVariable("id") Integer id)
	{
		return new ResponseEntity<>(projQuery.getProject(id),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/projects")
	public ResponseEntity<Object> updateProjectBy(@RequestBody Project project)
	{
		return new ResponseEntity<>(projQuery.updateProject(project),HttpStatus.OK);
	}
	
	/*@GetMapping("/projectsByName/{name}")
	public ResponseEntity<Iterable<Project>> getProjectByName(@PathVariable("name") String name)
	{
		return ResponseEntity.ok().body(projQuery.findByName(name));
	}*/
	
	@GetMapping("/projectsByName/{name}")
	public ProjectQueryDTO getProjectByName(@PathVariable("name") String name)
	{
		return projQuery.findByName(name);
	}
	
	@DeleteMapping("/projects/{name}")
	public void removeByName(@PathVariable("name") String name)
	{
		projQuery.removeByName(name);
	}
}
