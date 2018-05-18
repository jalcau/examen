package com.ipartek.controller;

import com.ipartek.model.UsuarioDao;
import com.ipartek.pojo.Usuario;


import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private UsuarioDao daoUsuario;
	private static final long serialVersionUID = 1L;
	private String view = "";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoUsuario = UsuarioDao.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		daoUsuario = null;
	}

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String nombre = request.getParameter("usuario");
		String password = request.getParameter("password");

		Usuario usuario = daoUsuario.check(nombre,password);
		
		if (usuario != null) {

			// guardar usuario en session
			HttpSession session = request.getSession();
			session.setAttribute("usuario", usuario);
			view="consultas.jsp";
		} else {

			view = "login.jsp";
			
		}} catch (Exception e) {
			e.printStackTrace();
			view = "login.jsp";
			
		} finally {
			
			request.getRequestDispatcher(view).forward(request, response);
		}
			
			

	}

}

