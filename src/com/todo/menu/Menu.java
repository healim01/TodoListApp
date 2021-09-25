package com.todo.menu;
public class Menu {

    public static void displaymenu(){
        System.out.println();
        System.out.println("<TodoList 명령어>");
        System.out.println("add - 항목 추가 ");
        System.out.println("del - 항목 삭제 ");
        System.out.println("edit - 항목 수정 ");
        System.out.println("ls - 전체 항목 ");
        System.out.println("ls_cate - 전체 카테고리 항목 ");
        System.out.println("ls_name_asc - 전체 항목 제목순 정렬");
        System.out.println("ls_name_desc - 전체 항목 제목역순 정렬");
        System.out.println("ls_date - 전체 항목 날짜순 정렬 ");
        System.out.println("ls_date_desc - 전체 항목 날짜역순 정렬 ");
        System.out.println("find <키워드> - 제목과 내용에서 키워드를 포함한 모든 항목 출력 ");
        System.out.println("find_cate <키워드> - 카테고리에서 키워드를 포함한 모든 항목 출력 ");
        System.out.println("exit - 종료 ");
    }
    
    public static void prompt() {
    	System.out.print("\nCommand > ");
    }
}
