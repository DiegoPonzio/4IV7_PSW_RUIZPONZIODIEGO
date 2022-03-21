//problema 1
function validarn(e) {
    var teclado = (document.all) ? e.keyCode : e.which;
    if (teclado == 8 || teclado == 32) return true;
    var patron = /[q w e r t y u i o p a s d f g h j k l ñ z x c v b n m Q W E R T Y U I O P A S D F G H J K L Ñ Z X C V B N M]/;
    var codigo = String.fromCharCode(teclado);
    return patron.test(codigo);
}
function reverse(S){
    return S.split("").reverse().join("")
}
function problema1() {
    var frase = document.getElementById("p1-input").value;
    var palabras = frase.split(" ");
    var varfin = "";
    for(var i = 0; i < palabras.length; i++ ){
        var invertida = reverse(palabras[i]) 
        varfin += "La palabra " + palabras[i] + " de forma invertida es: " + invertida + "\n"
    }
    document.getElementById("p1-output").innerHTML = varfin;
}

//problema 2

function problema2() {
    if(document.getElementById("p2-x1").value < 0){
        document.getElementById("p2-x1").value = document.getElementById("p2-x1").value * -1
    }
    if(document.getElementById("p2-x2").value < 0){
        document.getElementById("p2-x2").value = document.getElementById("p2-x2").value * -1
    }
    if(document.getElementById("p2-x3").value < 0){
        document.getElementById("p2-x3").value = document.getElementById("p2-x3").value * -1
    }
    if(document.getElementById("p2-x4").value < 0){
        document.getElementById("p2-x4").value = document.getElementById("p2-x4").value * -1
    }
    if(document.getElementById("p2-x5").value < 0){
        document.getElementById("p2-x5").value = document.getElementById("p2-x5").value * -1
    }
    if(document.getElementById("p2-y1").value < 0){
        document.getElementById("p2-y1").value = document.getElementById("p2-y1").value * -1
    }
    if(document.getElementById("p2-y2").value < 0){
        document.getElementById("p2-y2").value = document.getElementById("p2-y2").value * -1
    }
    if(document.getElementById("p2-y3").value < 0){
        document.getElementById("p2-y3").value = document.getElementById("p2-y3").value * -1
    }
    if(document.getElementById("p2-y4").value < 0){
        document.getElementById("p2-y4").value = document.getElementById("p2-y4").value * -1
    }
    if(document.getElementById("p2-y5").value < 0){
        document.getElementById("p2-y5").value = document.getElementById("p2-y5").value * -1
    }
    if (document.getElementById("p2-x1").value == "") {
        document.getElementById("p2-x1").value = 0;
    }
    if (document.getElementById("p2-x2").value == "") {
        document.getElementById("p2-x2").value = 0;
    }
    if (document.getElementById("p2-x3").value == "") {
        document.getElementById("p2-x3").value = 0;
    }
    if (document.getElementById("p2-x4").value == "") {
        document.getElementById("p2-x4").value = 0;
    }
    if (document.getElementById("p2-x5").value == "") {
        document.getElementById("p2-x5").value = 0;
    }
    if (document.getElementById("p2-y1").value == "") {
        document.getElementById("p2-y1").value = 0;
    }
    if (document.getElementById("p2-y2").value == "") {
        document.getElementById("p2-y2").value = 0;
    }
    if (document.getElementById("p2-y3").value == "") {
        document.getElementById("p2-y3").value = 0;
    }
    if (document.getElementById("p2-y4").value == "") {
        document.getElementById("p2-y4").value = 0;
    }
    if (document.getElementById("p2-y5").value == "") {
        document.getElementById("p2-y5").value = 0;
    }
    var x1 = parseInt(document.getElementById("p2-x1").value);
    var x2 = parseInt(document.getElementById("p2-x2").value);
    var x3 = parseInt(document.getElementById("p2-x3").value);
    var x4 = parseInt(document.getElementById("p2-x4").value);
    var x5 = parseInt(document.getElementById("p2-x5").value);
    var y1 = parseInt(document.getElementById("p2-y1").value);
    var y2 = parseInt(document.getElementById("p2-y2").value);
    var y3 = parseInt(document.getElementById("p2-y3").value);
    var y4 = parseInt(document.getElementById("p2-y4").value);
    var y5 = parseInt(document.getElementById("p2-y5").value);
    var vector = x1 * y1 + x2 * y2 + x3 * y3 + x4 * y4 + x5 * y5;
    document.getElementById("p2-output").innerHTML = "EL valor del vector es: " + vector
}

//problema 3

function problema3() {

    var alfabeto = ['A', 'B', 'C', 'D', 'E', 'F',
        'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
        'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
        'V', 'W', 'X', 'Y', 'Z'];


    var p3_input = document.querySelector('#p3-input').value;

    var p3_palabras = p3_input.split(',');

    p3_palabras = p3_palabras.map(function (palabra) {
        return palabra.replace(/\s/g, '').toUpperCase();
    });

    var p3_res = '';

    p3_palabras.forEach(function (palabra, i) {
        var letras_unicas = [];
        var palabra_array = palabra.split('');
        alfabeto.forEach(function (letra, j) {
            palabra_array.forEach(function (letra_palabra, k) {
                if (letra_palabra == letra) {
                    if (letras_unicas.indexOf(letra) < 0) {
                        letras_unicas.push(letra);
                    }
                }
            });

        });
        p3_res += 'Palabra: ' + palabra + ' = ' + letras_unicas.length + '\n';
    });

    document.querySelector('#p3-output').textContent = p3_res;

}