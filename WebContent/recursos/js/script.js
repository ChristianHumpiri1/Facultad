$(document).ready(function(){
listarestudiante();
listaes(0)
limpiar();
$("#telefono").numeric();
jQuery('#precio').keyup(function () { this.value = this.value.replace(/[^0-9\.]/g,''); });

});
$("#boton").click(function(){
	var esc= $("#esc").val();	
	var apell= $("#apellnombre").val();
	var correo= $("#correo").val();
	var telef = $("#telefono").val();
	var id = $("#id").val();
	if(id==0){
		$.post("ac", {esc:esc,apell:apell,correo:correo,telef:telef, opc:3}).done(function(data){
			limpiar();
			listaes(0)
			listarestudiante();
			});
	}else{
		bootbox.confirm("Desea Modificar?", function(result) {
		if(result){
		 	bootbox.alert("Registro Modificado Correctamente!", function() {		
			$.post("ac", {idesc :esc, apell:apell, correo:correo, telef:telef, idp:id, opc:6}).done(function(data){
				$("#id").val(0);
				limpiar();
				listaes(0)
				listarestudiante();	
				
			});
		 	});
		}else{
	    	bootbox.alert("El registro no se Modifico!");
	    	limpiar();
	    	listaes(0)
			listarestudiante();
	    }});		
	}
});
function listaes(x){
	var i, c =1;
	$("#esc").empty().append('<option selected="selected" value="test">Seleccionar Escuela</option>')
		$.get("ac", {opc : 1}, 
		function(data) {
		var d = JSON.parse(data);
		for (i = 0; i < d.length; i++) {
			if (x == d[i].idescuela) {
				$("#esc").append(
						"<option selected='selected' value='" + d[i].idescuela + "'>"
								+ d[i].nombre + "</option>");
			} else {
				$("#esc").append(
						"<option value='" + d[i].idescuela + "'>"
								+ d[i].nombre + "</option>");
			}
		}
	});	
}

function listarestudiante(){
	var i, c =1;
	$.get("ac",{opc:2},function(data){	
		var d = JSON.parse(data);
		
		$('#tablita tbody').empty();
		for(i=0;i<d.length;i++){
	
			$("#tablita tbody").append("<tr><td style='color:blue'>"+c+"</td><td>"+d[i].nombre+"</td><td>"+d[i].apellnombre+"</td><td>"+d[i].correo+"</td><td>"+d[i].telefono+
			"</td><td><a href='#' style='color:green' onclick='modificar("+d[i].idalumno+")'><i class='far fa-edit'></i></a></td><td><a href='#' style='color:red' onclick='eliminar("+d[i].idalumno+")'><i class='far fa-trash-alt'></i></a></td></tr>")
			c++;
		}
	});
}

function eliminar(id){	
	bootbox.confirm("Desea Eliminar?", function(result) {
    if(result){
    	bootbox.alert("Registro Eliminado!", function() {
    		$.get("ac",{id:id,opc:5},function(data){
     			limpiar();
     			listaes(0);
     			listarestudiante();
		});
    	});
		 
    }else{
    	bootbox.alert("El registro no se Elimino...!")
    }});
}
function modificar(id){	
	$.post("ac",{id:id,opc:4},function(data){
		var x = JSON.parse(data);
		$("#apellnombre").val(x[0].apellnombres);
		$("#correo").val(x[0].correo);
		$("#telefono").val(x[0].telefono);
		$("#id").val(x[0].idalumno);		
		listaes(x[0].idescuela);
	});
}
function limpiar(){
	$("#apellnombre").val("");
	$("#correo").val("");
	$("#telefono").val("");
	$("#apellnombre").focus();
}

