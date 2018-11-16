package com.ana.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ana.database.BBDD;
import com.ana.models.Habitacion;
import com.ana.models.Usuario;

/**
 * Servlet implementation class NuevosUsuariosServlet
 */
@WebServlet("/nuevousuario")
public class NuevoUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Habitacion> habitaciones = BBDD.getInstance().habitaciones;
		
		request.setAttribute("lasHabitaciones", habitaciones);
		
		request.getRequestDispatcher("./nuevousuario.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombrerecibido = request.getParameter("nombre");
		String emailrecibido = request.getParameter("email");
		String passwordrecibido = request.getParameter("password");
		String passwordconfrecibido = request.getParameter("passwordconf");
		String habitacionrecibida = request.getParameter("habitacion");
		
		System.out.println("Nombre:"+nombrerecibido);
		System.out.println("Email:"+emailrecibido);
		System.out.println("Password:"+passwordrecibido);
		System.out.println("Password:"+passwordconfrecibido);
		
			
//		if (emailrecibido!=null && !emailrecibido.equals("") && emailrecibido.indexOf("@")>0) {
//			//continuar e introducir al usuario en bbdd
//		}else {
//			request.setAttribute("error", "Datos incorrectos");
//			request.setAttribute("emailrec", emailrecibido);
//			this.doGet(request, response);
//		}
		
		Usuario nuevoUser = new Usuario(0, nombrerecibido, emailrecibido, passwordrecibido, null);
		
		if (nuevoUser.esValido(passwordconfrecibido)) {
			//continuar e introducir al usuario en bbdd
			BBDD db = BBDD.getInstance();
			db.insertUsuario(nuevoUser);
			
			response.sendRedirect("listausuarios");
			
		}else {
			request.setAttribute("error", "Datos incorrectos");
			request.setAttribute("newusuario", nuevoUser);
			this.doGet(request, response);
			
		}
	}

}