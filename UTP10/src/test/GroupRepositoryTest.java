package test;

import dtos.GroupDTO;
import org.junit.Test;
import repositories.GroupRepository;
import repositories.interfaces.IGroupRepository;
import test.exeptions.UnimplementedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class GroupRepositoryTest extends RepositoryTestBase<GroupDTO, IGroupRepository> {



	GroupRepository groupRepository;

	GroupDTO groupAdd = new GroupDTO(3,"group3","desc of group 3");
	GroupDTO groupUpdate = new GroupDTO(3,"new_group3","new desc");
	GroupDTO groupAddUpdate = new GroupDTO(4,"group4","desc of group 4");
	GroupDTO groupDelete = new GroupDTO(1,"group1","desc of group 4");

	@Test
	public void add() {
		groupRepository.add(groupAdd);
	}

	@Test
	public void update() {
		groupRepository.update(groupUpdate);
	}

	@Test
	public void addOrUpdate() {
		groupRepository.addOrUpdate(groupUpdate);
		groupRepository.addOrUpdate(groupAddUpdate);
	}

	@Test
	public void delete() {
		before();
		groupRepository.delete(groupAdd);
		after();
	}

	@Test
	public void findById() {
		GroupDTO returnedById = groupRepository.findById(3);
		System.out.println(returnedById.getId() + " " + returnedById.getName() + " " + returnedById.getDescription());
	}

	@Test
	public void findByName() {
		List<GroupDTO> returnedByName = groupRepository.findByName("user2");
		for(GroupDTO user: returnedByName) {
			System.out.println(user.getId() + " " + user.getName() + " " + user.getDescription());
		}
	}
	@Test
	public void count(){
		System.out.println(groupRepository.getCount());
	}

	@Test
	public void exists(){
		System.out.println(groupRepository.exists(groupDelete));
	}

	@Test
	public void selectAll() throws SQLException {
		ResultSet rs = groupRepository.getConnection().prepareStatement("SELECT * FROM GROUPS").executeQuery();
		while (rs.next())
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
	}

	@Override
	protected IGroupRepository Create() {
		try {
			 groupRepository= new GroupRepository();
		} catch (UnimplementedException e) {
			throw new UnimplementedException();
		}
		return groupRepository;
	}


}