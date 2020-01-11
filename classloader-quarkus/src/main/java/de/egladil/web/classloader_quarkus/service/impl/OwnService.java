// =====================================================
// Project: classloader-quarkus
// (c) Heike Winkelvoß
// =====================================================
package de.egladil.web.classloader_quarkus.service.impl;

import javax.enterprise.context.RequestScoped;

import de.egladil.web.classloader_quarkus.service.IOwnService;

/**
 * OwnService
 */
@RequestScoped
public class OwnService implements IOwnService {

	@Override
	public String sayHello() {

		return "Hello from an internal dependency";
	}

}
