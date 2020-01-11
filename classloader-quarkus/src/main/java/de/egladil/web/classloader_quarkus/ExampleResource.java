package de.egladil.web.classloader_quarkus;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.egladil.web.classloader_dependency.dao.IUserDao;
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

		return Response.ok(userDao.getUsers()).build();
	}

	@GET
	@Path("hello")
	public Response hello() {

		return Response.ok(ownService.sayHello()).build();

	}

}
