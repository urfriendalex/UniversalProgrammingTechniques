package repositories.interfaces;

import dtos.UserDTO;

import java.util.List;


public interface IUserRepository extends IRepository<UserDTO> {

	List<UserDTO> findByName(String username);
}