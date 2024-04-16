package pokemon;

import java.sql.*;

public class Pokemon {
	static Connection connection;
	public static void main(String args[]) throws SQLException
	{
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon",
					"Harshitha","harshitha@123");
		}catch(Exception e){}
		
		String select = "select poke_name, poke_type ,learn, powers from pokemon_type, skills where skills.skill_type  = pokemon_type.poke_type ;";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(select);
		System.out.println("pokemon name   pokemon type   moves     power\n");
		while(rs.next())
		{
			System.out.print(rs.getString("poke_name")+"           ");
			System.out.print(rs.getString("poke_type")+"       ");
			System.out.print(rs.getString("learn")+"       ");
			System.out.println(rs.getInt("powers")+"       ");
		}
	}
}
