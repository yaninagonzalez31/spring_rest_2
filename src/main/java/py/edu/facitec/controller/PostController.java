package py.edu.facitec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.model.Post;
import py.edu.facitec.repository.PostRepository;


@RestController // Arquitectura Rest

@RequestMapping("/posts")//servidor
public class PostController {
	
	
	@Autowired // Inicializa dentro del contexto spring 
	private PostRepository postrepository;
	
	@GetMapping// Respondera al verbo GET.
	                              // url /posts
	public ResponseEntity<List<Post>> getAll(){
		
		//realizamos la consulta y cargamos el objeto posts
		List<Post>posts=postrepository.findAll();
			
			
			//retornamos la lista con el status
			return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);	
		
	}
	
	  //                /posts
	  //verbo           Post             //Indicar que los datos viajan dentro del request 
	 @PostMapping                        //Datos que vienen del cliente es el objeto request
	public ResponseEntity<Post>create(@RequestBody Post postllega){
		 
		 try {
			 Post postRegistrado=postrepository.save(postllega);
			 
			 System.out.println(postRegistrado.toString());
			 
			 return new ResponseEntity<Post>(postRegistrado, HttpStatus.OK);
		 } catch (Exception e) {
			 
			 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		 }
		 
	 }
	 
	                    //recibimos el codigo 
	 @GetMapping(value="/{codigo}")         //cargamos la variable
	 public ResponseEntity<Post> getOne(@PathVariable Long codigo){
		 
		 
		 //ayuda para trabajar con valores nulos                //consulta por codigo
		Optional<Post> postConsulta=postrepository.findById(codigo);
		
		if(postConsulta.isPresent()) {
			
		
			return new ResponseEntity<Post>(postConsulta.get(), HttpStatus.OK); 
		}else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	 }
	//Un objeto contenedor que puede contener o no  un valor nulo. si un valor esta presente 
	 
	
	 //verbo          DELETE
	 @DeleteMapping("/{codigo}")
	public ResponseEntity<Post> deleteById(@PathVariable Long codigo){
		 //logica para eliminar a traves de una tabla pre cargada 
		  try {
			postrepository.deleteById(codigo);
			  
			  return  new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			
			
			e.printStackTrace();
			
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		
	}
}


