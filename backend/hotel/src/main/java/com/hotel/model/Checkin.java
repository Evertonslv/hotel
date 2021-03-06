package com.hotel.model;

import java.sql.Timestamp;

import com.hotel.controler.CalculaValor;

public class Checkin {

	private int codigo;
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
		if(this.valor == 0 && this.dataSaida != null)
			this.valor = new CalculaValor().calcular(this);

		return this.valor;
	}		
	public void setValor(double valor) {		
		if(valor == 0 && this.dataSaida != null)
			this.valor = new CalculaValor().calcular(this);
		else
			this.valor = valor;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
