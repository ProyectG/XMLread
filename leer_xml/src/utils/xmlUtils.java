package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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
	
	
	
	/**
	 * Saca el dato del nodo seleccionado.
	 * 
	 * @author proyectg 
	 * @param nodo Es el documento ya trabajado desde GenerarXml
	 * @param tag es el padre del tag a recorrer.
	 * @param dato es el tag donde se sacara la informacion.
	 * 
	 */
	public HashMap<Integer,String> leerNodo(Document nodo,String tag, String dato)
	{
		
		String resultado=null;
		HashMap<Integer,String> salida = new HashMap<Integer,String>();
		
		try{
		
		NodeList nodos = nodo.getElementsByTagName(tag);
		//Se ejecuta por la cantidad de elementos que contenga el tag.
		for (int x = 0; x < nodos.getLength(); x++) {
			
			//
			Node informacion = nodos.item(x);
			
			//Pregunta por el nodo, si del tipo NODE
			if (informacion.getNodeType() == Node.ELEMENT_NODE) {
				
					//Si pasa la validacion lo castea a un Element y lo ingresa a elemento_informacion
					Element elemento_informacion = (Element) informacion;
					//Como element obtiene el dato por el tag enviado y lo asocia a un NodeList
					NodeList dataNodo = elemento_informacion.getElementsByTagName(dato);
					//como nodelist obtengo el primer elemento encontrado
					Element primerNombreElemento = (Element) dataNodo.item(0);
					//se vuelve a pasar de element a Node list
					NodeList data_nodo = primerNombreElemento.getChildNodes();
					//se saca el dato del nodo.
					resultado = ((Node) data_nodo.item(0)).getNodeValue().toString();
					//Se inserta en el hashmap de salida.
					salida.put(x, resultado);
				}
			}
		}
		catch(Exception error)
		{
			error.printStackTrace();
		}
		
		return salida;
	}

}
