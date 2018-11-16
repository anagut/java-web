package com.ana.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ana.database.BBDDCanciones;

/**
 * Servlet implementation class CancionServlet
 */
@WebServlet("/cancion")
public class CancionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idCancion = request.getParameter("id");
		System.out.println("ID recibido: "+ idCancion);
		
		int idC = Integer.parseInt(idCancion);  //se pasa de string a n�mero entero
		
		BBDDCanciones bbdd = new BBDDCanciones();
		
		request.setAttribute("laCancion", bbdd.getCancionById(idC));
		
		request.getRequestDispatcher("./cancion.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}