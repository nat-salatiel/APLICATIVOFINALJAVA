<!-- header -->
<%@ include file="./_header.jsp"%>
<!-- header -->



<div class="container-fluid">
	<div class="row">
		<div class="col-md-12>">
			<a href="buscacliente"><button class="btn btn-success">Relatório
					de Clientes</button></a>
		</div>
		<!-- col-md-12 -->
	</div>
	<!-- row -->
</div>
<!-- container-fluid -->

<div class="container">

	<form action="novocliente">


		<div class="form-group">
			<label for="nome">Nome</label> <input type="text"
				class="form-control" id="" name="nome">
		</div>


		<div class="form-group">
			<label for="telefone">Telefone</label> <input type="text"
				class="form-control" id="" name="telefone">
		</div>

		<div class="form-group">
			<input type="submit" class="btn btn-primary" value="Enviar">
		</div>
	</form>

</div>



&nbsp;

<!-- footer -->
<%@ include file="./_footer.jsp"%>
<!-- footer -->


