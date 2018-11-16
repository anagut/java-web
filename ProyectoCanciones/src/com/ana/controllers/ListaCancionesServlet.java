package com.ana.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ana.database.BBDDCanciones;

/**
 * Servlet implementation class ListaCancionesServlet
 */
@WebServlet("/listacanciones")
public class ListaCancionesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaCancionesServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        BBDDCanciones bbdd = new BBDDCanciones();
        
        //recolectar las canciones que estar�n en una bbdd
        request.setAttribute("lasCanciones", bbdd.canciones);
        
        
        // pasar al jsp        
		request.getRequestDispatcher("./listacanciones.jsp").forward(request, response);
  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
