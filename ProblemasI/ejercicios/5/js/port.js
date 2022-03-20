 var woman = 0;
 var men = 0;

function validarn(e) {
    var teclado = (document.all) ? e.keyCode : e.which;
    if (teclado == 8 || teclado == 32) return true;
    var patron = /[q w e r t y u i o p a s d f g h j k l ñ z x c v b n m Q W E R T Y U I O P A S D F G H J K L Ñ Z X C V B N M]/;
    var codigo = String.fromCharCode(teclado);
    return patron.test(codigo);
}

function interes() {

    if (document.formulario.sex.value == "H") {
        document.formulario.nom.value = "";
        document.formulario.sex.value = "H";
        men=men+1;
    } else {
        document.formulario.nom.value = "";
        document.formulario.sex.value = "H";
        woman=woman+1;
    }
}

function porce() {
    var total = woman + men ;
    var porth = (men*100)/total;
    var portm = (woman*100)/total;
    document.formulario.porH.value = porth + "%";
    document.formulario.porM.value = portm + "%";
    woman = 0;
    men = 0;
}

function borrard() {

    document.formulario.nom.value = "";
    document.formulario.sex.value = "H";
    document.formulario.porH.value = "";
    document.formulario.porM.value = "";
}