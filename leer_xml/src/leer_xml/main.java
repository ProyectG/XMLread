package leer_xml;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import utils.xmlUtils;



public class main {

	public static void main(String[] args) {
			Document documento = null;
		try {

			xmlUtils utilitario = new xmlUtils();
			
			//Se utilizara un archivo que se subira a un ftp.
			documento = utilitario.GenerarXml("http://proyectg.com/archivos/personas.xml");
			
			//Se crea un tipo lista de nodo que sacara la informacion de todos los tags persona.
			NodeList nodeLista = documento.getElementsByTagName("persona");
			
			//Se recorre segun la cantidad de nodos de personas que tenga en este caso 4.
			for (int s = 0; s < nodeLista.getLength(); s++) {
				
				//Se asocia el nodo que recorre al elemento NODO (tipo Node)
				Node NODO = nodeLista.item(s);
				String nombre;
				String edad;
				String correo;

				//Pregunto si el NODO es del tipo ELEMENT_NODE para continuar
				if (NODO.getNodeType() == Node.ELEMENT_NODE) {

				//Asocio el NODO a un ELEMENT para poder trabajar los nombres
				Element elemento_nodo = (Element) NODO;

				NodeList primerNombreElementoLista = elemento_nodo.getElementsByTagName("nombre");
				Element primerNombreElemento = (Element) primerNombreElementoLista.item(0);
				NodeList nombre_nodo = primerNombreElemento.getChildNodes();
				
				nombre = ((Node) nombre_nodo.item(0)).getNodeValue().toString();
				
				NodeList segundoNombreElementoLista = elemento_nodo.getElementsByTagName("edad");
				Element segundoNombreElemento =(Element) segundoNombreElementoLista.item(0);
				NodeList segundoNombre = segundoNombreElemento.getChildNodes();

				edad = ((Node) segundoNombre.item(0)).getNodeValue().toString();

				NodeList tercerNombreElementoLista = elemento_nodo.getElementsByTagName("correo");
				Element tercerNombreElemento =(Element) tercerNombreElementoLista.item(0);
				NodeList tercerNombre = tercerNombreElemento.getChildNodes();
				
				correo = ((Node) tercerNombre.item(0)).getNodeValue().toString();
				
				System.out.println(nombre + " " + edad + " " + correo);

				}
			      }
			  }
			  catch (Exception e) {
			    	e.printStackTrace();
			  }
		
	}

}
