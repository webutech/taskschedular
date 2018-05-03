package com.infotech.taskschedular.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.infotech.taskschedular.dao.TaskDAO;
import com.infotech.taskschedular.domain.Task;
import com.infotech.taskschedular.service.TaskService;

/**
 * This class will provide implementation of TaskService interface
 * 
 * @author giradkar.akshay
 *
 */

public class TaskServiceImpl implements TaskService {

	private TaskDAO taskDao;
	private Task task;

	/**
	 * 
	 * This method is the implementation of insertTask method will insert task
	 * 
	 * @author giradkar.akshay
	 * 
	 */
	@Override
	public int insertTask(Task task) {

		if (task != null) {

			return 1;
		} else {
			return 0;
		}
	}
	
	
	/**
	 * This method is the user task login purpose
	 * 
	 * @author giradkar.akshay
	 */
	@Override
	public Integer loginName(String username) {

		if (username.isEmpty()) {

			return 0;
		} else {
			return 1;
		}

	}

	public void setTaskDao(TaskDAO taskDao) {
		this.taskDao = taskDao;
	}

	/**
	 * This method is the implementation of deleteTask method will delete task
	 * 
	 * @author giradkar.akshay
	 */

	@Override
	public int deleteTask(Integer id) {

		if (id != null) {

			return 1;
		} else {
			return 0;
		}

	}

	/**
	 * 
	 * This method is the implementation of updateTask method will update task
	 * 
	 * @author giradkar.akshay
	 */

	@Override
	public int updateTask(Integer id) {

		if (id != null) {

			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * This method is the implementation of listAllTask method will list all task by
	 * userId
	 * 
	 * @author giradkar.akshay
	 */

	@Override
	public List<Task> listAllTask(Integer userId) {

		List<Task> list = new ArrayList<Task>();

		if (list.size() == 0) {

			return null;
		} else {
			return list;
		}
	}

	/**
	 * This method is the implementation of getTaskBy method will insert task
	 * 
	 * @author giradkar.akshay
	 */

	@Override
	public Task getTaskById(Integer id) {

		Task task = new Task();

		if (id != null) {

			return task;
		} else {
			return null;
		}

	}
	

}
