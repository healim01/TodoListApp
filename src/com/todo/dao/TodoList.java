package com.todo.dao;

import java.util.*;

import com.todo.service.TodoSortByDate;
import com.todo.service.TodoSortByName;

public class TodoList {
	private List<TodoItem> list;

	public TodoList() {
		this.list = new ArrayList<TodoItem>();
	}

	public void addItem(TodoItem t) {
		list.add(t);
	}

	public void deleteItem(TodoItem t) {
		list.remove(t);
	}

	void editItem(TodoItem t, TodoItem updated) {
		int index = list.indexOf(t);
		list.remove(index);
		list.add(updated);
	}

	public ArrayList<TodoItem> getList() {
		return new ArrayList<TodoItem>(list);
	}

	public void sortByName() {
		Collections.sort(list, new TodoSortByName());

	}
	
	public void find(String word) {
		int count=0, num=0;
		for (TodoItem item : list) {
			int con = 0;
			count++;
			if (item.getTitle().contains(word)) con = 1;
			else if (item.getDesc().contains(word)) con = 1;
			
			if (con == 1) {
				item(count);
				num++;
			}
		}
		
		if (num == 0) System.out.println("해당 항목이 없습니다.");
		else System.out.println("총 " + num + "개의 항목을 찾았습니다.");
	}
	
	public void find_cate(String cate) {
		int count=0, num=0;
		for (TodoItem item : list) {
			count++;
			if (item.getCate().contains(cate)) {
				item(count);
				num++;
			}
		}
		
		if (num == 0) System.out.println("해당 항목이 없습니다.");
		else System.out.println("총 " + num + "개의 항목을 찾았습니다.");
	}
	
	public void reverseList() {
		Collections.reverse(list);
	}

	public void sortByDate() {
		Collections.sort(list, new TodoSortByDate());
	}

	public int indexOf(TodoList l) {
		return list.indexOf(l);
	}
	
	public int size() {
		return list.size();
	}
	
	public void item(int n) {
		int count = 0;
		for (TodoItem item : list) {
			count++;
			if (count == n) System.out.println(n + ". " + item.toString());
		}
	}

	public Boolean isDuplicate(String title) {
		for (TodoItem item : list) {
			if (title.equals(item.getTitle())) return true;
		}
		return false;
	}
}
