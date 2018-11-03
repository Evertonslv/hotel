package com.hotel.controler;

import java.util.Calendar;

import com.hotel.model.Checkin;

public class CalculaValor {

	private static final double DIA_SEMANA = 120.00;
	private static final double FINAL_SEMANA = 150.00;
	private static final double VAGAGARAGEM_DIASEMANA = 15.00;
	private static final double VAGAGARAGEM_FINALSEMANA = 20.00;

	@SuppressWarnings("static-access")
	public double calcular(Checkin checkin) {

		Calendar dataEntrada = Calendar.getInstance();
		dataEntrada.setTimeInMillis(checkin.getDataEntrada().getTime());
		int finalSemana = 0, diaSemana = 0;
		double valorTotal = 0;

		Calendar dataFinal = Calendar.getInstance();

		if(checkin.getDataSaida() != null)
			dataFinal.setTimeInMillis(checkin.getDataSaida().getTime());

		dataFinal.add(Calendar.DAY_OF_MONTH, -1);

		while (dataEntrada.before(dataFinal)) {
			if(dataEntrada.get(dataEntrada.DAY_OF_WEEK) == Calendar.SATURDAY || dataEntrada.get(dataEntrada.DAY_OF_WEEK) == Calendar.SUNDAY)
				finalSemana ++;
			else
				diaSemana ++;

			dataEntrada.add(Calendar.DAY_OF_MONTH, 1);
		}

		// Verifica se o ultimo checkin ultrapassa as 16:30 hs  
		if(dataFinal.get(Calendar.HOUR_OF_DAY) > 16 || 
				(dataFinal.get(Calendar.HOUR_OF_DAY) == 16 && dataFinal.get(Calendar.MINUTE) > 30)) {

			if(dataFinal.get(dataFinal.DAY_OF_WEEK) == Calendar.SATURDAY || dataFinal.get(dataFinal.DAY_OF_WEEK) == Calendar.SUNDAY)
				finalSemana ++;
			else
				diaSemana ++;
		}

		if(finalSemana > 0) {
			valorTotal += (finalSemana * FINAL_SEMANA);
			valorTotal += (finalSemana * VAGAGARAGEM_FINALSEMANA);
		}

		if(diaSemana > 0) {
			valorTotal += (diaSemana * DIA_SEMANA);
			valorTotal += (diaSemana * VAGAGARAGEM_DIASEMANA);
		}


		return valorTotal;
	}
}