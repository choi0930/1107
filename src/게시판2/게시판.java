package 게시판2;

import java.util.Scanner;

import 게시판2.Article;

import java.util.ArrayList;

public class 게시판 {
	static ArrayList<Article> articleList = new ArrayList<>();	
	
	public static int getArticleIndexById(int aid) { 
		
		 int exisFlag=1; //1= 없다 2= 있다
		 int index = -1;// -1=없다
		 
		for(int i =0; i<articleList.size(); i++){
  	  Article article = articleList.get(i);
	   if(aid == article.getId()) {
		   exisFlag =2;
		   index = i;
		   
	
	    }
	   
    }
		return index;
	}
	public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);//스캐너
	 
	 ArrayList<Article> articleList = new ArrayList<>();	
	 
	 String ti;
	 String bo;
	 int id = 1;
	
	 //무한반복
	 while(true) {
		 
		 System.out.print("명령을 입력해주세요 :");		
		 String cmd = sc.nextLine();
		
		 //프로그램 종료
		 if(cmd.equals("exit")) {
			 System.out.println("프로그램을 종료합니다.");
			 break;
		 }
	
    //게시물 제목 및 내용 등록 
    if(cmd.equals("add")) {
    
    	
		 System.out.print("게시물 제목을 입력해주세요:");
	 	 ti =  sc.nextLine();	
	 	 
	 	 System.out.print("게시물 내용을 입력해주세요:");
		 bo = sc.nextLine();
		 
		 System.out.println("게시물이 등록되었습니다.");
		  
		 Article a1 = new Article(id, ti, bo);
		 articleList.add(a1);
		 id++;
		 
		  
	    
    }
    
	 //add로 저장한거 출력
    if(cmd.equals("list")) {
    
    	for(int i =0; i < articleList.size(); i++) {
    		Article a = articleList.get(i);
    	System.out.println("번호 : "+ a.getId());
    	System.out.println("제목 :" + a.getTitle());
    	System.out.println("====================");
    	
    	}
    }
    
	 
   if(cmd.equals("update")) {
	   System.out.print("수정할 게시물 번호:");
	   String aid = sc.nextLine();
	   int targetId = Integer.parseInt(aid);
	   int index = getArticleIndexById(targetId);
	  
	 if(index == -1) {
		 System.out.println("없는 게시물입니다.");
	 }
	 else {
		   System.out.print("제목:");
		   String title = sc.nextLine();
		   
		   System.out.print("내용:");
		   String body =  sc.nextLine();
		   
		   Article article2 =new Article(targetId, title, body);
		   articleList.set(index, article2 );
	 }
	    }
	   
      
   
   
   if(cmd.equals("delete")) {
	   System.out.print("삭제할 게시물 번호:");
	   String aid = sc.nextLine();
	   int targetId = Integer.parseInt(aid);
	   int index = getArticleIndexById(targetId);
	  
	   if(index == -1) {
			 System.out.println("없는 게시물입니다.");
		 }
	   else {   
		   articleList.remove(index);
		   System.out.println("삭제가 완료되었습니다.");
		   
	   } 
		  
	    }
	   
      
     
   
	 }
}

}