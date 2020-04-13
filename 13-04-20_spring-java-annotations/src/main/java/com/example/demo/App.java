package com.example.demo;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.bean.Account;
import com.example.demo.service.AccountService;
import com.example.demo.service.AccountServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	//private static List<ToDo> toDoList = new ArrayList<ToDo>();
	public static void main( String[] args )
	{
		try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");)
		{
			/*Image image = context.getBean("image",Image.class);
        System.out.println(image);*/

			/*ToDoService toDoService = context.getBean("toDoServiceImpl",ToDoServiceImpl.class);

        ToDo toDo = context.getBean("toDo",ToDo.class);
        toDo.setToDoID(UUID.randomUUID().toString());
        toDo.setToDoName("Testing");

        toDo = toDoService.createToDo(toDo);

        toDoList = toDoService.getAllToDos();
        System.out.println(toDoList);
        //System.out.println(toDo);*/

			AccountService accService = context.getBean("accountServiceImpl",AccountServiceImpl.class);
			
			/*Account account = context.getBean("account",Account.class);
			String str[] = UUID.randomUUID().toString().split("-");
			account.setAccountNumber(str[0]); 
			account.setAccountType("LOAN");
			account.setInitialBalance(1000000);
			account = accService.createAccount(account); 
			System.out.println(account);*/

			List<Account> accList = accService.getAllAccountDetails(); 
			Iterator<Account> iterator = accList.iterator(); 
			while(iterator.hasNext()) 
			{ 
				Account account2 = iterator.next();
				System.out.println(account2);
			}

			/*account = accService.findByAccountNumber("9d01c5cc");
			System.out.println(account);*/
		}

	}
}
