function validarn(e){
    var teclado = (document.all)? e.keyCode : e.which;
    if(teclado == 8) return true;
    var patron = /[0-9\d .]/;
    var codigo = String.fromCharCode(teclado);
    return patron.test(codigo);
}

function interes(){

    var mes = parseInt(document.formulario.mes.value);
    var valor = document.formulario.cantidad.value;
    var resul = parseInt(valor);
    var interes = resul*0.02*mes;
    var total = interes + resul;

    document.formulario.sueldoI.value= "$"+ total;
}

function borrard(){

    document.getElementById("cantidad").value ="";
    document.getElementById("sueldoI").value = "";
    document.formulario.mes.value="1";
}