package repositories;

import dtos.DTOBase;
import repositories.interfaces.IRepository;

import javax.sql.ConnectionPoolDataSource;
import javax.sql.PooledConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Repository<DTO extends DTOBase> implements IRepository<DTO> {

    private String driverName = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@db-oracle.pjwstk.edu.pl:1521:baza";
    private String user = "s16763";
    private String password = "oracle12";
    Connection con;

    public Repository() {
        con = getConnection();
        ConnectionPoolDataSource
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName (driverName);
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void beginTransaction() {
        try {
            con.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void commitTransaction() {
        try {
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rollbackTransaction() {
        try {
            con.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            con.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
