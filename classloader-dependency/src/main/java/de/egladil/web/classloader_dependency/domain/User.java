// =====================================================
// Project: classloader-dependency
// (c) Heike Winkelvoß
// =====================================================
package de.egladil.web.classloader_dependency.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * User
 */
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	/**
	 *
	 */
	public User() {

	}

	/**
	 * @param id
	 * @param name
	 */
	public User(final String name) {

		this.name = name;
	}

	public Long getId() {

		return id;
	}

	public void setId(final Long id) {

		this.id = id;
	}

	public String getName() {

		return name;
	}

	public void setName(final String name) {

		this.name = name;
	}

}
