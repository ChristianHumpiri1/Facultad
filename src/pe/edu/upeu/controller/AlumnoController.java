package pe.edu.upeu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.dao.AlumnoDao;
import pe.edu.upeu.dao.EscuelaDao;
import pe.edu.upeu.daoimp.AlumnoDaoImp;
import pe.edu.upeu.daoimp.EscuelaDaoImp;
import pe.edu.upeu.entity.Alumno;

/**
 * Servlet implementation class AlumnoController
 */
@WebServlet("/ac")
public class AlumnoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AlumnoDao alu = new AlumnoDaoImp();
	private EscuelaDao esc= new EscuelaDaoImp();
	private Gson g = new Gson();
	int idalumno, idesc;
	String correo,  telefono , apellnombres;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlumnoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int op = Integer.parseInt(request.getParameter("opc"));
		switch(op) {
		case 1: //listar escuela
				out.println(g.toJson(esc.readAll()));
				break;
		case 2: //Listar alumno
			out.println(g.toJson(alu.readAll()));
		    break;
		case 3: //registrar alumno
			
			alu.create(new Alumno(0,
			Integer.parseInt(request.getParameter("esc")),
			request.getParameter("apell"),
			request.getParameter("correo"),
			request.getParameter("telef")));
	        out.println(g.toJson("Registro guardado"));  
	    break;  
		case 4:
			out.println(g.toJson(alu.read(Integer.parseInt(request.getParameter("id")))));		
		break;
		case 5:
			int x = alu.delete(Integer.parseInt(request.getParameter("id")));
			out.println(g.toJson(x));
			
			break; 
		case 6:
			idalumno = Integer.parseInt(request.getParameter("idp"));
			idesc = Integer.parseInt(request.getParameter("idesc"));
			apellnombres = request.getParameter("apell");
			correo = request.getParameter("correo");				
			telefono = request.getParameter("telef");				
			out.println(g.toJson(alu.update(new Alumno(idalumno, idesc, apellnombres, correo, telefono))));	
			break;	
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
