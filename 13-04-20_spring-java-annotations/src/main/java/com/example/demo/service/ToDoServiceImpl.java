package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.ToDo;
import com.example.demo.repo.ToDoRepository;

@Service
public class ToDoServiceImpl implements ToDoService
{
	private ToDoRepository toDoRepo;
	
	@Autowired
	public ToDoServiceImpl(ToDoRepository toDoRepo) {
		super();
		this.toDoRepo = toDoRepo;
	}

	@Override
	public ToDo createToDo(ToDo toDo) 
	{
		return toDoRepo.createToDo(toDo);
	}

	@Override
	public List<ToDo> getAllToDos() 
	{
		return toDoRepo.getAllToDos();
	}

}
