package com.hotel.model.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {

	private static final String banco = "jdbc:postgresql://localhost:5432/hotel";	
	private static final String driver = "org.postgresql.Driver";	
	private static final String usuario = "postgres";
	private static final String senha = "123456";  
	private static Connection con = null;

	public static Connection getConexao(){

		if (con == null){
			try {

				Class.forName(driver);
				con = DriverManager.getConnection(banco, usuario, senha);
				
			} catch (SQLException ex) {
				System.out.println("Erro ao conectar: " + ex.getMessage());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return con;
	}
	
	public static PreparedStatement getPreparedStatement(String sql){

		if (con == null){
			con = getConexao();
		}
		try {
			return con.prepareStatement(sql);
		} catch (SQLException e){
			System.out.println("Erro de sql: " + e.getMessage());
		}
		return null;
	}
	
}
