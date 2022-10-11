package py.edu.facitec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//va a servir para responder a una determinada URL,
//con una página como respuesta.

@Controller
public class HomeController {
	
	//Recibir una URL como configuración 
	@RequestMapping ("/")
	public String home() {
		
		System.out.println("Ingrese a la pagina de Inicio");
		
		//Retornar una página
		return "index"; 
	}

}
