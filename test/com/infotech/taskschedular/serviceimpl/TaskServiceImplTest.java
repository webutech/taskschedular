package com.infotech.taskschedular.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.infotech.taskschedular.dao.TaskDAO;
import com.infotech.taskschedular.domain.Task;
import com.infotech.taskschedular.exception.ServiceBOException;
import com.infotech.taskschedular.service.TaskService;

/**
 * This TaskServiceImplTest class will perform for all implementations of
 * methods of taskService
 * 
 * @author giradkar.akshay
 *
 */

public class TaskServiceImplTest {

	Task task = new Task();
	Integer id = null;

	@Mock
	TaskDAO taskDao;

	/**
	 * This method will point before every test case execution
	 * 
	 * @author giradkar.akshay
	 */
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * This insert method will perform checking if task is empty or not
	 * 
	 * @author giradkar.akshay
	 */
	@Test
	public void test_method_for_insertion_of_task_for_checking_empty_value() throws Exception {

		TaskService service = new TaskServiceImpl();

		when(taskDao.insertTask(task)).thenReturn(true);

		taskDao.insertTask(task);

		int result = service.insertTask(null);

		assertEquals(0, result);

		verify(taskDao).insertTask(task);

	}

	/**
	 * This test method will check whether for invalid argument is coming from user
	 * 
	 * @author giradkar.akshay
	 */

	@Test(expected = IllegalArgumentException.class)
	public void test_method_for_illegal_argument_exception() throws Exception {

		TaskService service = new TaskServiceImpl();

		doThrow(IllegalArgumentException.class).when(taskDao).insertTask(task);

		taskDao.insertTask(task);

		int result = service.insertTask(task);

		assertEquals(0, result);

		verify(taskDao).insertTask(task);

	}

	/**
	 * This test method will perform whether there is sqlException in the SQL query
	 * or not
	 * 
	 * @author giradkar.akshay
	 */

	@SuppressWarnings("unchecked")
	@Test
	public void test_method_for_checking_sqlException_of_inserting_query() throws SQLException, ServiceBOException {

		TaskService service = new TaskServiceImpl();

		when(taskDao.insertTask(task)).thenThrow(SQLException.class);

		assertEquals(1, service.insertTask(task));

	}

	/**
	 * This insert method will perform actual insertion operation of tasks
	 * 
	 * @author giradkar.akshay
	 */

	@Test
	public void test_method_for_inserting_tasks() throws Exception {

		TaskService service = new TaskServiceImpl();

		when(taskDao.insertTask(task)).thenReturn(true);

		task.setId(1);
		task.setTitle("ORACLE");
		task.setDescription("ADMIN");
		task.setStartdate("01/05/2018");
		task.setEnddate("30/05/2018");
		task.setUserid(101);
		task.setStatus(0);

		taskDao.insertTask(task);

		int result = service.insertTask(task);

		assertEquals(1, result);

		verify(taskDao).insertTask(task);

	}

	/**
	 * This test method will perform actual UPDATION of tasks on the basis of their
	 * respective IDs
	 * 
	 * @author giradkar.akshay
	 */

	@Test
	public void test_method_for_updating_tasks() throws Exception {

		TaskService service = new TaskServiceImpl();

		when(taskDao.updateTask(id)).thenReturn(true);

		task.setId(1);
		task.setTitle("ORACLE");
		task.setDescription("ADMIN");
		task.setStartdate("01/05/2018");
		task.setEnddate("30/05/2018");
		task.setUserid(101);
		task.setStatus(0);

		taskDao.updateTask(id);

		int result = service.insertTask(task);

		assertEquals(1, result);

		verify(taskDao).updateTask(id);

	}


	/**
	 * This delete test method will perform checking if task is empty or not
	 * 
	 * @author giradkar.akshay
	 */

	@Test
	public void test_method_for_deletion_of_task_for_empty_value() throws Exception {

		TaskService service = new TaskServiceImpl();

		Mockito.when(taskDao.deleteTask(id)).thenReturn(true);
		
		taskDao.deleteTask(id);
		
		int result = service.deleteTask(id);

		assertEquals(0, result);

		verify(taskDao).deleteTask(id);
		

	}

	/**
	 * This test method will perform actual deletion of tasks on the basis of their
	 * respective IDs
	 * 
	 * @author giradkar.akshay
	 */

	@Test
	public void test_method_for_deleting_tasks() throws Exception {

		TaskService service = new TaskServiceImpl();
		

		Integer id = 1;

		when(taskDao.deleteTask(id)).thenReturn(true);
		
		taskDao.deleteTask(id);
		
		int result = service.deleteTask(id);

		assertEquals(1, result);

		verify(taskDao).deleteTask(id);

	}

	/**
	 * This  test method will perform checking authentication operation on the basis of userName 
	 * 
	 * @author giradkar.akshay
	 */
	

	@Test
	public void test_method_for_validate_user_by_loginName_having_null_value() throws SQLException, ServiceBOException{

		TaskService service = new TaskServiceImpl();

		String username = "";
		when(taskDao.loginName(username)).thenReturn(0);

		taskDao.loginName(username);
		
		int result = service.loginName(username);

		assertEquals(0, result);
		
		verify(taskDao).loginName(username);

	}
	

	@Test
	public void test_method_for_validate_user_by_loginName_having_not_null_value()
			throws SQLException, ServiceBOException{

		TaskService service = new TaskServiceImpl();

		String username = "akshay";
		when(taskDao.loginName(username)).thenReturn(1);

		taskDao.loginName(username);
		
		int result = service.loginName(username);

		assertEquals(1, result);
		
		verify(taskDao).loginName(username);

	}


	/**
	 * This test method will perform actual list of tasks on the basis of their
	 * respective id
	 * 
	 * @author giradkar.akshay
	 */

	@Test
	public void test_method_to_get_taskslist() throws Exception {

		TaskServiceImpl taskServiceImpl = new TaskServiceImpl();

		List<Task> taskList = new ArrayList<>();

		taskServiceImpl.setTaskDao(taskDao);

		when(taskDao.getAllTask(task.getUserid())).thenReturn(taskList);

		boolean result = taskList.add(task);

		assertTrue(result);

	}

	/**
	 * This test method is used for checking is taskList is empty or not
	 * 
	 * @author giradkar.akshay
	 */

	@Test
	public void test_method_for_checking_empty_list() throws Exception {

		TaskServiceImpl serviceImpl = new TaskServiceImpl();

		List<Task> taskList = new ArrayList<>();

		serviceImpl.setTaskDao(taskDao);

		when(taskDao.getAllTask(task.getUserid())).thenReturn(taskList);

		boolean result = taskList.add(null);

		assertTrue(result);

	}
	/**
	 * This test method will perform actual retrieve database of tasks on the basis
	 * of their respective id Check if it is null or not
	 * 
	 * @author giradkar.akshay
	 */

	
	@Test
	public void test_method_for_user_details_by_id_returning_null_value() throws SQLException, ServiceBOException{

		TaskService service = new TaskServiceImpl();

	
		when(taskDao.getTaskById(id)).thenReturn(true);

		taskDao.getTaskById(id);
		
		Task result = service.getTaskById(id);

		assertEquals(null, result);
		 
		verify(taskDao).getTaskById(id);

	}

	/**
	 * This test method will perform actual retrieve database of tasks on the basis
	 * of their respective id
	 * 
	 * @author giradkar.akshay
	 */

	@Test
	public void test_method_to_get_task_by_id() throws Exception {

		TaskService service = new TaskServiceImpl();
		
		when(taskDao.getTaskById(id)).thenReturn(true);

		taskDao.getTaskById(id);
		
	    Task result = service.getTaskById(id);

		assertEquals( null ,result);
		
		verify(taskDao).getTaskById(id);
		
	}

}
