package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer>
{
	public Iterable<Project> findByName(String name);
	
	public Iterable<Project> findByAgentName(String agentName);
	
	public void removeByName(String name);
}
