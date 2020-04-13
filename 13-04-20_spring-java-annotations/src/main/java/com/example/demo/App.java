package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.bean.Account;
import com.example.demo.bean.Image;
import com.example.demo.bean.ToDo;
import com.example.demo.service.AccountService;
import com.example.demo.service.AccountServiceImpl;
import com.example.demo.service.ToDoService;
import com.example.demo.service.ToDoServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	private static List<ToDo> toDoList = new ArrayList<ToDo>();
	public static void main( String[] args )
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

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
		Account account = context.getBean("account",Account.class);

		/*String str[]=UUID.randomUUID().toString().split("-");
		account.setAccountNumber(str[0]); account.setAccountType("LOAN");
		account.setInitialBalance(1000000);
		account=service.createAccount(account); System.out.println(account);


		List<Account> list=service.getAllAccountDetails(); Iterator<Account>
		i=list.iterator(); while(i.hasNext()) { Account account2=i.next();
		System.out.println(account2);*/
		
		account = accService.findByAccountNumber("46555cd3");
		System.out.println(account);

	}
}
