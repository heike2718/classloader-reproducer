//=====================================================
// Project: classloader-dependency
// (c) Heike Winkelvoß
//=====================================================
package de.egladil.web.classloader_dependency.service.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import de.egladil.web.classloader_dependency.dao.IUserDao;
import de.egladil.web.classloader_dependency.domain.User;
import de.egladil.web.classloader_dependency.service.IUserService;

/**
 * UserService
 */
@RequestScoped
public class UserService implements IUserService {

	@Inject
	IUserDao userDao;

	@Transactional
	@Override
	public User createNewUser() {
		return userDao.persistUser(new User("Horst " + System.currentTimeMillis()));
	}

	@Override
	public List<User> loadUsers() {
		return userDao.getUsers();
	}



}
