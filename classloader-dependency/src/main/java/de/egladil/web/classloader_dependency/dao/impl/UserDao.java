// =====================================================
// Project: classloader-dependency
// (c) Heike Winkelvoß
// =====================================================
package de.egladil.web.classloader_dependency.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;

import de.egladil.web.classloader_dependency.dao.IUserDao;
import de.egladil.web.classloader_dependency.domain.User;

/**
 * UserDao
 */
@RequestScoped
public class UserDao implements IUserDao {

	private final Map<Long, User> users = new ConcurrentHashMap<>();

	/**
	 *
	 */
	public UserDao() {

		users.put(1l, new User(1l, "Sheldon"));
		users.put(2l, new User(2l, "Leonard"));
		users.put(3l, new User(3l, "Raj"));

	}

	@Override
	public List<User> getUsers() {

		return users.keySet().stream().map(key -> users.get(key)).collect(Collectors.toList());
	}

}
