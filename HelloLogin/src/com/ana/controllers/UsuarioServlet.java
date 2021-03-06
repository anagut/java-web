package com.ana.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		// Si existe el dato usuario en sesi�n --> lo dejo pasar
		// Si no lo redirijo a login

		if (session.getAttribute("usuario") != null) {
			// si el atributo usuario existe dentro de sensi�n (es diferente a null)
			
			String idUsuario = request.getParameter("id");
			System.out.println("ID recibido: " + idUsuario);

			int idU = Integer.parseInt(idUsuario); // se pasa de string a n�mero entero

			BBDD bbdd = BBDD.getInstance();
			
			request.setAttribute("elUsuario", bbdd.getUsuarioById(idU));

			request.getRequestDispatcher("./usuario.jsp").forward(request, response);
		
		} else {
			response.sendRedirect("login");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
