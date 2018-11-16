package com.ana.database;

import java.util.ArrayList;

import com.ana.models.Cancion;

public class BBDDCanciones {

	public ArrayList<Cancion> canciones = new ArrayList<Cancion>();
	
	public BBDDCanciones() {
		this.fillCanciones();
	}
	
	private boolean fillCanciones() {
		canciones.add(new Cancion(1, "Volaré", "Juanito", 4, null));
		canciones.add(new Cancion(2, "Volver", "Pepa", 3, null));
		canciones.add(new Cancion(3, "Tractor amarillo", "Zapato Veloz", 3, null));
		
		return true;
	}
	
	public Cancion getCancionById(int id) {
		Cancion cancionADevolver = null;
		
		for (Cancion unaCancion: canciones) {
			if(unaCancion.getId()==id) {
				cancionADevolver = unaCancion;
				break;	
			}
		}
		return cancionADevolver;
	}
	
}
