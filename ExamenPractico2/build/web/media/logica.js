function validarbol(e) {
    var teclado = (document.all) ? e.keyCode : e.which;
    if (teclado === 8) return true;
    var patron = /[1234567890]/;
    var codigo = String.fromCharCode(teclado);
    return patron.test(codigo);
}

function validardata(e) {
    var teclado = (document.all) ? e.keyCode : e.which;
    if (teclado === 8 || teclado === 32) return true;
    var patron = /[q w e r t y u i o p a s d f g h j k l ñ z x c v b n m Q W E R T Y U I O P A S D F G H J K L Ñ Z X C V B N M]/;
    var codigo = String.fromCharCode(teclado);
    return patron.test(codigo);
}

function validarmac(e) {
    var teclado = (document.all) ? e.keyCode : e.which;
    if (teclado === 8) return true;
    var patron = /[1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM-]/;
    var codigo = String.fromCharCode(teclado);
    return patron.test(codigo);
}

