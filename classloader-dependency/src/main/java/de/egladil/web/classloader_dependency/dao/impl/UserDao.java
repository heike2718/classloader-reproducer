// =====================================================
// Project: classloader-dependency
// (c) Heike Winkelvoß
// =====================================================
package de.egladil.web.classloader_dependency.dao.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import de.egladil.web.classloader_dependency.dao.IUserDao;
import de.egladil.web.classloader_dependency.domain.User;

/**
 * UserDao
 */
@RequestScoped
public class UserDao implements IUserDao {

//	@PersistenceContext
	@Inject
	EntityManager em;

	/**
	 *
	 */
	public UserDao() {
	}

	@Override
	public List<User> getUsers() {

		if (em == null) {
			throw new NullPointerException("em is null");
		}

		return em.createQuery("select u from User u", User.class).getResultList();
	}

	@Override
	public User persistUser(User user) {

		if (em == null) {
			throw new NullPointerException("em is null");
		}

		if (user.getId() == null) {

			em.persist(user);
			return user;

		}

		return em.merge(user);
	}

}
