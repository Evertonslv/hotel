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
import com.hotel.model.Checkin;
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

		if(lista.size() == 0)
			return "N�o existe hospede cadastrado!";
		
		Gson g = new Gson();
		return g.toJson(lista);
	}
	
	@GET
	@Path("/checkin/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCheckin(@PathParam("id") int codigoHospede) {
		
		List<Checkin> listaCheckin;		
		listaCheckin = dao.listarCheckin(codigoHospede);	
		
		if(listaCheckin.size() == 0)
			return "N�o existe checkin para esse hospede!";
				
		Gson g = new Gson();
		return g.toJson(listaCheckin);
	}

	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getHospede(@PathParam("id") int codigoHospede) {
		
		Hospede hospede = dao.buscar(codigoHospede);
		
		if(hospede == null)
			return "N�o existe hospede com esse c�digo!";
		
		Gson g = new Gson();
		return g.toJson(hospede);
	}

	@GET
	@Path("/hospedenohotel")
	@Produces(MediaType.APPLICATION_JSON)
	public String getHospedeSemChekin() {
		
		List<Hospede> lista;
		lista = dao.listarHospedeNoHotel();

		if(lista.size() == 0)
			return "N�o existe hospede no hotel!";
		
		Gson g = new Gson();
		return g.toJson(lista);
	}

	@GET
	@Path("/hospedecomchekin")
	@Produces(MediaType.APPLICATION_JSON)
	public String getHospedeComChekin() {
		
		List<Hospede> lista;
		lista = dao.listarHospedeComCheckin();
		
		if(lista.size() == 0)
			return "N�o existe hospede com checkin!";

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
