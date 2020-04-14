package com.example.demo;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.bean.Account;
import com.example.demo.service.AccountService;
import com.example.demo.service.AccountServiceImpl;
import com.example.exceptions.AccNotFoundException;

/**
 * Hello world!
 *
 */
public class App 
{
	//private static List<ToDo> toDoList = new ArrayList<ToDo>();
	public static void main( String[] args )
	{
		openMenu();
		
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

			/*List<Account> accList = accService.getAllAccountDetails(); 
			Iterator<Account> iterator = accList.iterator(); 
			while(iterator.hasNext()) 
			{ 
				Account account2 = iterator.next();
				System.out.println(account2);
			}*/

			/*account = accService.findByAccountNumber("9d01c5cc");
			System.out.println(account);*/
			
			/*Account account = context.getBean("account",Account.class);
			account.setAccountNumber("ca1fa493");
			account.setAccountType("SAVINGS");
			account.setInitialBalance(250000); 
			
			try
			{
				accService.updateByAccountNumber(account);
				//System.out.println(rowCount);
				System.out.println("ACCOUNT DETAILS UPDATED BY "+account.getAccountNumber());
			}
			catch(AccNotFoundException accException)
			{
				System.out.println(accException.getLocalizedMessage());
			}*/
		}

	}

	private static void openMenu() 
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("----------BANK ACCOUNT OPENING FORM----------");
		System.out.println("1. CREATE ACCOUNT\n2. GET ALL ACCOUNTS\n3. FIND BY ACCOUNT NUMBER\n4. UPDATE BY ACCOUNT NUMBER");
		
		do
		{
			System.out.println("PLEASE ENTER YOUR CHOICE");
			int iChoice = input.nextInt();
			switch(iChoice)
			{
			case 1:
			}
		}
		while();
	}
}
