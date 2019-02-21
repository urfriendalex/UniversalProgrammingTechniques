package test;

import org.junit.Test;
import dtos.UserDTO;
import repositories.interfaces.IUserRepository;
import repositories.UserRepository;
import test.exeptions.UnimplementedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public final class UserRepositoryTest extends RepositoryTestBase<UserDTO, IUserRepository> {

	UserRepository userRepository;

	UserDTO userAdd = new UserDTO(3,"user3","abc123");
	UserDTO userUpdate = new UserDTO(3,"new_user3","newABC");
	UserDTO userAddUpdate = new UserDTO(4,"user4","acc111");
	UserDTO userDelete = new UserDTO(1,"user1","abc123");

	@Test
	public void add() {
		userRepository.add(userAdd);
	}

	@Test
	public void update() {
		userRepository.update(userUpdate);
	}
	
	@Test
	public void addOrUpdate() {
		userRepository.addOrUpdate(userUpdate);
		userRepository.addOrUpdate(userAddUpdate);
	}

	@Test
	public void delete() {
		userRepository.delete(userDelete);
	}

	@Test
	public void findById() {
		UserDTO returnedById = userRepository.findById(1);
		System.out.println(returnedById.getId() + " " + returnedById.getLogin() + " " + returnedById.getPassword());
	}
	
	@Test
	public void findByName() {
		List<UserDTO> returnedByName = userRepository.findByName("user2");
		for(UserDTO user: returnedByName) {
			System.out.println(user.getId() + " " + user.getLogin() + " " + user.getPassword());
		}
	}
	@Test
	public void count(){
		System.out.println(userRepository.getCount());
	}

	@Test
	public void exists(){
		System.out.println(userRepository.exists(userDelete));
	}

	@Test
	public void selectAll() throws SQLException {
		ResultSet rs = userRepository.getConnection().prepareStatement("SELECT * FROM USERS").executeQuery();
		while (rs.next())
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
	}
	
	@Override
	protected IUserRepository Create() {
		try {
			userRepository = new UserRepository();
		} catch (UnimplementedException e) {
			throw new UnimplementedException();
		}
		return userRepository;
	}

}