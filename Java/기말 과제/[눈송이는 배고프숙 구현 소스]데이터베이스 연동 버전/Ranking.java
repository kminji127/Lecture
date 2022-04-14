import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.List;

import javax.swing.JPanel;

public class Ranking extends JPanel {
	Statement st;
	static List namelist, scorelist;
	
	public Ranking(Statement statement) {
		this.st = statement;
	}
	
	public void dbconnection() {
		Scanner scan = new Scanner(System.in);
		int rank;
		String name;
		int score;
		int newrank = 0;
		
		namelist = new ArrayList();
		scorelist = new ArrayList();
		
		try{  
			String sql = "select * "
					+ "from `finalscore`"
					+ "order by `score` DESC";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				name = rs.getString("name"); 
				score = rs.getInt("score");
				namelist.add(name);
				scorelist.add(score);
            }
		} catch( SQLException e){
            e.printStackTrace();
        }
	}
	
	public void scoreadd(String newname, int newscore) {
		try {
				String sql = "INSERT INTO `finalscore` (`name`, `score`)"
						+ "VALUES ('" + newname + "',"  + newscore + ")";
				st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}