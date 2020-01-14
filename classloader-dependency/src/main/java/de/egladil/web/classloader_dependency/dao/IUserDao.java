// =====================================================
// Project: classloader-dependency
// (c) Heike Winkelvoß
// =====================================================
package de.egladil.web.classloader_dependency.dao;

import java.util.List;

import de.egladil.web.classloader_dependency.domain.User;

/**
 * IUserDao
 */
public interface IUserDao {

	List<User> getUsers();

	User persistUser(User user);

}
