// =====================================================
// Project: classloader-dependency
// (c) Heike Winkelvoß
// =====================================================
package de.egladil.web.classloader_dependency.dao.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.egladil.web.classloader_dependency.dao.IUserDao;
import de.egladil.web.classloader_dependency.domain.User;

/**
 * UserDao
 */
@RequestScoped
@Transactional
public class UserDao implements IUserDao {

	private static final Logger LOG = LoggerFactory.getLogger(UserDao.class);


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
			LOG.error(" <== entityManager is null");
			return null;
		}

		return em.createQuery("select u from User u", User.class).getResultList();
	}

	@Override
	public User persistUser() {

		if (em == null) {
			LOG.error(" ==> entityManager is null");
			return null;
		}

		User user = new User(System.currentTimeMillis(), "Horst");

		em.persist(user);

		return user;
	}

}
