var listaHospede = [];

$(document).ready(function(){

	$("#btn-salvar").click(function() {
		salvarPessoa();
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
			valor: calculaValor()	
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

}