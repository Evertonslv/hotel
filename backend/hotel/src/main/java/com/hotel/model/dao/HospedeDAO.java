package com.hotel.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.hotel.model.Hospede;
import com.hotel.model.config.Conexao;

public class HospedeDAO {
	
	public boolean inserir(Hospede hospede)
	{
		String sql = "INSERT INTO hospede(nome_hos,docume_hos,telefo_hos) VALUES(?,?,?)";
		Boolean retorno = false;
		PreparedStatement pst = Conexao.getPreparedStatement(sql);
		try {
			
			pst.setString(1, hospede.getNome());
			pst.setString(2, hospede.getDocumento());
			pst.setString(3, hospede.getTelefone());
			
			if(pst.executeUpdate()>0)
			{
				retorno = true;
			}

		} catch (SQLException ex) {
			Logger.getLogger(HospedeDAO.class.getName()).log(Level.SEVERE, null, ex);
			retorno = false;
		}

		return retorno;

	}
	public boolean atualizar(Hospede hospede)
	{
		String sql = "UPDATE hospede set nome_hos=?,docume_hos=?,telefo_hos=? where codigo_hos=?";
		Boolean retorno = false;
		PreparedStatement pst = Conexao.getPreparedStatement(sql);

		try {

			pst.setString(1, hospede.getNome());
			pst.setString(2, hospede.getDocumento());
			pst.setString(3, (hospede.getTelefone()));
			pst.setInt(4, hospede.getCodigo());

			if(pst.executeUpdate()>0)
			{
				retorno = true;
			}



		} catch (SQLException ex) {
			Logger.getLogger(HospedeDAO.class.getName()).log(Level.SEVERE, null, ex);
			retorno = false;
		}

		return retorno;

	}
	public boolean remover(int codigo)
	{
		String sql = "DELETE FROM hospede where codigo_hos=?";
		Boolean retorno = false;
		PreparedStatement pst = Conexao.getPreparedStatement(sql);

		try {
			pst.setInt(1, codigo);

			if(pst.executeUpdate()>0)
			{
				retorno = true;
			}            

		} catch (SQLException ex) {
			Logger.getLogger(HospedeDAO.class.getName()).log(Level.SEVERE, null, ex);
			retorno = false;
		}

		return retorno;

	}

	public Hospede buscar(int codigo)
	{
		String sql = "SELECT * FROM hospede where codigo_hos=?";
		Hospede hospede = null;

		PreparedStatement pst = Conexao.getPreparedStatement(sql);
		try {

			pst.setInt(1, codigo);
			ResultSet res = pst.executeQuery();

			if(res.next())
			{
				hospede = new Hospede();
				hospede.setCodigo(Integer.parseInt(res.getString("codigo_hos")));
				hospede.setNome(res.getString("nome_hos"));
				hospede.setDocumento(res.getString("docume_hos"));
				hospede.setTelefone(res.getString("telefo_hos"));
			}



		} catch (SQLException ex) {
			Logger.getLogger(HospedeDAO.class.getName()).log(Level.SEVERE, null, ex);

		}

		return hospede;

	}
	
	public List<Hospede> listarHospedeComCheckin()
	{
		String sql = "select * from hospede inner join checkin on codhos_che = codigo_hos where datsai_che is not null;";
		List<Hospede> listaRetorno = new ArrayList<Hospede>();

		PreparedStatement pst = Conexao.getPreparedStatement(sql);
		try {           

			ResultSet res = pst.executeQuery();
			listaRetorno = setValuesHospede(res);

		} catch (SQLException ex) {
			Logger.getLogger(HospedeDAO.class.getName()).log(Level.SEVERE, null, ex);

		}

		return listaRetorno;

	}
	private List<Hospede> setValuesHospede(ResultSet res) throws SQLException {
		List<Hospede> listaRetorno = new ArrayList<Hospede>();
		
		while(res.next())
		{
			Hospede hospede = new Hospede();
			hospede.setCodigo(res.getInt("codigo_hos"));
			hospede.setNome(res.getString("nome_hos"));
			hospede.setDocumento(res.getString("docume_hos"));
			hospede.setTelefone(res.getString("telefo_hos"));

			listaRetorno.add(hospede);
		}
		
		return listaRetorno;
	}

	public List<Hospede> listarHospedeSemCheckin()
	{
		String sql = "select * from hospede inner join checkin on codhos_che = codigo_hos where datsai_che is null;";
		List<Hospede> listaRetorno = new ArrayList<Hospede>();

		PreparedStatement pst = Conexao.getPreparedStatement(sql);
		try {           

			ResultSet res = pst.executeQuery();
			listaRetorno = setValuesHospede(res);


		} catch (SQLException ex) {
			Logger.getLogger(HospedeDAO.class.getName()).log(Level.SEVERE, null, ex);
		}

		return listaRetorno;

	}
	
	public List<Hospede> listarTodos()
	{
		String sql = "select * from hospede;";
		List<Hospede> listaRetorno = new ArrayList<Hospede>();

		PreparedStatement pst = Conexao.getPreparedStatement(sql);
		try {           

			ResultSet res = pst.executeQuery();
			listaRetorno = setValuesHospede(res);


		} catch (SQLException ex) {
			Logger.getLogger(HospedeDAO.class.getName()).log(Level.SEVERE, null, ex);
		}

		return listaRetorno;

	}
	public int getCodigoHospede(Hospede hospede) {
		String sql = "SELECT * FROM hospede where nome_hos=? and docume_hos=? and telefo_hos=?";

		int codigoRetorno = 0;
		
		PreparedStatement pst = Conexao.getPreparedStatement(sql);
		try {

			pst.setString(1, hospede.getNome());
			pst.setString(2, hospede.getDocumento());
			pst.setString(3, hospede.getTelefone());
			
			ResultSet res = pst.executeQuery();

			if(res.next()) {
				codigoRetorno = res.getInt("codigo_hos");
			}

		} catch (SQLException ex) {
			Logger.getLogger(HospedeDAO.class.getName()).log(Level.SEVERE, null, ex);
		}

		return codigoRetorno;
	}
	
}
