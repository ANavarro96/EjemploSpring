package liceosorollab.accesoadatos.controlador;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import liceosorollab.accesoadatos.entidad.Album;
import liceosorollab.accesoadatos.repositorio.AlbumRepository;

@RestController
@RequestMapping("album") // http://localhost:8080/album?nombre=rtrtr
public class AlbumController {

	@Autowired
	private AlbumRepository repositorio;
	
	@GetMapping // GET http://localhost:8080/album?nombre='name'  -> todos los albumes
	public List<Album> devolverTodo(@RequestParam(value = "nombre",required=false) String nombre){
		if(nombre==null) return this.repositorio.findAll();
		else return this.repositorio.findByName(nombre);
	}
	
	@GetMapping("/{id}") // GET http://localhost:8080/album  -> todos los albumes
	public Optional<Album> devolverPorId(@PathVariable("id") int id){
		return this.repositorio.findById(id);
	}
	
	@PostMapping
	@ResponseBody
	public Album anyadirAlbum(@RequestBody Album nuevoAlbum){
		return this.repositorio.save(nuevoAlbum);
	}
}
