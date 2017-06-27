<%-- 
    Document   : header
    Created on : 14/06/2017, 10:57:35
    Author     : igor
--%>

    <header>
        <nav id="navbar" class="navbar navbar-toggleable-md navbar-inverse bg-inverse">
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbars" aria-controls="navbars"
                aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
            <a class="navbar-brand" href="#">Lujinha</a>
            <div class="collapse navbar-collapse" id="navbars">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active-result">
                        <a class="nav-link d-inline-flex" href="${linkTo[CidadeController].list}">Cidades</a>
                        <a class="nav-link d-inline-flex" href="${linkTo[EstadoController].list}">Estados</a>
                        <a class="nav-link d-inline-flex" href="${linkTo[ProdutoController].list}">Produtos</a>
                        <a class="nav-link d-inline-flex" href="${linkTo[EstoqueController].list}">Estoque</a>
                        <a class="nav-link d-inline-flex" href="${linkTo[CategoriaController].list}">Categoria</a>
                        <a class="nav-link d-inline-flex" href="${linkTo[EntregaController].lista}">Vendas</a>
                        <a class="nav-link d-inline-flex" href="${linkTo[TransportadoraController].list}">Transportadoras</a>
                        <a class="nav-link d-inline-flex" href="${linkTo[PagamentoController].list}">Formas</a>
                    </li>
                </ul>
                    
            </div>
        </nav>
    </header>
