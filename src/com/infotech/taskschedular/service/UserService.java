package com.infotech.taskschedular.service;

import java.util.List;

import com.infotech.taskschedular.domain.User;

/**
 * @author udakhe.swaraj
 *
 */
public interface UserService {

	/**
	 * @author udakhe.swaraj
	 * This is an interface of Insert method which is use for inserting User's data for registration purpose.
	 * @param user
	 * @return
	 */
	 public int addUser(User user);
	 
	 /**
	  * @author udakhe.swaraj
	  * This is an interface of Update method which is use for updating User's data. 
	  * @param user
	  * @return
	  */
	 public int updateUserData(User user);
	 
	 /**
	  * @author udakhe.swaraj
	  * This is an interface of Delete method which is used to Delete user.
	  * @param id
	  * @return
	  */
	 public int deleteUserAccount(Integer id);
	 
	 /**
	  * @author udakhe.swaraj
	  * This is an interface of Login to authenticate User.  
	  * @param loginname
	  * @return
	  */
	 public int login(String loginname);
	 
	 /**
	  * @author udakhe.swaraj
	  * This is an interface for Displaying List of Users
	  * @return
	  */
	 public List<User> usersList(List<Integer> list);
	 
	 /**
	  * @author udakhe.swaraj
	  * This is an interface for Get a particular user from it's id. 
	  * @param id
	  * @return
	  */
	 public User getUserDetail(Integer id);
	
}
