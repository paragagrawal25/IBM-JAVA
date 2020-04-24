package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Project;
import com.example.demo.repo.ProjectRepository;

@SpringBootApplication
public class Application implements CommandLineRunner
{
	private ProjectRepository projectRepo;
	
	@Autowired
	public Application(ProjectRepository projectRepo) {
		super();
		this.projectRepo = projectRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		/*projectRepo.save(new Project("demo project 1", "demo description-1", "demo agent-1"));
		projectRepo.save(new Project("demo project 2", "demo description-2", "demo agent-2"));
		projectRepo.save(new Project("demo project 3", "demo description-3", "demo agent-3"));
		projectRepo.save(new Project("demo project 4", "demo description-4", "demo agent-4"));*/
	}

}
