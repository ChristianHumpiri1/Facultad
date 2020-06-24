package pe.edu.upeu.test;



import com.google.gson.Gson;

import pe.edu.upeu.dao.AlumnoDao;
import pe.edu.upeu.dao.EscuelaDao;
import pe.edu.upeu.daoimp.EscuelaDaoImp;
import pe.edu.upeu.daoimp.AlumnoDaoImp;
import pe.edu.upeu.utils.Conexion;

public class Test {
	private static AlumnoDao pd = new AlumnoDaoImp();
	private static Gson g = new Gson();
	private static EscuelaDao es = new EscuelaDaoImp();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//conex();
		//listarP();
		ListaC();
		
 }
	 static void conex() {
		  if(Conexion.getConexion()!=null) {
			  System.out.println("Conectado");
		  }else {
			 System.out.println("Desconectado"); 
		  }	  
	  }
	 
	 
	 static void listarP() {
		  System.out.println(g.toJson(pd.readAll()));
	}
	 
	 static void ListaC() {
		 System.out.println(g.toJson(es.readAll()));
		
	}
	 


	
	

}
