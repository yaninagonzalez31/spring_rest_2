package py.edu.facitec.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Post extends General {
	
	private String título;
	private String autor;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private LocalDate fecha;
	private String texto; 
	
	
	// indicar uno a muchos- Indicar el objeto post de la otra clase
	//Aplicar la bidereccionalidad de la relacion
	@OneToMany(mappedBy = "post") 
	private List<Comentario>comentarios;  //asociacion


	public String getTítulo() {
		return título;
	}


	public void setTítulo(String título) {
		this.título = título;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}


	public List<Comentario> getComentarios() {
		return comentarios;
	}


	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}


	@Override
	public String toString() {
		return "Post [título=" + título + ", autor=" + autor + ", fecha=" + fecha + ", texto=" + texto + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	
	

}
