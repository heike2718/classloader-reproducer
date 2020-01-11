// =====================================================
// Project: classloader-dependency
// (c) Heike Winkelvoß
// =====================================================
package de.egladil.web.classloader_dependency.domain;

/**
 * User
 */
public class User {

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
	public User(final Long id, final String name) {

		this.id = id;
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
