package com.todo;

import java.util.Scanner;

import com.todo.dao.TodoList;
import com.todo.menu.Menu;
import com.todo.service.TodoUtil;

public class TodoMain {
	
	public static void start() {
	
		Scanner sc = new Scanner(System.in);
		TodoList l = new TodoList();
		boolean isList = false;
		boolean quit = false;
		TodoUtil.loadList(l, "todolist.txt");
		Menu.displaymenu();
		do {
			isList = false;
			Menu.prompt();
			String choice = sc.next();
			switch (choice) {
			
				case "add":
					TodoUtil.createItem(l);
					break;
				
				case "del":
					TodoUtil.deleteItem(l);
					break;
					
				case "edit":
					TodoUtil.updateItem(l);
					break;
					
				case "ls":
					TodoUtil.listAll(l);
					break;
					
				case "ls_cate":
					TodoUtil.ls_cate(l);
					break;
	
				case "ls_name_asc":
					l.sortByName();
					isList = true;
					break;
	
				case "ls_name_desc":
					l.sortByName();
					l.reverseList();
					isList = true;
					break;
					
				case "ls_date":
					l.sortByDate();
					isList = true;
					break;
					
				case "ls_date_desc":
					l.sortByDate();
					l.reverseList();
					isList = true;
					break;
					
				case "find":
					String f = sc.next();
					l.find(f);
					break;
					
				case "find_cate":
					String c = sc.next();
					l.find_cate(c);
					break;
	
				case "exit":
					quit = true;
					break;
				
				case "help":
					Menu.displaymenu();
					break;
	
				default:
					System.out.println("명령어가 존재하지 않습니다. (도움말 - help)");
					break;
			}
			
			if(isList) TodoUtil.listAll(l);
		} while (!quit);
		TodoUtil.saveList(l, "todolist.txt");
	}
}
