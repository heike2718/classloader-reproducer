// =====================================================
// Project: classloader-dependency
// (c) Heike Winkelvoß
// =====================================================
package de.egladil.web.classloader_dependency.dao.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.egladil.web.classloader_dependency.dao.IUserDao;
import de.egladil.web.classloader_dependency.domain.User;

/**
 * UserDao
 */
@RequestScoped
public class UserDao implements IUserDao {

    @PersistenceContext
    EntityManager em;

	/**
	 *
	 */
	public UserDao() {
	}

	@Override
	public List<User> getUsers() {

		return em.createQuery("select u from User u", User.class).getResultList();
	}

}
