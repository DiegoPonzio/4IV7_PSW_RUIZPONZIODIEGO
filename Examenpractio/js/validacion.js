function validar(formulario) {
    if(formulario.auto.value < 100000 || formulario.auto.value > 1000000){
        alert("El valor del auto tiene que estar en el rango de: 100000 y 1000000")
    }
    if(formulario.cuota.value > formulario.auto.value*0.1){
        alert("La cuota inicial tiene que ser menor al 10% del valor total del auto")
    }
    /*if(formulario.mes.value == "meses"){
        alert("NO se a alegiodo el periodo de tiempo")
    }*/
    var checkOK = "0123456789";

    var checkStr = formulario.auto.value;

    var todoesvalido = true;

    for (var i = 0; i < checkStr.length; i++) {
        var ch = checkStr.charAt(i);
        for (var j = 0; j < checkOK.length; j++) {
            if (ch == checkOK.charAt(j)) {
                break;
            }

        }
        if (j == checkOK.length) {
            todoesvalido = false;
            break;
        }
    }

    if (!todoesvalido) {
        alert("Escriba unicamente numeros en el campo Valor del Auto");
        formulario.auto.focus();
        return false;
    }

    var checkOK = "0123456789";

    var checkStr = formulario.cuota.value;

    var todoesvalido = true;

    for (var i = 0; i < checkStr.length; i++) {
        var ch = checkStr.charAt(i);
        for (var j = 0; j < checkOK.length; j++) {
            if (ch == checkOK.charAt(j)) {
                break;
            }

        }
        if (j == checkOK.length) {
            todoesvalido = false;
            break;
        }
    }

    if (!todoesvalido) {
        alert("Escriba unicamente numeros en el campo Cuota inicial");
        formulario.cuota.focus();
        return false;
    }
    
    

}