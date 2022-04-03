//problema 1
function validarn(e) {
    var teclado = (document.all) ? e.keyCode : e.which;
    if (teclado === 8 || teclado === 32) return true;
    var patron = /[1 2 3 4 5 6 7 8 9 0 q w e r t y u i o p a s d f g h j k l ñ z x c v b n m Q W E R T Y U I O P A S D F G H J K L Ñ Z X C V B N M]/;
    var codigo = String.fromCharCode(teclado);
    return patron.test(codigo);
}


