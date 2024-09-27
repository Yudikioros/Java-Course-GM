function validarForma(forma){
    var usuario= forma.usuario;
    if(usuario.value == "" || usuario.value == "Escribir usuario"){
        alert("Debe proporcionar un nombre de usuario");
        usuario.focus();
        usuario.select();
        return false;
    }

    var password = forma.password;
    if(password.value == "" || password.value.length < 3){
        alert("Debe proporcionar una contraseña de al menos 3 caracteres");
        usuario.focus();
        usuario.select();
        return false;
    }
    var tecnologias = forma.tecnologia;
    var checkSeleccionado = false;
    for(var i = 0; i < tecnologias.length; i++){
        if(tecnologias[i].checked){
            checkSeleccionado = true;
        }
    }
    if(!checkSeleccionado){
        alert("Debe seleccionar una tecnologia");
        return false;
    }

    var generos = forma.genero;
    var radioSeleccionado = false;
    for(i = 0; i < generos.length; i++){
        if(generos[i].checked){
            radioSeleccionado = true;
        }
    }
    if(!radioSeleccionado){
        alert("Debe seleccionar un genero");
        return false;
    }

    var ocupacion = forma.ocupacion;
    if(ocupacion.value == ""){
        alert("Debe seleccionar una ocupacion");
        return false;
    }

    //Formulario válido
    alert("Formulario válido");
    return true;

}