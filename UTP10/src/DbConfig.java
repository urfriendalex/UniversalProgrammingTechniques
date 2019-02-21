import java.sql.*;

public class DbConfig {
    Connection connection = null;
    DbConfig(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@db-oracle.pjwstk.edu.pl:1521:baza","s16763","oracle12");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    Connection getConnection() {return connection;}

    public static void main(String[] args) {
        try {
        DbConfig dbConfig = new DbConfig();
        PreparedStatement statement = dbConfig.getConnection().prepareStatement("Select * from users");
        ResultSet r = statement.executeQuery();
        while (r.next()) {
            System.out.println(r.getInt(1)+r.getString(2)+r.getString(3));
        }
    }catch (SQLException e){
            e.getErrorCode();
        }
    }
}
