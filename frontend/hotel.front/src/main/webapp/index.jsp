<html>
<head>
<link rel="StyleSheet" type="text/css" href="css/estilos.css"
	media="screen">
<link rel="StyleSheet" type="text/css" href="css/bootstrap.min.css"
	media="screen">
<link type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" rel="stylesheet">
</head>

<body>
	<div class="header">
		<div class="page-cabecalho">
			<h3>Senior</h3>
		</div>
	</div>

	<form id="hospedeForm">
		<div class="page-corpo">
			<input type="button" class="btn" value="Incluir pessoa" id="bnt-incluir">

			<div class="cabecalho">
				<div class="cabecalho-card">
					<h3>Novo Checkin</h3>
				</div>
			</div>

			<div class="card">

				<div class="form-group col-sm-6 col-lg-6 group">
					<label>Data/hora de entrada</label> <input type="data" id="dataentrada" name="data-entrada"
						class="form-control">
				</div>

				<div class="form-group col-sm-6 col-lg-6 group">
					<label>Data/hora de saída</label> <input type="data" id="datasaida" name="data-saida"
						class="form-control">
				</div>

				<div class="form-group col-sm-6 col-lg-6 group">
					<label>Pessoa</label> <input type="text" class="form-control" id="nome" name="nome-pessoa">
				</div>
				
				<div class="form-group col-sm-6 col-lg-6 group">
					<label>Documento</label> <input type="text" class="form-control" id="documento" name="documento-pessoa">
				</div>

				<div class="form-group col-sm-12 col-lg-12 group">
					<label> <input type="checkbox" id="possuiveiculo" name="possui-veiculo"> <span>Possui
							veículo</span>
					</label>
				</div>

				<div class="btn-grupo">
					<input type="button" class="btn" value="Salvar" id="btn-salvar">
				</div>

			</div>

			<div class="cabecalho">
				<div class="cabecalho-card">
					<h3>Consultas</h3>
				</div>
			</div>

			<div class="card">
				<div class="col-sm-12 col-lg-12 filtro">
					<div class="col-sm-6 col-lg-6">
						<div class="form-group col-sm-12 col-lg-12">
							<label>Filtar por:</label>
						</div>
						<div class="form-group col-sm-12 col-lg-6">
							<input type="radio" name="filtro" value="rb-presente"> Pessoas
							ainda presentes
						</div>

						<div class="form-group col-sm-12 col-lg-6">
							<input type="radio" name="filtro" value="rb-deixaram"> Pessoas
							que ja deixaram o hotel
						</div>
					</div>
				</div>

				<div class="col-sm-12 col-lg-12">
					<div class="table-responsive">
						<table class="tabela table-hover display" id="grd-hospede">
							<thead>
								<tr>
									<th>Nome</th>
									<th data-breakpoints="sm xs">Documento</th>
									<th data-breakpoints="sm xs">Valor</th>
								</tr>
							</thead>
							
							<tbody id="lista-hospede"></tbody>
						
						</table>
					</div>
				</div>

				<div class="btn-grupo">
					<input type="button" class="btn-consulta" value="Previous &larr;">
					<input type="button" class="btn-consulta" value="Next &rarr;">
				</div>
			</div>

		</div>

	</form>
	
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js" type="text/javascript"></script>
    <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js" type="text/javascript"></script>
	<script src="scripts/FileSaver.min.js"></script>
	<script src="scripts/acao.js"></script>
</body>
</html>
