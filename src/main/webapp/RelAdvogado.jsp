<!-- header -->
<%@ include file="./_header.jsp"%>
<!-- header -->

<%@page import="model.Advogado"%>
<%@page import="java.util.ArrayList"%>

<%
ArrayList<Advogado> lista = (ArrayList<Advogado>) request.getAttribute("advogados");
String success = (String) request.getAttribute("success");

String q = (String) request.getAttribute("q");
if (q == null)
	q = "";
%>





<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<a href="CadAdvogado.jsp"><button class="btn btn-success">Cadastrar
					Advogado</button></a>
		</div>
		<!-- col-md-12 -->
		<div class="container">
			<div class="col-md-12">
				&nbsp;

				<form name="buscaadvogado" action="pesquisaadvogado"
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
				<th scope="col">OAB</th>
				<th scope="col">Nome</th>
				<th scope="col">Telefone</th>
				<th scope="col">Data</th>
				<th scope="col">Op&ccedil;&otilde;es</th>
			</tr>
		</thead>
		<tbody>


			<%
			for (int i = 0; i < lista.size(); i++) {
			%>

			<tr>
				<td><%=lista.get(i).getOab()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getTelefone()%></td>
				<td><%=lista.get(i).getData()%></td>
				<td><a href="editaadvogado?id=<%=lista.get(i).getIdadv()%>"
					onclick="return confirm('Tem certeza que deseja editar?')">Editar</a>
					&nbsp;|&nbsp; <a
					href="apagaadvogado?id=<%=lista.get(i).getIdadv()%>"
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

