package com.hotel.model;

import java.sql.Timestamp;

import com.hotel.controler.CalculaValor;

public class Checkin {
	
	private int codigo;
	private int codigoHospede;
	private Timestamp dataEntrada;
	private Timestamp dataSaida;
	private boolean isVeiculo;
	private double valor;
	private double ultimoValor;
	
	public double getUltimoValor() {
		return ultimoValor;
	}
	public void setValorUltmoCheckin(double ultimoValor) {
		this.ultimoValor = ultimoValor;
	}
	private Hospede hospede;
	
	public Hospede getHospede() {
		return hospede;
	}
	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}
	public double getValor() {		
		return this.valor;
	}
		
	public void setValor() {
		this.valor = new CalculaValor().calcular(this);
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigoHospede() {
		return codigoHospede;
	}
	public void setCodigoHospede(int codigoHospede) {
		this.codigoHospede = codigoHospede;
	}
	public Timestamp getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Timestamp dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public Timestamp getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Timestamp dataSaida) {
		this.dataSaida = dataSaida;
	}
	public boolean isVeiculo() {
		return isVeiculo;
	}
	public void setVeiculo(boolean isVeiculo) {
		this.isVeiculo = isVeiculo;
	}	
}
