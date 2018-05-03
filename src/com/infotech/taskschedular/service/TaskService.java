package com.infotech.taskschedular.service;

import java.util.List;

import com.infotech.taskschedular.domain.Task;

/**
 * This interface contains all abstract methods of user tasks which will be
 * implemented in TaskServiceImpl class
 * 
 * @author giradkar.akshay
 *
 */

public interface TaskService {

	/**
	 * This Method will insert task into database
	 * 
	 * @return integer 0-fail and 1-inserted
	 * @author giradkar.akshay
	 *
	 */
	public int insertTask(Task task);

	/**
	 * This Method will delete task from database on the basis of their IDs
	 * 
	 * @return integer 0-fail and 1-deleted
	 * @author giradkar.akshay
	 *
	 */
	public int deleteTask(Integer id);

	/**
	 * This Method will update task to database
	 * 
	 * @return integer 0-fail and 1-updated
	 * @author giradkar.akshay
	 *
	 */
	public int updateTask(Integer id);

	/**
	 * This Method will perform authentication process using userName of user
	 * 
	 * @author giradkar.akshay
	 *
	 */

	public Integer loginName(String username);

	/**
	 * This Method will list all task from database on the basis of their IDs
	 * 
	 * @author giradkar.akshay
	 *
	 */
	public List<Task> listAllTask(Integer userId);

	/**
	 * This Method will show task by respective ID
	 * 
	 * @author giradkar.akshay
	 *
	 */
	public Task getTaskById(Integer id);

}
