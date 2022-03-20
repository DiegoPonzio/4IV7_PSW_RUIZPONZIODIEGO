function validarn(e) {
    var teclado = (document.all) ? e.keyCode : e.which;
    if (teclado == 8) return true;
    var patron = /[0-9\d .]/;
    var codigo = String.fromCharCode(teclado);
    return patron.test(codigo);
}

function interes() {

    if (document.formulario.cantidad1.value > 10 || document.formulario.cantidad2.value > 10 || document.formulario.cantidad3.value > 10 || document.formulario.examen.value > 10 || document.formulario.trabajo.value > 10) {
        alert("Las calificaciones deben ser ente 1 y 10")
        document.formulario.cantidad1.value = "";
        document.formulario.cantidad2.value = "";
        document.formulario.cantidad3.value = "";
        document.formulario.examen.value = "";
        document.formulario.trabajo.value = "";
    } else {
        var valor1 = parseFloat(document.formulario.cantidad1.value);
        var valor2 = parseFloat(document.formulario.cantidad2.value);
        var valor3 = parseFloat(document.formulario.cantidad3.value);
        var promedio = valor1 + valor2 + valor3;
        var pro = promedio/3
        var exa = parseFloat(document.formulario.examen.value);
        var trab = parseFloat(document.formulario.trabajo.value)
        var cal1 = pro * 0.55;
        var cal2 = exa * 0.3;
        var cal3 = trab * 0.15;
        var total = cal1 + cal2 + cal3;

        document.formulario.sueldoF.value = total;
    }
}

function borrard() {

    document.formulario.cantidad1.value = "";
    document.formulario.cantidad2.value = "";
    document.formulario.cantidad3.value = "";
    document.formulario.examen.value = "";
    document.formulario.trabajo.value = "";
    document.formulario.sueldoF.value = "";
}