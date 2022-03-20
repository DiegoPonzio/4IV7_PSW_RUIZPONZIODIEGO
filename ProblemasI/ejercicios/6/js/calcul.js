function interes() {
    if (document.formulario.dia.value > 28 && document.formulario.mes.value == 2) {
        alert("EL mes de febrero no tiene mas de 28 dias")
        document.formulario.dia.value = "1";
        document.formulario.mes.value = "1";
        document.formulario.date.value = "1922";
        document.formulario.diaA.value = "1";
        document.formulario.mesA.value = "1";
        document.formulario.dateA.value = "1922";
        document.formulario.porH.value = "";
    } else {
        if (document.formulario.diaA.value > 28 && document.formulario.mesA.value == 2) {
            alert("EL mes de febrero no tiene mas de 28 dias")
            document.formulario.dia.value = "1";
            document.formulario.mes.value = "1";
            document.formulario.date.value = "1922";
            document.formulario.diaA.value = "1";
            document.formulario.mesA.value = "1";
            document.formulario.dateA.value = "1922";
            document.formulario.porH.value = "";
        } else {

            if (document.formulario.diaA.value >= document.formulario.dia.value && document.formulario.mesA.value >= document.formulario.mes.value) {
                var year = parseInt(document.formulario.date.value);
                var yearf = parseInt(document.formulario.dateA.value);
                var fecha = yearf - year;
                document.formulario.porH.value = fecha;

            } else {
                if (document.formulario.dia.value >= document.formulario.diaA.value && document.formulario.mesA.value > document.formulario.mes.value) {
                    var year = parseInt(document.formulario.date.value);
                    var yearf = parseInt(document.formulario.dateA.value);
                    var fecha = yearf - year;
                    document.formulario.porH.value = fecha + " años";
                } else {
                    if (document.formulario.diaA.value <= document.formulario.dia.value && document.formulario.mesA.value == document.formulario.mes.value) {
                        var year = parseInt(document.formulario.date.value);
                        var yearf = parseInt(document.formulario.dateA.value);
                        var fecha = (yearf - year) - 1;
                        document.formulario.porH.value = fecha + " años";
                    } else {
                        var year = parseInt(document.formulario.date.value);
                        var yearf = parseInt(document.formulario.dateA.value);
                        var fecha = (yearf - year) - 1;
                        document.formulario.porH.value = fecha + " años";
                    }
                }
            }
        }
    }
}

function borrard() {

    document.formulario.dia.value = "1";
    document.formulario.mes.value = "1";
    document.formulario.date.value = "1922";
    document.formulario.diaA.value = "1";
    document.formulario.mesA.value = "1";
    document.formulario.dateA.value = "1922";
    document.formulario.porH.value = "";
}