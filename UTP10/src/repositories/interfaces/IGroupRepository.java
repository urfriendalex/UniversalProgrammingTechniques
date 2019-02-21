package repositories.interfaces;

import dtos.GroupDTO;

import java.util.List;



public interface IGroupRepository extends IRepository<GroupDTO> {

	List<GroupDTO> findByName(String name);
}