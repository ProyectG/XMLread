package leer_xml;

import java.util.HashMap;

import org.w3c.dom.Document;
import utils.xmlUtils;



public class main {

	public static void main(String[] args) {
			Document documento = null;
		try {

			xmlUtils utilitario = new xmlUtils();
			
			//Se utilizara un archivo que se subira a un ftp.
			documento = utilitario.GenerarXml("http://proyectg.com/archivos/personas.xml");
		
			
			//Se envia el tag y el elemento a sacar.
			//El integer es para usar el numero del elemento el cual se puede asociar con los demas
			HashMap<Integer,String> persona_nombre = utilitario.leerNodo(documento, "persona", "nombre");
			HashMap<Integer,String> persona_edad = utilitario.leerNodo(documento, "persona", "edad");
			HashMap<Integer,String> persona_correo = utilitario.leerNodo(documento, "persona", "correo");
			
			
			System.out.println(persona_nombre.toString() + "\n" + persona_edad.toString() + "\n" + persona_correo);
			}
			  catch (Exception e) {
			    	e.printStackTrace();
			  }
		
	}

}
