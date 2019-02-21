package test;

import dtos.DTOBase;
import org.junit.After;
import org.junit.Before;
import repositories.interfaces.IRepository;

import java.sql.SQLException;


public abstract class RepositoryTestBase<TDTO extends DTOBase, TRepository extends IRepository<TDTO>> {

	private TRepository _repository;

	@Before
	public void before() {
		_repository = Create();
		if (_repository != null) {
			_repository.beginTransaction();
		}
	}

	@After
	public void after() {
		if (_repository != null) {
			_repository.rollbackTransaction();
			_repository.close();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected abstract TRepository Create();
}