package de.egladil.web.classloader_quarkus;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.egladil.web.classloader_dependency.domain.User;
import de.egladil.web.classloader_dependency.service.IUserService;
import de.egladil.web.classloader_quarkus.service.IOwnService;

@Path("quarkus")
public class ExampleResource {

	private static final Logger LOG = LoggerFactory.getLogger(ExampleResource.class);

	@Inject
	IUserService userService;

	@Inject
	IOwnService ownService;

	@GET
	@Path("users")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {

		try {

			userService.createNewUser();

		} catch (NullPointerException e) {
			LOG.error(e.getMessage(), e);
			return Response.serverError().entity("{\"message\": \"ERROR: on createting a new user\"" + e.getMessage() + "}").build();
		}

		try {

			List<User> users = userService.loadUsers();
			return Response.ok(users).build();

		} catch (NullPointerException e) {
			LOG.error(e.getMessage(), e);
			return Response.serverError().entity("{\"message\": \"ERROR: on loading the users\"" + e.getMessage() + "}").build();
		}

	}

	@GET
	@Path("hello")
	public Response hello() {

		return Response.ok(ownService.sayHello()).build();

	}

}
