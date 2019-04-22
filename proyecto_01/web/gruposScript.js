/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function init(){
    
    
}
function crearGrupo(id){

    var url = "ServicioCreaGrupo?" +
            "id={0}&Accion={1}";
    url = url.format(id,"asd");
    fetch(url).then(r => {
        return r.json();
    }).then(d => {
        Actualizar(d,id);
    });
}
function Actualizar(json,idTablaClickeada){
    console.log("json: ",json);
    console.log("idTablaClickeada: ",idTablaClickeada);
    var obj = JSON.parse(JSON.stringify(json));
//    console.log("nombre: ",obj.nombre);
//    console.log("apellidos: ",obj.apellidos);
//    console.log("grupo_id_antiguo: ",obj.grupo_id_antiguo);
    
    
   
//    var tablaAntigua=document.getElementById("Grupo"+obj.grupo_id_antiguo);
    var filaAntigua= document.getElementById(obj.idUsuario);
    console.log("tablaAntigua: ","Grupo"+obj.grupo_id_antiguo);
    console.log("filaAntigua: ","tr"+obj.idUsuario);
    var tbody = document.getElementById("tbodyGrupo"+obj.grupo_id_antiguo);
    tbody.removeChild(filaAntigua);
//    tablaAntigua.removeChild(filaAntigua);
    
//    var tablaNueva = document.getElementById("Grupo"+idTablaClickeada);
    var tbodyNuevo = document.getElementById("tbodyGrupo"+idTablaClickeada);
    var filaNueva = document.createElement("tr");
    var nombre= document.createElement("td");
    var apellidos= document.createElement("td");
    
     
    filaNueva.setAttribute("id",obj.idUsuario);
    nombre.innerHTML=obj.nombre;
    apellidos.innerHTML=obj.apellidos;
    filaNueva.appendChild(apellidos);
    filaNueva.appendChild(nombre);
    tbodyNuevo.appendChild(filaNueva);
    

}


String.prototype.format = function () {
    var a = this;
    for (var k in arguments) {
        a = a.replace("{" + k + "}", arguments[k]);
    }
    return a;
};

