<!-- header -->
<%@ include file="./_header.jsp"%>
<!-- header -->

<%@page import="model.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%
ArrayList<Cliente> lista = (ArrayList<Cliente>) request.getAttribute("clientes");
String success = (String) request.getAttribute("success");
//Pesquisa na tabela de clientes pelo nome e/ou telefone.
String q = (String) request.getAttribute("q");
if (q == null)
	q = "";
%>




<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<a href="CadCliente.jsp"><button class="btn btn-success">Cadastrar
					Cliente</button></a>
		</div>
		<!-- col-md-12 -->

		<div class="container">
			<div class="col-md-12">
				&nbsp;

				<form name="buscacliente" action="pesquisacliente"
					class="input-group mb-3">
					<input type="search" name="q" value="<%=q%>" class="form-control">
					<div class="input-group-append">
						<button type="submit" class="btn btn-outline-secondary">Buscar</button>
					</div>
				</form>
			</div>
			<!-- col-md-12 -->
		</div>
	</div>
	<!-- row -->
</div>
<!-- container-fluid -->

<div class="container">
	<%
	if (success != null) {
	%>
	<script> alert("<%=success%>
		")
	</script>
	<%
	}
	%>
	<table class="table table-dark">
		<thead>
			<tr>
				<th scope="col">C&oacute;digo</th>
				<th scope="col">Data</th>
				<th scope="col">Cliente</th>
				<th scope="col">Telefone</th>
				<th scope="col">Op&ccedil;&otilde;es</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>

			<tr>
				<td><%=lista.get(i).getIdcliente()%></td>
				<td><%=lista.get(i).getData()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getTelefone()%></td>
				<td><a href="editacliente?id=<%=lista.get(i).getIdcliente()%>"
					onclick="return confirm('Tem certeza que deseja editar?')">Editar</a>
					&nbsp;|&nbsp; <a
					href="apagacliente?id=<%=lista.get(i).getIdcliente()%>"
					onclick="return confirm('Tem certeza que deseja apagar?')">Apagar</a>
				</td>
			</tr>

			<%
			}
			%>

		</tbody>
	</table>

</div>


&nbsp;

<!-- footer -->
<%@ include file="./_footer.jsp"%>
<!-- footer -->

