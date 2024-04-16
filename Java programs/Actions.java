package instagram;

import java.sql.*;
import java.util.Scanner;

public class Actions {
	Scanner sc = new Scanner(System.in);
	Connection c = null;
	int post_id, user_id,result,commented_id;
	String comment;
	Statement insert = null;
	Statement select = null;
	Connection connection = null;
	ResultSet rs = null;
	
	public Actions(){
	
	try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instagram","Harshitha", "harshitha@123");	
	}
	catch(Exception e){
		System.out.println(e);
	}
	}
	
	public void likePost() throws SQLException
	{
		System.out.println("Enter the post id to be liked");
		post_id = sc.nextInt();
		System.out.println("Enter your user id");
		user_id = sc.nextInt();
		String stmt = "insert into likes values("+post_id+","+user_id+");";
		insert = connection.createStatement();
		result = insert.executeUpdate(stmt);
		if(result!=0)
			System.out.println("liked");
		else
			System.out.println("could not like");
	}
	
	public void commentOnPost() throws SQLException
	{
		System.out.println("Enter your id");
		commented_id = sc.nextInt();
		System.out.println("Enter the post id on which you want to commnet");
		post_id = sc.nextInt();
		System.out.println("Enter the comment");
		comment = sc.next();
		
		String stmt = "insert into comments values("+commented_id+","+post_id+","+'"'+comment+'"'+");";
		insert = connection.createStatement();
		result = insert.executeUpdate(stmt);		
		if(result!=0)
			System.out.println("Comment added");
		else
			System.out.println("Could not add comment");
	}
	
	public void showReach() throws SQLException
	{
		System.out.println("Enter the post id");
		post_id = sc.nextInt();
		String stmt = "select id_name from people_ids where id in (select liked_id from likes where post_id = "+post_id+");";
		select = connection.createStatement();
		rs = select.executeQuery(stmt);
		while(rs.next())
		{
			System.out.println("Post liked by "+rs.getString("id_name"));
		}
		
		String stmt1 = "select comment from comments where post_id = "+post_id+";";
		select = connection.createStatement();
		rs = select.executeQuery(stmt1);
		System.out.println("Comments");
		while(rs.next())
		{
			System.out.println(rs.getString("comment"));
		}
	}
}
