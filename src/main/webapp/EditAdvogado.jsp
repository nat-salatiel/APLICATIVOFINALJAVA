<!-- header -->
<%@ include file="./_header.jsp"%>
<!-- header -->

<%@page import="model.Advogado"%>
<%@page import="java.util.List"%>
<%
List<Advogado> advogado = (List<Advogado>) request.getAttribute("advogado");
String success = (String) request.getAttribute("success");
%>


<p>
	<a href="buscaadvogado"><button class="btn btn-success">Relatório
			de Advogados</button></a>
</p>

<div class="text-center font-weight-bold">Editar dados do advogado
</div>

<div class="container">


	<form action="salvaadvogado">

		<input type="hidden" name="id" value="<%=advogado.get(0).getIdadv()%>">


		<div class="form-group">
			<label>Cadastrado em: </label> <span><%=advogado.get(0).getData()%></span>
		</div>


		<div class="form-group">
			<label for="oab">OAB</label> <input type="text" class="form-control"
				id="" name="oab" value="<%=advogado.get(0).getOab()%>">
		</div>

		<div class="form-group">
			<label for="nome">Nome</label> <input type="text"
				class="form-control" id="" name="nome"
				value="<%=advogado.get(0).getNome()%>">
		</div>


		<div class="form-group">
			<label for="telefone">Telefone</label> <input type="text"
				class="form-control" id="" name="telefone"
				value="<%=advogado.get(0).getTelefone()%>">
		</div>

		<!--  
			   <div class="form-group">
			    <label for="tipocausas">Tipo Causas</label>
			    <input type="text" class="form-control" id="" name="tipocausas">
			  </div>
			  -->

		<div class="form-group">
			<input type="submit" class="btn btn-primary" value="Enviar">
		</div>
	</form>

</div>




&nbsp;

<!-- footer -->
<%@ include file="./_footer.jsp"%>
<!-- footer -->


