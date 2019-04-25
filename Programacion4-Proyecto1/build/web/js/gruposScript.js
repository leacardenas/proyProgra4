/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var cant_grupos=0;
function init(){
    var x = JSON.parse(localStorage.getItem("trID"));
   localStorage.setItem("trID",JSON.stringify(trID));
    
}
function procesoCrearGrupo(){
    var nombreGrupo= document.getElementById("nombreGrupo").value;
    var url = "servicioProcesoCrearGrupo?" +
        "nombreGrupo={0}";
    url = url.format(nombreGrupo);
    fetch(url).then(r => {
        return r.json();
    }).then(d => {
        ActualizarGrupos(d);
    });
    
}
function ActualizarGrupos(json){

    var obj = JSON.parse(JSON.stringify(json));
    console.log(obj.grupoNombre);
    console.log(obj.grupoID);
//   CantidadGrupos();
   console.log("cantidad de grupos: ",obj.grupoID);
   cantidad_de_grupos=parseInt(obj.grupoID);
   var tipo=(cantidad_de_grupos%2)?"Impar":"Par";
   
    // <editor-fold defaultstate="collapsed" desc="creacion de tablas. Click on the + sign on the left to edit the code.">
   if(tipo==="Impar"){
       var tbodytablaGrupos= document.getElementById("tbodytablaGrupos");
      
       var trNuevo = document.createElement("tr");
       trNuevo.setAttribute("id","tr"+obj.grupoID);
       tbodytablaGrupos.appendChild(trNuevo);
       
       var tdNuevo = document.createElement("td");
       trNuevo.appendChild(tdNuevo);
       
       var newTable = document.createElement("table");
       newTable.setAttribute("class","tablaInfoGrupo");
       newTable.setAttribute("id","Grupo"+obj.grupoID);
       newTable.setAttribute("onclick","crearGrupo("+obj.grupoID+")");
//       newTable.onclick="crearGrupo("+obj.grupoID+")";
       tdNuevo.appendChild(newTable);
       
       
       var newTbody= document.createElement("tbody");
       newTbody.setAttribute("id","tbodyGrupo"+obj.grupoID);
       newTable.appendChild(newTbody);
       
       var trNumeroGrupo = document.createElement("tr");
       trNumeroGrupo.setAttribute("class","numeroGrupo")
       var tdNumeroGrupo = document.createElement("td");
       tdNumeroGrupo.setAttribute("colspan","2");
       tdNumeroGrupo.innerHTML= "Grupo "+obj.grupoID;
       trNumeroGrupo.appendChild(tdNumeroGrupo);
       newTbody.appendChild(trNumeroGrupo);
       
       var trNombreGrupo= document.createElement("tr");
       trNombreGrupo.setAttribute("class","integrantes")
       var tdNombreGrupo = document.createElement("td");
       tdNombreGrupo.setAttribute("colspan","2");
       tdNombreGrupo.innerHTML= obj.grupoNombre;
       trNombreGrupo.appendChild(tdNombreGrupo);
       newTbody.appendChild(trNombreGrupo);
       
       var trDatosEst= document.createElement("tr");
       trDatosEst.setAttribute("class","numeroGrupo");
       trDatosEst.setAttribute("id",obj.idUsuario);
       var tdApell= document.createElement("td");
       tdApell.innerHTML= obj.estApellidos;
       var tdNom= document.createElement("td");
       tdNom.innerHTML= obj.estNombre;
       trDatosEst.appendChild(tdApell);
       trDatosEst.appendChild(tdNom);
       newTbody.appendChild(trDatosEst);
   }
   else{
       var num= parseInt(obj.grupoID);
       num= num -1;
       var trNuevo= document.getElementById("tr"+num);
        var tdNuevo = document.createElement("td");
        trNuevo.appendChild(tdNuevo);
       
       var newTable = document.createElement("table");
       newTable.setAttribute("class","tablaInfoGrupo");
       newTable.setAttribute("id","Grupo"+obj.grupoID);
       newTable.setAttribute("onclick","crearGrupo("+obj.grupoID+")");
//       newTable.onclick="crearGrupo("+obj.grupoID+")";
       tdNuevo.appendChild(newTable);
       
       
       var newTbody= document.createElement("tbody");
       newTbody.setAttribute("id","tbodyGrupo"+obj.grupoID);
       newTable.appendChild(newTbody);
       
       var trNumeroGrupo = document.createElement("tr");
       trNumeroGrupo.setAttribute("class","numeroGrupo")
       var tdNumeroGrupo = document.createElement("td");
       tdNumeroGrupo.setAttribute("colspan","2");
       tdNumeroGrupo.innerHTML= "Grupo "+obj.grupoID;
       trNumeroGrupo.appendChild(tdNumeroGrupo);
       newTbody.appendChild(trNumeroGrupo);
       
       var trNombreGrupo= document.createElement("tr");
       trNombreGrupo.setAttribute("class","integrantes")
       var tdNombreGrupo = document.createElement("td");
       tdNombreGrupo.setAttribute("colspan","2");
       tdNombreGrupo.innerHTML= obj.grupoNombre;
       trNombreGrupo.appendChild(tdNombreGrupo);
       newTbody.appendChild(trNombreGrupo);
       
       var trDatosEst= document.createElement("tr");
       trDatosEst.setAttribute("class","numeroGrupo");
       trDatosEst.setAttribute("id",obj.idUsuario);
       var tdApell= document.createElement("td");
       tdApell.innerHTML= obj.estApellidos;
       var tdNom= document.createElement("td");
       tdNom.innerHTML= obj.estNombre;
       trDatosEst.appendChild(tdApell);
       trDatosEst.appendChild(tdNom);
       newTbody.appendChild(trDatosEst);
       
   }
   // </editor-fold>
//   Actualizar(json,obj.grupoID);
    var filaAntigua= document.getElementById(obj.idUsuario);
    var tbody = document.getElementById("tbodyGrupo"+obj.grupo_id_antiguo);
    tbody.removeChild(filaAntigua);
//    si el obj.grupoID es impar se crea un tr nuevo
//si es par solo se inserta en el ultimo
    
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
    var obj = JSON.parse(JSON.stringify(json));

    var filaAntigua= document.getElementById(obj.idUsuario);
    var tbody = document.getElementById("tbodyGrupo"+obj.grupo_id_antiguo);
    tbody.removeChild(filaAntigua);
    
    
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
function removeFromOrigin(){
    
    
    
}
String.prototype.format = function () {
    var a = this;
    for (var k in arguments) {
        a = a.replace("{" + k + "}", arguments[k]);
    }
    return a;
};

