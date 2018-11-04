<html>
<head>
<link rel="StyleSheet" type="text/css" href="css/estilos.css"
	media="screen">
<link rel="StyleSheet" type="text/css" href="css/bootstrap.min.css"
	media="screen">
</head>

<body>
	<div class="header">
		<div class="page-cabecalho">
			<h3>Senior</h3>
		</div>
	</div>

	<form>
		<div class="page-corpo">
			<input type="button" class="btn" value="Incluir pessoa">

			<div class="cabecalho">
				<div class="cabecalho-card">
					<h3>Novo Checkin</h3>
				</div>
			</div>

			<div class="card">

				<div class="form-group col-sm-6 col-lg-6">
					<label>Data/hora de entrada</label> <input type="text"
						class="form-control">
				</div>

				<div class="form-group col-sm-6 col-lg-6">
					<label>Data/hora de saída</label> <input type="text"
						class="form-control">
				</div>

				<div class="form-group col-sm-6 col-lg-6">
					<label>Pessoa</label> <input type="text" class="form-control">
				</div>

				<div class="form-group col-sm-6 col-lg-6">
					<label> <input type="checkbox"> <span>Possui
							veículo</span>
					</label>
				</div>

				<div class="form-group btn-grupo">
					<input type="button" class="btn" value="Salvar">
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
							<input type="radio" name="gender" value="male"> Pessoas
							ainda presentes
						</div>

						<div class="form-group col-sm-12 col-lg-6">
							<input type="radio" name="gender" value="female"> Pessoas
							que ja deixaram o hotel
						</div>
					</div>
				</div>

				<div class="col-sm-12 col-lg-12">
					<div class="table-responsive">
						<table class="tabela table-hover">
							<thead>
								<tr>
									<th>Nome</th>
									<th data-breakpoints="sm xs">Documento</th>
									<th data-breakpoints="sm xs">Valor gasto R$</th>
								</tr>
							</thead>
							<tbody id="product-list">
								<tr>
									<td>Everton da Silva</td>
									<td>99098887</td>
									<td>1550</td>
								</tr>
								<tr>
									<td>Guilherme</td>
									<td>99098887</td>
									<td>150</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>

				<div class="btn-grupo">
					<input type="button" class="btn-consulta" value="Previous">
					<input type="button" class="btn-consulta" value="Next">
				</div>
			</div>

		</div>

	</form>
</body>
</html>
