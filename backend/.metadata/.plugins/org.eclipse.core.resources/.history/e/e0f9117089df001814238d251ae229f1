package com.hotel.rest;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.hotel.model.Checkin;
import com.hotel.model.dao.CheckinDAO;

@Path("/checkin")
public class CheckinService {
	
	private CheckinDAO dao;
	
	@PostConstruct
	private void init() {
		dao = new CheckinDAO();
	}
	
	@GET
	@Path("/todoscomcheckin")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTodosComCheckin() {
		Gson g = new Gson();
		return g.toJson(dao.listarTodosComCheckin());
	}
	
	@GET
	@Path("/todossemcheckin")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTodosSemCheckin() {
		Gson g = new Gson();
		return g.toJson(dao.listarTodosSemCheckin());
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCheckin(@PathParam("id") int codigoCheckin) {
		Gson g = new Gson();
		return g.toJson(dao.buscar(codigoCheckin));
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insereCheckin(Checkin checkin) {
		
		String msg = "";

		if(dao.inserir(checkin))
			msg = "Checkin adicionado com sucesso!";
		else
			msg = "Erro ao adicionar checkin!";		

		return msg;
	}

	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String alteraCheckin(Checkin checkin, @PathParam("id") int codigoCheckin) {

		String msg = "";
		
		if(checkin.getCodigo() == 0)
			checkin.setCodigo(codigoCheckin);

		if(dao.atualizar(checkin))
			msg = "Checkin atualizado com sucesso!";
		else
			msg = "Erro ao atualizar checkin!";


		return msg;
	}

	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletaCheckin(@PathParam("id") int codigoCheckin) {

		String msg = "";

		if(dao.remover(codigoCheckin))
			msg = "Checkin removido com sucesso!";
		else
			msg = "Erro ao remover checkin!";

		return msg;
	}


}
