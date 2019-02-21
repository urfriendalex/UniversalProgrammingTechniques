package repositories;

import dtos.UserDTO;
import repositories.interfaces.IUserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository extends Repository<UserDTO> implements IUserRepository {
    private Connection con;

    public UserRepository() {
        con = getConnection();
    }

    @Override
    public List<UserDTO> findByName(String username) {
        List<UserDTO> users = new ArrayList<>();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("SELECT * FROM USERS WHERE user_login = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void add(UserDTO dto) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("INSERT INTO USERS VALUES (?,?,?)");
            ps.setInt(1, dto.getId());
            ps.setString(2, dto.getLogin());
            ps.setString(3, dto.getPassword());
            ps.executeUpdate();
            System.out.println("Record successfully inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(UserDTO dto) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("UPDATE USERS SET user_login = ?, user_password = ? where user_id = ?");
            ps.setInt(3, dto.getId());
            ps.setString(1, dto.getLogin());
            ps.setString(2, dto.getPassword());
            ps.executeUpdate();
            System.out.println("Record successfully updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addOrUpdate(UserDTO dto) {
        if (exists(dto)) {
            update(dto);
        } else {
            add(dto);
        }
    }

    @Override
    public void delete(UserDTO dto) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("DELETE FROM USERS WHERE user_id = ? and user_login = ? and user_password = ?");
            ps.setInt(1, dto.getId());
            ps.setString(2, dto.getLogin());
            ps.setString(3, dto.getPassword());
            ps.executeUpdate();
            System.out.println("Record successfully deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserDTO findById(int id) {
        PreparedStatement ps;
        UserDTO returnedById = null;
        try {
            ps = con.prepareStatement("SELECT * FROM USERS WHERE user_id = ?");
            ps.setInt(1, id);
            ps.setMaxRows(1);
            ResultSet rs = ps.executeQuery();
            String login = null, password = null;
            int returnedId = -1;
            while (rs.next()){
                returnedId = rs.getInt(1);
                login = rs.getString(2);
                password = rs.getString(3);
            }
            returnedById = new UserDTO(returnedId, login, password);
            if (!returnedById.hasExistingId())
                returnedById = null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnedById;
    }

    @Override
    public int getCount() {
        int count = 0;
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("SELECT COUNT(1) FROM USERS");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                count = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public boolean exists(UserDTO dto) {
        UserDTO userExists = findById(dto.getId());
        return userExists != null;
    }
}
