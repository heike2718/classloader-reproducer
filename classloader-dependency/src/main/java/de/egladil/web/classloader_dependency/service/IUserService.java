//=====================================================
// Project: classloader-dependency
// (c) Heike Winkelvoß
//=====================================================
package de.egladil.web.classloader_dependency.service;

import java.util.List;

import de.egladil.web.classloader_dependency.domain.User;

/**
* IUserService
*/
public interface IUserService {

	User createNewUser();

	List<User> loadUsers();

}
