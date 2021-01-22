function carregaExtrato(){
    // Fazer a verificação se o User existe mesmo 
    var userSTR = localStorage.getItem("userMod");
    if (!userSTR){
        window.location = "index.html";
        return;
    }
    // Capturar o ID da URL

    var param = window.location.search;
    var idcomunidade = param.substr(4);

    fetch("http://localhost:8088/modernizacao/comunidade/"+idcomunidade)
        .then(res => res.json())
        .then(lista => preencheExtrato(lista));
}

function preencheExtrato(lista){
    var total=0;
    var nomeComunidade;
    var nomeTeamLeader;

    var extratoSTR = `<table class="table table-hover table-striped">
    <thead>
      <tr>
      </tr>
    </thead>
    <tbody>`;

    for (i=0 ; i<lista.length ; i++ ){
        var mod = lista[i];
/*
        extratoSTR = extratoSTR + `<div class="row" >
                                    <div class="col-2">${mod.data}</div>
                                    <div class="col-9">${mod.descricao}</div>
                                    <div class="col-1">${mod.percentual}</div>
                                   </div>`;
                                   */  
                                   
        extratoSTR = extratoSTR + `<tr>
                                   <th scope="col" width="20%">${mod.data}</th>
                                   <th scope="col" width="60%">${mod.descricao}</th>
                                   <th scope="col" width="10%">${mod.percentual}%</th>
                                    </tr>`;
    

        total = total + mod.percentual;
    }
    extratoSTR = extratoSTR + `</tbody></table>`

    document.getElementById("extrato").innerHTML = extratoSTR;
    //document.getElementById("progresso").innerHTML = `<h4>Progresso Total: ${total}%</h4> `;
    
    document.getElementById("progresso").innerHTML = `<h4>Progresso Total:</h4>
                                                        <div class="progress">
                                                        <div class="progress-bar" role="progressbar" 
                                                        style="width: ${total}%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">${total}%</div>
                                                        </div> `;
    
    if (lista.length > 0){
        document.getElementById("comunidade").innerHTML = `<h4>${lista[0].comunidade.nome}
                                                            (${lista[0].comunidade.teamLeader.nome})</h4>`;
    }
    else{
        document.getElementById("comunidade").innerHTML = "Comunidade sem ações";
    }
}

function logout(){
    localStorage.removeItem("userMod");
    window.location = "index.html";
}
