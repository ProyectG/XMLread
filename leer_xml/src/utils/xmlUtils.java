package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class xmlUtils {
	
	/**
	 * Genera un archivo con formato xml para ser utilizado en su lectura.
	 * 
	 * @author proyectg 
	 * @param url es la ubicacion del archivo xml que se leera.
	 * 
	 */
	public Document GenerarXml(String url)
	{
		String xml="";
		Document documento = null;
		try
		{
		URL direccion= new URL(url);
			//lectura de la url
			BufferedReader br = new BufferedReader(new InputStreamReader(direccion.openStream()));
			String entrada;
			String cadena="";
			
			
			//lectura del archivo para asociarlo a un string
			while ((entrada = br.readLine()) != null){
				cadena = cadena + entrada;
			}

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			
			InputSource archivo = new InputSource();
			archivo.setCharacterStream(new StringReader(cadena)); 

			//Se genera el elemento xml
			documento = db.parse(archivo);
			documento.getDocumentElement().normalize();
		}
		catch(Exception error)
		{
			error.printStackTrace();
		}
		return documento;
	}
	
	
	
	public Element leerNodo(Node nodo,String elemento)
	{
	   //proximamente funcion de lectura generalizada de nodos.
		
		return null;
	}

}
