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
                    <a class="nav-link d-inline-flex" href="${linkTo[ProdutosController].lista}">Home</a>
                    <a class="nav-link d-inline-flex" href="${linkTo[ClienteController].login}">Login</a>
                    <a class="nav-link d-inline-flex" href="${linkTo[VendaController].finaliza}">Finalizar Venda</a>
                    <a class="nav-link d-inline-flex text-right " href="${linkTo[ProdutoController].list}">Acesso Restrito</a>
                </li>
            </ul>
        </div>
    </nav>
</header>