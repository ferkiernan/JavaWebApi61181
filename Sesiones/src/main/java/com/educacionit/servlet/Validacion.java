package com.educacionit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.educacionit.entidades.Usuario;
import com.educacionit.implementaciones.MariaDB.UsuarioImpl;

/**
 * Servlet implementation class Validacion
 */
public class Validacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Boolean cerrarsesion = Boolean.valueOf(request.getParameter("cerrarsesion"));
		if (cerrarsesion && null != request.getSession().getId()) {
			request.getSession().invalidate();
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.setAttribute("recargaste", "Has actualizado");
			request.getRequestDispatcher("bienvenido.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String correo = request.getParameter("correo");
		String password = request.getParameter("clave");
		
		HttpSession sesion = null;
		String redireccion = "index.jsp";
		
		UsuarioImpl usuarioImpl = new UsuarioImpl();
		
		Usuario user = usuarioImpl.buscarPorId(correo);
		
		if(null != user && null != user.getClave() && user.getClave().equals(password)) {
			sesion = request.getSession();
			sesion.setAttribute("usuario", user);
			redireccion = "bienvenido.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(redireccion);
		dispatcher.forward(request, response);
		
		doGet(request, response);
	}

}
