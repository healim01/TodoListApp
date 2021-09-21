package com.todo.service;

import java.util.*;
import java.io.*;
import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class TodoUtil {
	
	public static void createItem(TodoList list) {
		
		String title, desc;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n"
				+ "[ 항목 추가 ]\n"
				+ "제목 > ");
		
		title = sc.next().trim();
		if (list.isDuplicate(title)) {
			System.out.printf("중복되었습니다.");
			return;
		}
		
		sc.nextLine();
		System.out.print("내용 > ");
		desc = sc.nextLine().trim();
		
		TodoItem t = new TodoItem(title, desc);
		list.addItem(t);
		System.out.println("\n추가되었습니다.");
	}

	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n"
				+ "[ 항목 삭제 ]\n"
				+ "제목 > ");
		String title = sc.next().trim();
		
		for (TodoItem item : l.getList()) {
			if (title.equals(item.getTitle())) {
				l.deleteItem(item);
				System.out.println("\n삭제되었습니다.");
				break;
			}
		}
	}


	public static void updateItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n"
				+ "[ 항목 수정 ] \n"
				+ "제목 > ");
		String title = sc.next().trim();
		
		if (!l.isDuplicate(title)) {
			System.out.println("\n존재하지 않습니다.");
			return;
		}

		System.out.print("\n새 제목 > ");
		String new_title = sc.next().trim();
		if (l.isDuplicate(new_title)) {
			System.out.println("\n중복되었습니다.");
			return;
		}
		
		sc.nextLine();
		System.out.print("새 내용 > ");
		String new_description = sc.nextLine().trim();
		
		for (TodoItem item : l.getList()) {
			if (item.getTitle().equals(title)) {
				l.deleteItem(item);
				TodoItem t = new TodoItem(new_title, new_description);
				l.addItem(t);
				System.out.println("\n수정되었습니다.");
			}
		}

	}

	public static void listAll(TodoList l) {
		System.out.println();
		for (TodoItem item : l.getList()) {
			System.out.println(item.toString());
		}
	}
	
	public static void saveList(TodoList l, String filename){
		File f1 = new File(filename);
		try {
			FileWriter fw = new FileWriter(f1);;
			for (TodoItem item : l.getList()) {
				fw.write(item.toSaveString());
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void loadList(TodoList l, String filename) {
		
		BufferedReader read;
		try {
			read = new BufferedReader(new FileReader(filename));
			
			String str;
			int count=0;
			while ((str = read.readLine()) != null) {
				count++;
				StringTokenizer stk = new StringTokenizer(str,"##");
				
				String ti = stk.nextToken();
				String de = stk.nextToken();
				String da = stk.nextToken();
				
				TodoItem t = new TodoItem(ti, de, da);
				l.addItem(t);
			}
			System.out.println(count + "개의 항목을 읽었습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(filename +  " 파일이 없습니다. ");
		}
	
	}
}
