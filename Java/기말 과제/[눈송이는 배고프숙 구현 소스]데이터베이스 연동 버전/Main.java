import java.awt.FontFormatException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	static Statement statement;
	
	public static void main (String args[]) throws FontFormatException, IOException {
		statement = checkdb();
		MainPage mp = new MainPage();
		mp.setVisible(true);
	}
	
	public static Statement checkdb() {
		Connection con = null;
		 Statement st = null;
		 
		try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://us-cdbr-east-04.cleardb.com/heroku_f91ffea5f7054c5";
            con = DriverManager.getConnection(url, "bcb459354f7338", "eaaea278");
            st = con.createStatement();
            System.out.println("연결 성공");
        }
        catch(ClassNotFoundException e){
            System.out.println("드라이버 로딩 실패");
        }
        catch(SQLException e){
            System.out.println("에러: " + e);
        }
		return st;
	}
}