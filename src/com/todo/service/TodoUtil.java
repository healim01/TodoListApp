package com.todo.service;

import java.util.*;
import java.io.*;
import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class TodoUtil {
	
	public static void createItem(TodoList list) {
		
		String cate, title, desc, deadline;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n"
				+ "[ 항목 추가 ]\n"
				+ "카테고리 > ");
		cate = sc.next().trim();
		
		System.out.print("제목 > ");
		title = sc.next().trim();
		if (list.isDuplicate(title)) {
			System.out.printf("중복되었습니다.");
			return;
		}
		
		sc.nextLine();
		System.out.print("내용 > ");
		desc = sc.nextLine().trim();
		
		System.out.print("마감일자 > ");
		deadline = sc.next().trim();
		
		sc.nextLine();
		TodoItem t = new TodoItem(cate, title, desc, deadline);
		list.addItem(t);
		System.out.println("\n추가되었습니다.");
	}

	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n"
				+ "[ 항목 삭제 ]\n"
				+ "삭제할 항목의 번호를 입력하시오 > ");
		
		int num = sc.nextInt();
		int count = 0;
		l.item(num);
		
		System.out.print("위 항목을 삭제하시겠습니까? (y/n) > ");
		String yn = sc.next();
		
		if (yn.equals("y")) {
			for (TodoItem item : l.getList()) {
				count++;
				if (count ==  num) {
					l.deleteItem(item);
					System.out.println("삭제되었습니다.");
					break;
				}
			}
		}
	}


	public static void updateItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n"
				+ "[ 항목 수정 ] \n"
				+ "수정할 항목의 번호를 입력하시오 > ");
		int num = sc.nextInt();
		l.item(num);
		
		if (num < 1 || num > l.size()) {
			System.out.println("\n존재하지 않습니다.");
			return;
		}

		System.out.print("\n새 카테고리 > ");
		
		String new_cate = sc.next().trim();
		
		System.out.print("새 제목 > ");
		String new_title = sc.next().trim();
		
		if (l.isDuplicate(new_title)) {
			System.out.println("\n중복되었습니다.");
			return;
		}
		
		sc.nextLine();
		System.out.print("새 내용 > ");
		String new_description = sc.nextLine().trim();
		
		System.out.print("새 마감일자 > ");
		String new_deadline = sc.next().trim();
		
		int count=0;
		for (TodoItem item : l.getList()) {
			count++;
			if (num == count) {
				l.deleteItem(item);
				TodoItem t = new TodoItem(new_cate, new_title, new_description, new_deadline);
				l.addItem(t);
				System.out.println("수정되었습니다.");
			}
		}

	}

	public static void listAll(TodoList l) {
		System.out.println();
		System.out.println("[전체 목록, 총 " + l.size() + "개]");
		int count=0;
		for (TodoItem item : l.getList()) {
			count++;
			System.out.println(count + ". " + item.toString());
		}
	}
	
	public static void ls_cate(TodoList l) {
		System.out.println();
		int count=0;
		String cate = null;
		for (TodoItem item : l.getList()) {
			if (count==0) {
				cate = item.getCate();
				count++;
			}
			
			if (!cate.contains(item.getCate())) {
				cate += " / " + item.getCate();
				count++;
			}
		}
		System.out.println(cate);
		System.out.println("총 " + count + "개의 카테고리가 등록되어 있습니다.");
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
				
				String ca = stk.nextToken();
				String ti = stk.nextToken();
				String de = stk.nextToken();
				String dl = stk.nextToken();
				String da = stk.nextToken();
				
				TodoItem t = new TodoItem(ca, ti, de, dl, da);
				l.addItem(t);
			}
			System.out.println(count + "개의 항목을 읽었습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(filename +  " 파일이 없습니다. ");
		}
	
	}
}
