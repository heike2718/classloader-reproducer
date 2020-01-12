package de.egladil.web.classloader_quarkus;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.egladil.web.classloader_dependency.dao.IUserDao;
import de.egladil.web.classloader_dependency.domain.User;
import de.egladil.web.classloader_quarkus.service.IOwnService;

@Path("quarkus")
public class ExampleResource {

	@Inject
	IUserDao userDao;

	@Inject
	IOwnService ownService;

	@GET
	@Path("users")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {


		User user = userDao.persistUser();
		if (user == null) {
			return Response.serverError().entity("{\"message\": \"ERROR: userDao.persist returned null\"}").build();
		}

		List<User> users = userDao.getUsers();

		if (users == null) {
			return Response.serverError().entity("{\"message\": \"ERROR: userDao.getUser returned null\"}").build();
		}

		return Response.ok(users).build();

	}

	@GET
	@Path("hello")
	public Response hello() {

		return Response.ok(ownService.sayHello()).build();

	}

}
