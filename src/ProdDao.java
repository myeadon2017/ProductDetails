import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//This class demonstrates my database JDBC operations
public class ProdDao {
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("org.h2.Driver");
			con= DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	//This method takes in a integer Id from the user and searches the database to find a match
	public static Prod getProductById(int id){
		Prod p=new Prod();
		
		try{
			Connection con=ProdDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from product where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			
			//This if else statement is used to verify that the Id matches a product
			//If the Id entered doesn't match a product then the system displays an error message
			if(rs.next()){
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setDetails(rs.getString(3));
			}
			else{
				System.out.println("Sorry! Invalid Id");
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();
		}
		
		return p;
	}
}
