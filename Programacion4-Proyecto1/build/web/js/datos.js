function init() {
    setTimeout(actualizar, 1000);
}

function actualizar() {
    requestJSON(actualizarInfo, "ServicioActualizacion");
    setTimeout(actualizar, 1000);
}

function actualizarInfo(datos) {
    var refListaAccesos = document.getElementById("listaAccesos");
    if (refListaAccesos) {
        refListaAccesos.innerHTML = datos.listaAccesos;
    }
}

function showPassword() {
    var x = document.getElementById("myPassword");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}

function ordenarTabla(n,tableName) {
    var table, rows, cambiando, i, x, y, cambia, dir, contador = 0;
    table = document.getElementById(tableName);
    cambiando = true;
    //Set the sorting direction to ascending:
    dir = "asc";
    /*Make a loop that will continue until
     no cambiando has been done:*/
    while (cambiando) {
        //start by saying: no cambiando is done:
        cambiando = false;
        rows = table.rows;
        /*Loop through all table rows (except the
         first, which contains table headers):*/
        for (i = 1; i < (rows.length - 1); i++) {
            //start by saying there should be no cambiando:
            cambia = false;
            /*Get the two elements you want to compare,
             one from current row and one from the next:*/
            x = rows[i].getElementsByTagName("TD")[n];
            y = rows[i + 1].getElementsByTagName("TD")[n];
            /*check if the two rows should switch place,
             based on the direction, asc or desc:*/
            if (dir === "asc") {
                if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                    //if so, mark as a switch and break the loop:
                    cambia = true;
                    break;
                }
            } else if (dir === "desc") {
                if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                    //if so, mark as a switch and break the loop:
                    cambia = true;
                    break;
                }
            }
        }
        if (cambia) {
            /*If a switch has been marked, make the switch
             and mark that a switch has been done:*/
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            cambiando = true;
            //Each time a switch is done, increase this count by 1:
            contador++;
        } else {
            /*If no cambiando has been done AND the direction is "asc",
             set the direction to "desc" and run the while loop again.*/
            if (contador === 0 && dir === "asc") {
                dir = "desc";
                cambiando = true;
            }
        }
    }
}