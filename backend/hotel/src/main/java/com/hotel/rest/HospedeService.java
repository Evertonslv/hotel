package com.hotel.rest;

import java.util.List;

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
import com.hotel.model.Hospede;
import com.hotel.model.dao.HospedeDAO;

@Path("/hospede")
public class HospedeService {

	private static final String CHARSET_UTF8 = ";charset=utf-8";
	private HospedeDAO dao;

	@PostConstruct
	private void init() {
		dao = new HospedeDAO();
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTodosHospedes() {
		
		List<Hospede> lista;
		lista = dao.listarTodos();

		Gson g = new Gson();
		return g.toJson(lista);
	}

	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getHospede(@PathParam("id") int codigoHospede) {
		Gson g = new Gson();
		return g.toJson(dao.buscar(codigoHospede));
	}

	@GET
	@Path("/hospedesemchekin")
	@Produces(MediaType.APPLICATION_JSON)
	public String getHospedeSemChekin() {
		
		List<Hospede> lista;
		lista = dao.listarHospedeSemCheckin();

		Gson g = new Gson();
		return g.toJson(lista);
	}

	@GET
	@Path("/hospedecomchekin")
	@Produces(MediaType.APPLICATION_JSON)
	public String getHospedeComChekin() {
		
		List<Hospede> lista;

		lista = dao.listarHospedeComCheckin();

		Gson g = new Gson();
		return g.toJson(lista);
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String insereHospede(Hospede hospede) {
		
		String msg = "";

		if(dao.inserir(hospede))
			msg = "Hospede adicionado com sucesso!";
		else
			msg = "Erro ao adicionar hospede!";		

		return msg;
	}

	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String alteraHospede(Hospede hospede, @PathParam("id") int codigoHospede) {

		String msg = "";
		
		hospede.setCodigo(codigoHospede);

		if(dao.atualizar(hospede))
			msg = "Hospede atualizado com sucesso!";
		else
			msg = "Erro ao atualizar hospede!";


		return msg;
	}

	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletaHospede(@PathParam("id") int codigoHospede) {

		String msg = "";

		if(dao.remover(codigoHospede))
			msg = "Hospede removido com sucesso!";
		else
			msg = "Erro ao remover hospede!";


		return msg;
	}

}
