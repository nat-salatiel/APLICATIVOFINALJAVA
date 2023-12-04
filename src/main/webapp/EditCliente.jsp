<!-- header -->
<%@ include file="./_header.jsp"%>
<!-- header -->

<%@page import="model.Cliente"%>
<%@page import="java.util.List"%>
<%
List<Cliente> cliente = (List<Cliente>) request.getAttribute("cliente");
String success = (String) request.getAttribute("success");
%>


<p>
	<a href="buscacliente"><button class="btn btn-success">Relatório
			de Clientes</button></a>
</p>


<div class="text-center font-weight-bold">Editar dados do cliente
</div>

<div class="container">

	<form action="salvacliente">

		<input type="hidden" name="id"
			value="<%=cliente.get(0).getIdcliente()%>">

		<div class="form-group">
			<label>Cadastrado em: </label> <span><%=cliente.get(0).getData()%></span>
		</div>



		<div class="form-group">
			<label for="nome">Nome</label> <input type="text"
				class="form-control" id="nome" name="nome"
				value="<%=cliente.get(0).getNome()%>">
		</div>


		<div class="form-group">
			<label for="telefone">Telefone</label> <input type="text"
				class="form-control" id="" name="telefone"
				value="<%=cliente.get(0).getTelefone()%>">
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



