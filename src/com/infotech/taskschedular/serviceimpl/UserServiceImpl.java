package com.infotech.taskschedular.serviceimpl;

import java.util.List;

import com.infotech.taskschedular.dao.UserDAO;
import com.infotech.taskschedular.domain.User;
import com.infotech.taskschedular.service.UserService;

/**
 * @author udakhe.swaraj
 *
 */
public class UserServiceImpl implements UserService {

	private User user;
	
	/**
	 * @author udakhe.swaraj
	 * This is an implemented insert method having parameter of User.
	 */
	@Override
	public int addUser(User user) {

		if (user != null) {
			return 1;
		} else {

			return 0;
		}
	}

	/**
	 * @author udakhe.swaraj
	 * This is an implemented update method having parameter of User.
	 */
	@Override
	public int updateUserData(User user) {

		if (user != null) {
			return 1;
		} else {

			return 0;
		}
	}

	/**
	 * @author udakhe.swaraj
	 * This is an implemented delete method having parameter of User id.
	 */
	@Override
	public int deleteUserAccount(Integer id) {

		if (id != null) {
			return 1;
		} else {

			return 0;
		}
	}

	/**
	 * @author udakhe.swaraj
	 * This is an implemented login method having parameter of User's loginName
	 * and Password to validate user.
	 */
	@Override
	public int login(String loginname) {

		if (loginname.isEmpty()) {
			return 0;
		} else {

			return 1;
		}
	}

	/**
	 * @author udakhe.swaraj
	 * This is an implemented List method for showing list of users.
	 */
	@Override
	public List<User> usersList(List<Integer> list) {
		
		if (list != null) {
			return usersList(list);
		} else {

			return null;
		}
		
	}

	/**
	 * @author udakhe.swaraj
	 * This is an implemented getUserById method having parameter of User id
	 * for displaying particular user' details.
	 */
	@Override
	public User getUserDetail(Integer id) {

		if (id != null) {
			return user;
		} else {

			return null;
		}
	}

}
