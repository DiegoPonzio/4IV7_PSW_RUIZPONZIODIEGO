//problema 3

function problema3(){
    
    var alfabeto = ['A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z'];

    
    var p3_input = document.querySelector('#p3-input').value;

    var p3_palabras = p3_input.split(',');

    p3_palabras = p3_palabras.map(function (palabra){
        return palabra.replace(/\s/g, '').toUpperCase();
    });

    var p3_res = '';

    p3_palabras.forEach(function (palabra, i){
        var letras_unicas = [];
        var palabra_array = palabra.split('');
        alfabeto.forEach(function (letra, j){
            palabra_array.forEach(function (letra_palabra, k){
                if(letra_palabra == letra){
                    if(letras_unicas.indexOf(letra) < 0){
                        letras_unicas.push(letra);
                    }
                }
            });

        });
        p3_res += 'Palabra: ' + palabra + ' = ' + letras_unicas.length + '\n';
    });

    document.querySelector('#p3-output').textContent = p3_res;

}