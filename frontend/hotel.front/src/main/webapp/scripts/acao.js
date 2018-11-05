var listaHospede = [];

$(document).ready(function(){

	$("#btn-salvar").click(function() {
		incluirPessoa();
	});

	$("#bnt-incluir").click(function() {
		incluirPessoa();
	});

	$("input[type=radio][value=rb-presente]").click(function() {
		popularGrid(true);
	});

	$("input[type=radio][value=rb-deixaram]").click(function() {
		popularGrid(false);
	});

	$('#grd-hospede').DataTable( {
		"paging": false,
		"ordering": false,
		"info":     false,
		"searching": false
	} );

	$.getJSON("file/hospede.json", function(dados) {
		listaHospede = dados;
		popularGrid();
	});

});

function incluirPessoa() {

	var dados = {
			nome: $("#nome").val(),
			dataEntrada: $("#dataentrada").val(),
			dataSaida: $("#datasaida").val(),
			documento: $("#documento").val(),
			possuiveiculo: $("#possuiveiculo").val(),
			valor: "10.55"
	}

	listaHospede[listaHospede.length] = dados;	
	popularGrid();
}

function salvarPessoa() {
	var dadosJson = JSON.stringify(listaHospede, null, 4);
	saveAs(dadosJson, "hospede.json");
}

function popularGrid(hospedeNoHotel) {	

	var conteudoHtml = "";

	for(var i=0; i <listaHospede.length; i++) {			

		if(typeof hospedeNoHotel == "undefined" || 
				((hospedeNoHotel && listaHospede[i].dataSaida === null) || (!hospedeNoHotel && listaHospede[i].dataSaida !== null))) {		
			conteudoHtml += "<tr>";
			conteudoHtml += "<td>" + listaHospede[i].nome + "</td>";
			conteudoHtml += "<td>" + listaHospede[i].documento + "</td>";
			conteudoHtml += "<td>" + listaHospede[i].valor + "</td>";
			conteudoHtml += "</tr>";
		}

	}

	$('#lista-hospede').html(conteudoHtml);
}

function calculaValor() {

	var DIA_SEMANA = 120.00;
	var FINAL_SEMANA = 150.00;
	var VAGAGARAGEM_DIASEMANA = 15.00;
	var VAGAGARAGEM_FINALSEMANA = 20.00;


	var dataEntrada = ($("#dataentrada").val()).split("T")[0];
	var dataSaida = ($("#datasaida").val()).split("T")[0];
	var finalSemana = 0, diaSemana = 0;
	var valorTotal = 0;

	while (new Date(dataEntrada) < new Date(dataSaida)) {
		var dia = getDiaSemana(dataEntrada);
		if(dia == 1 || dia == 7){
			finalSemana ++;
		} else {
			diaSemana ++;
		}

		dataEntrada = getProximaData(dataEntrada, 1);
	}
	
	if(finalSemana > 0) {
		valorTotal += (finalSemana * FINAL_SEMANA);

		if($("#possuiveiculo").val() == 1)
			valorTotal += (finalSemana * VAGAGARAGEM_FINALSEMANA);
	}

	if(diaSemana > 0) {
		valorTotal += (diaSemana * DIA_SEMANA);

		if($("#possuiveiculo").val() == 1)
			valorTotal += (diaSemana * VAGAGARAGEM_DIASEMANA);
	}

	return valorTotal;

}

function getDiaSemana(data) {
	var arr = data.split("-");
	var teste = new Date(arr[0], arr[1] - 1, arr[2]);
	return teste.getDay();
}

function getProximaData(dataAtual, dias) {
	var dataAtual = new Date(dataAtual);            
	var previsao = new Date();

	previsao.setDate(dataAtual.getDate() + dias);  		
	return (previsao.getFullYear() + "-" + (previsao.getMonth() + 1) + "-" + previsao.getDate());
}
