package com.infotech.taskschedular.serviceimpl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.infotech.taskschedular.dao.UserDAO;
import com.infotech.taskschedular.domain.User;
import com.infotech.taskschedular.exception.ServiceBOException;
import com.infotech.taskschedular.service.UserService;
import com.infotech.taskschedular.serviceimpl.UserServiceImpl;

public class UserServiceImplTest {

	User user;

	@Mock
	UserDAO userDAO;

	@Before
	public void setUp() throws Exception {

		user = new User();
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_method_for_illegal_argument_exception() throws Exception{

		UserService service = new UserServiceImpl();

		doThrow(IllegalArgumentException.class).when(userDAO).registerUser(user);

		userDAO.registerUser(user);
		
		int result = service.addUser(user);

		assertEquals(0, result);
		
		verify(userDAO).registerUser(user);

	}

	@Test
	public void test_method_userDAOImpl_for_insert_opeartion_having_null_value() throws SQLException, ServiceBOException {

		UserService service = new UserServiceImpl();

		when(userDAO.registerUser(user)).thenReturn(0);

		userDAO.registerUser(user);
		
		int result = service.addUser(null);

		assertEquals(0, result);

		verify(userDAO).registerUser(user);

	}

	@Test
	public void test_method_for_userDAOImpl_insert_operation() throws SQLException, ServiceBOException{

		UserService service = new UserServiceImpl();

		when(userDAO.registerUser(user)).thenReturn(1);

		user.setId(1);
		user.setFirstname("Swaraj");
		user.setLastname("Udakhe");
		user.setEmail("uswaraj@yahoo.com");
		user.setContact("9876543210");
		user.setAddress("Pune");
		user.setLoginname("swaraj");
		user.setPassword("swaraj@123");
		user.setStatus(1);
		user.setRole(1);

		userDAO.registerUser(user);

		int result = service.addUser(user);

		assertEquals(1, result);

		verify(userDAO).registerUser(user);

	}

	@Test
	public void test_method_userDAOImpl_for_update_operation_havnig_null_values() throws SQLException, ServiceBOException{

		UserService service = new UserServiceImpl();

		when(userDAO.updateUser(user)).thenReturn(0);

		userDAO.updateUser(user);
		
		int result = service.updateUserData(null);

		assertEquals(1, result);
		
		verify(userDAO).updateUser(user);

	}

	@Test
	public void test_method_for_userDAOImpl_update_operation() throws SQLException, ServiceBOException{

		UserService service = new UserServiceImpl();

		when(userDAO.updateUser(user)).thenReturn(1);

		user.setId(1);
		user.setFirstname("Santosh");
		user.setLastname("Pandey");
		user.setEmail("santosh@yahoo.com");
		user.setContact("7654321098");
		user.setAddress("Patna");
		user.setLoginname("santosh");
		user.setPassword("santosh@123");
		user.setStatus(2);
		user.setRole(2);

		userDAO.updateUser(user);

		int result = service.addUser(user);

		assertEquals(1, result);

		verify(userDAO).updateUser(user);

	}

	@Test
	public void test_method_userDAOImpl_for_delete_operation_having_null_value() throws SQLException, ServiceBOException{

		UserService service = new UserServiceImpl();

		Integer id = null;
		when(userDAO.deleteUser(id)).thenReturn(0);

		userDAO.deleteUser(id);
		
		int result = service.deleteUserAccount(id);

		assertEquals(0, result);
		
		verify(userDAO).deleteUser(id);

	}

	@Test
	public void test_method_for_userDAOImpl_value_delete_operation() throws SQLException, ServiceBOException{

		UserService service = new UserServiceImpl();

		Integer id = 1;
		when(userDAO.deleteUser(id)).thenReturn(1);

		userDAO.deleteUser(id);
		
		int result = service.deleteUserAccount(id);

		assertEquals(1, result);
		
		verify(userDAO).deleteUser(id);

	}

	@Test
	public void test_method_userDAOImpl_for_validate_user_by_loginName_having_null_value() throws SQLException, ServiceBOException{

		UserService service = new UserServiceImpl();

		String loginname = "";
		when(userDAO.loginUser(loginname)).thenReturn(0);

		userDAO.loginUser(loginname);
		
		int result = service.login(loginname);

		assertEquals(0, result);
		
		verify(userDAO).loginUser(loginname);

	}

	@Test
	public void test_method_userDAOImpl_for_validate_user_by_loginName_having_not_null_value()
			throws SQLException, ServiceBOException{

		UserService service = new UserServiceImpl();

		String loginname = "swaraj";
		when(userDAO.loginUser(loginname)).thenReturn(1);

		userDAO.loginUser(loginname);
		
		int result = service.login(loginname);

		assertEquals(1, result);
		
		verify(userDAO).loginUser(loginname);

	}

	@Test
	public void test_method_for_userDAOImpl_having_null_list_users() throws SQLException, ServiceBOException{

		UserService service = new UserServiceImpl();

		List<Integer> list = null;

		when(userDAO.listOfUser(list)).thenReturn(null);

		userDAO.listOfUser(list);
		
		List<User> result = service.usersList(list);

		assertEquals(null, result);
		
		verify(userDAO).listOfUser(list);

	}

	@Test
	public void test_method_userDAOImpl_for_user_details_by_id_returning_null_value() throws SQLException, ServiceBOException{

		UserService service = new UserServiceImpl();

		Integer id = null;
		when(userDAO.getUserById(id)).thenReturn(null);

		userDAO.getUserById(id);
		
		User result = service.getUserDetail(id);

		assertEquals(null, result);
		 
		verify(userDAO).getUserById(id);

	}

	@Test
	public void test_method_for_userDAOImpl_for_user_details_by_id() throws SQLException, ServiceBOException{

		UserService service = new UserServiceImpl();

		Integer id = 1;
		when(userDAO.getUserById(id)).thenReturn(user);

		userDAO.getUserById(id);
		
		User result = service.getUserDetail(id);

		assertEquals(null, result);
		
		verify(userDAO).getUserById(id);

	}

}
