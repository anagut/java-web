package com.ana.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ana.database.BBDD;
import com.ana.models.Habitacion;


@WebServlet("/nuevahabitacion")
public class NuevaHabitacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NuevaHabitacionServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("./nuevahabitacion.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String callerecibida = request.getParameter("calle");
		String numerorecibido = request.getParameter("numero");
		String ciudadrecibida = request.getParameter("ciudad");
		
		int numrecibido = 0;
		
		try {
			numrecibido = Integer.parseInt(numerorecibido);
		}catch (Exception e) {
			System.out.println("Excpeci�n: "+e.getMessage());
		}
		
		
		System.out.println("calle:"+callerecibida);
		System.out.println("N�mero:"+numerorecibido);
		System.out.println("Ciudad:"+ciudadrecibida);

		Habitacion nuevahab = new Habitacion(0, callerecibida, numrecibido, ciudadrecibida);
		
		
		if (nuevahab.esValido()) {
			BBDD db = BBDD.getInstance();
			db.insertHabitacion(nuevahab);
			
			response.sendRedirect("nuevousuario");
		}else {
			request.setAttribute("error", "Datos incorrectos");
			request.setAttribute("newhabitacion", nuevahab);
			this.doGet(request, response);
		}

	
		
		
	}

}
