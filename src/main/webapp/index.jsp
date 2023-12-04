<!-- header -->
<%@ include file="./_header.jsp"%>
<!-- header -->

<div class="container text-center">
	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item">
				<img class="d-block w-100" src="./imagens/slide1.jpg"
					alt="Primeiro Slide">
			</div>
			<div class="carousel-item active">

				<img class="d-block w-100" src="./imagens/slide2.jpg"
					alt="Segundo Slide">
			</div>

			<div class="carousel-item">
				<img class="d-block w-100" src="./imagens/slide3.JPEG"
					alt="Terceiro Slide">
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Anterior</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Próximo</span>
		</a>
	</div>


	&nbsp;

	<div class="row">
		<div class="col-sm">
			<div class="card">
				<img class="card-img-top" src="./imagens/slide1.jpg"
					alt="Imagem de capa do card">
				<div class="card-body">
					<p class="card-text">Contrate nossos serviços!</p>
				</div>
			</div>
		</div>

		<div class="col-sm">
			<div class="card">
				<img class="card-img-top" src="./imagens/slide2.jpg"
					alt="Imagem de capa do card">
				<div class="card-body">
					<p class="card-text">Atuamos em todos os tipos de causas.</p>
				</div>
			</div>
		</div>

		<div class="col-sm">
			<div class="card">
				<img class="card-img-top" src="./imagens/slide3.JPEG"
					alt="Imagem de capa do card">
				<div class="card-body">
					<p class="card-text">Orçamento online e gratuito.</p>
				</div>
			</div>
		</div>
	</div>
	<!-- row -->

</div>
<!-- container -->
&nbsp;

<!-- footer -->
<%@ include file="./_footer.jsp"%>
<!-- footer -->

