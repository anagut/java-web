console.log("hola")

document.getElementById("habBtn").onclick = function(evnt) {
	evnt.preventDefault();
	window.location.href = "./nuevahabitacion";
}

