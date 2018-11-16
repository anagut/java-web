package com.ana.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ana.database.BBDD;

/**
 * Servlet implementation class Usuario
 */
@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idUsuario = request.getParameter("id");
		System.out.println("ID recibido: "+ idUsuario);
		
		int idU = Integer.parseInt(idUsuario);  //se pasa de string a n�mero entero
		
		
	BBDD bbdd = new BBDD();
	
//	Usuario pepe = bbdd.usuarios.get(idU);
//		
//	request.setAttribute("elUsuario", pepe);
	
	request.setAttribute("elUsuario", bbdd.getUsuarioById(idU));
	
	request.getRequestDispatcher("./usuario.jsp").forward(request, response);
	
	
	
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
