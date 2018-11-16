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
 * Servlet implementation class HabitacionServlet
 */
@WebServlet("/habitacion")
public class HabitacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HabitacionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		if (session.getAttribute("usuario") != null) {
			// si el atributo usuario existe dentro de sensi�n (es diferente a null)
			
			String idHab = request.getParameter("hid");
			System.out.println("IDHab recibido: "+ idHab);
			
			int idH = Integer.parseInt(idHab);
			
			BBDD bbdd = BBDD.getInstance();
			
			request.setAttribute("laHabitacion", bbdd.getHabitacionById(idH));
			
			request.getRequestDispatcher("./habitacion.jsp").forward(request, response);

		} else {
			response.sendRedirect("login");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
