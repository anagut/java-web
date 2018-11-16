package com.ana.database;

import java.util.ArrayList;

import com.ana.models.Habitacion;
import com.ana.models.Usuario;

public class BBDD {
	
	private static BBDD instance=null;
	
	public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	public ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
	
	public static final BBDD getInstance() {
		if(instance==null) instance = new BBDD();
		return instance;
	}
	
	private BBDD() {
		this.fillUsuarios();
		this.fillHabitaciones();
		this.relacionarUserHab();
	}
	
	private boolean fillUsuarios() {
		usuarios.add(new Usuario (1, "Pepe", "p@p.es", "ppp", null));
		usuarios.add(new Usuario (2, "Luisa", "l@l.es", "lll", null));
		usuarios.add(new Usuario (3, "Mordor", "m@m.es", "mmm", null));
		
		return true;
	}
	
	
	
	private boolean fillHabitaciones() {
		habitaciones.add(new Habitacion (101, "Calle Marqu�s", 23, "Madrid"));
		habitaciones.add(new Habitacion (102, "Calle Pantomima", 57, "Albacete"));
		habitaciones.add(new Habitacion (103, "Calle Pijo", 12, "Murcia"));
		
		return true;
	}
	
	private boolean relacionarUserHab() {
		usuarios.get(0).setHabitacion(habitaciones.get(2));
		usuarios.get(1).setHabitacion(habitaciones.get(1));
		usuarios.get(2).setHabitacion(habitaciones.get(0));
		
		return true;
	}
	
	
	//M�todo que en funci�n de la id me devuelve un objeto usuario concreto
	//Si no encuentra devuelve un null
	
	public Usuario getUsuarioById(int id) {
		Usuario usuarioADevolver = null;
		
		//Iteramos por cada usuario y comparamos su id con el que nos indican 
		for (Usuario unUsuario: usuarios) {
			if(unUsuario.getId()==id) {
				usuarioADevolver = unUsuario;
				break;	//cuando encuentra el id, sale del bucle
			}
		}
		return usuarioADevolver;
	}
	
	public Habitacion getHabitacionById(int hid) {
		Habitacion habitacionADevolver = null;
		
		for (Habitacion unaHab: habitaciones) {
			if(unaHab.getHid()==hid) {
				habitacionADevolver = unaHab;
				break;	
			}
		}
		return habitacionADevolver;
	}

	public boolean existeUsuarioPorEmailyPass(String emailrecibido, String passwordrecibido) {
		boolean existeUsuario = false;
//		for (*tipo de variable (objeto)* *variable* : *array sobre el que se busca*)
		for (Usuario unUsuario : usuarios) {
			if (unUsuario.getEmail().equals(emailrecibido) && unUsuario.getPassword().equals(passwordrecibido)) {
				existeUsuario = true;
				break;
			}
		}
		return existeUsuario;
	}

	public int insertUsuario(Usuario newUser) {
		int nuevoId=0;
		
		nuevoId=this.usuarios.size()+1;	//simulamos que la bd asigna un id consecutivo
		newUser.setId(nuevoId);
		
		this.usuarios.add(newUser);
		
		return nuevoId;
		
	}
	
}
