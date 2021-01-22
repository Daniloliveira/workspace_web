var IDCom

var pConclusao;
var numOcorrencias;

function carregaInfo(){
    var userSTR = localStorage.getItem("userMod");
    if (!userSTR){
        window.location = "index.html";
        return;
    }

// Recuperar o ID da Comunidade que veio na URL

    var str = window.location.search;
    console.log(str);
    var idComunidade = str.substr(4);
    console.log("ID da Comunidade : " + idComunidade);

    IDCom =  parseInt(idComunidade);

    fetch("http://localhost:8088/comunidades/"+IDCom)
        .then(res => res.json())
        .then(comunidade => document.getElementById("nomeComunidade").innerHTML = comunidade.nome);

}

function cadastrar(){
    var txtData       = document.getElementById("txtData").value;
    var txtDescricao  = document.getElementById("txtDescricao").value;
    var txtPercentual = document.getElementById("txtPercentual").value;

    if (numOcorrencias > 0 || parseFloat(txtPercentual) + parseFloat(pConclusao) > 100){
        document.getElementById("msgStatus").innerHTML = "Já existem ocorrencias para o mês ou excede 100%";
        return;
    }

    var msgBody = {
        data : txtData ,
        descricao  : txtDescricao,
        percentual : parseFloat(txtPercentual),
        comunidade : {
            id : IDCom
        }
    };

    var cabecalho = {
        method : "POST",
        body   : JSON.stringify(msgBody),
        headers: {
            "content-type":"application/json"
        }
    }

    fetch("http://localhost:8088/Modernizacao/nova", cabecalho)
    .then(res => {
        if (res.status == 201){
            alert("Item de modernizacao cadastrado com sucesso!");
        }
        else{
            alert("Erro ao gravar item de modernizacao");
        }
    });
}

function pesquisar(){
    // idéia: buscar o id da comunidade + a data de cadastro e ir até o backend e buscar
    // as restricoes

    var txtData = document.getElementById("txtData").value;

    fetch("http://localhost:8088/modernizacao/"+IDCom+"/"+txtData)
        .then(res=> res.json())
        .then(objeto => {
            var txtRestricao = `${objeto.percentual}% concluido e ${objeto.quantidade} ocorrencias neste mes/ano`;
            document.getElementById("restricoes").innerHTML = txtRestricao;
            pConclusao = objeto.percentual;
            numOcorrencias = objeto.quantidade;
        });
}

function logout(){
    localStorage.removeItem("userMod");
    window.location = "index.html";
}

