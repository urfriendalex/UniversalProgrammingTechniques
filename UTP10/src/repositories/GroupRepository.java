package repositories;

import dtos.GroupDTO;
import repositories.interfaces.IGroupRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupRepository extends Repository<GroupDTO> implements IGroupRepository {

    private Connection con;

    public GroupRepository(){
        con = getConnection();
    }

    @Override
    public void add(GroupDTO dto) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("INSERT INTO GROUPS VALUES (?,?,?)");
            ps.setInt(1, dto.getId());
            ps.setString(2, dto.getName());
            ps.setString(3, dto.getDescription());
            ps.executeUpdate();
            System.out.println("Record successfully added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(GroupDTO dto) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("UPDATE GROUPS SET group_name = ?, group_description = ? where group_id = ?");
            ps.setInt(3, dto.getId());
            ps.setString(1, dto.getName());
            ps.setString(2, dto.getDescription());
            ps.executeUpdate();
            System.out.println("Record successfully updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addOrUpdate(GroupDTO dto) {
        if (exists(dto))
            update(dto);
        else
            add(dto);
    }

    @Override
    public void delete(GroupDTO dto) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("DELETE FROM GROUPS WHERE group_id = ? and group_name = ? and group_description = ?");
            ps.setInt(1, dto.getId());
            ps.setString(2, dto.getName());
            ps.setString(3, dto.getDescription());
            ps.executeUpdate();
            System.out.println("Record successfully deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public GroupDTO findById(int id) {
        PreparedStatement ps;
        GroupDTO returnedById = null;
        try {
            ps = con.prepareStatement("SELECT * FROM GROUPS WHERE group_id = ?");
            ps.setInt(1, id);
            ps.setMaxRows(1);
            ResultSet rs = ps.executeQuery();
            String name = null, discription = null;
            int returenedId = -1;
            while (rs.next()){
                returenedId = rs.getInt(1);
                name = rs.getString(2);
                discription = rs.getString(3);
            }
            returnedById = new GroupDTO(returenedId, name, discription);
            if(!returnedById.hasExistingId())
                returnedById=null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnedById;
    }

    @Override
    public List<GroupDTO> findByName(String name) {
        List<GroupDTO> groups = new ArrayList<>();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("SELECT * FROM GROUPS WHERE group_name = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                groups.add(new GroupDTO(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groups;
    }

    @Override
    public int getCount() {
        int count = 0;
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("SELECT COUNT(1) FROM GROUPS");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                count = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public boolean exists(GroupDTO dto) {
        GroupDTO groupExists = findById(dto.getId());
        return groupExists != null;
    }

}
