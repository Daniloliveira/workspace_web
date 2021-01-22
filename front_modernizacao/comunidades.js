function carregaInfo() {
    var userSTR = localStorage.getItem("userMod");
    if (!userSTR) {
        window.location = "index.html";
        return;
    }

    var user = JSON.parse(userSTR); //Reconverte para trabalhar como um Objeto.

    var strFoto = `<img src="${user.linkfoto}" width="50%">`;
    var strBio = `<h4>${user.nome}</h4>
                  <p><strong>RACF: </strong> ${user.racf}</p>
                  <p><strong>EMAIL: </strong> ${user.email}</p>
                  `;
                  // <button type="button" class="btn btn-primary" onclick="logout()">Logout</button>
    

    document.getElementById("fotoUser").innerHTML = strFoto;
    document.getElementById("bioUser").innerHTML = strBio;


       // aqui começo a preencher a lista de comunidades
       var strLista = `<table class="table table-hover table-striped">
       <thead>
         <tr>
         </tr>
       </thead>
       <tbody>`;
       for (i=0; i<user.comunidades.length; i++){
           var comunidade = user.comunidades[i];
   
   /*
           strLista = strLista + `<div class="row estilocomunidade">
                                     <div class="col-1"></div>
                                     <div class="col-7" font-color=>${comunidade.nome}</div>
                                     <div class="col-2"><a href="novamodernizacao.html?id=${comunidade.id}" class="btn btn-success">Novo</a></div>
                                     <div class="col-2"><a href="extrato.html?id=${comunidade.id}" class="btn btn-warning">Extrato</a></div>
                                  </div><br>`;
*/
          strLista = strLista + ` <tr>
                                  <th scope="col" width="60%">${comunidade.nome}</th>
                                  <th scope="col" width="20%"><a href="novamodernizacao.html?id=${comunidade.id}" class="btn btn-success">Novo</a></th>
                                  <th scope="col" width="20%"><a href="extrato.html?id=${comunidade.id}" class="btn btn-warning">Extrato</a></th>
                                  </tr>`;
       }
       strLista = strLista + `</tbody></table>`
       document.getElementById("listaComunidades").innerHTML = strLista;
   


}

function logout(){
    localStorage.removeItem("userMod");
    window.location = "index.html";
}


