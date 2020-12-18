package liceosorollab.accesoadatos.controlador;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import liceosorollab.accesoadatos.entidad.Album;
import liceosorollab.accesoadatos.entidad.Discografica;
import liceosorollab.accesoadatos.excepcion.MiError;
import liceosorollab.accesoadatos.repositorio.AlbumRepository;
import liceosorollab.accesoadatos.repositorio.DiscograficaRepository;

@RestController
@RequestMapping("discografica") // http://localhost:8080/discografica
public class DiscograficaController {

	@Autowired
	private DiscograficaRepository repositorio;
	
	@GetMapping // GET http://localhost:8080/discografica  -> todos los albumes
	public List<Discografica> devolverTodo(){
		return this.repositorio.findAll();
	}
	
	@GetMapping("/{id}") // GET http://localhost:8080/discografica  -> todos los albumes
	public Optional<Discografica> devolverPorId(@PathVariable("id") int id){
		return this.repositorio.findById(id);
	}
	
	@PostMapping
	@ResponseBody
	public Discografica anyadirDisco(@RequestBody Discografica disco){
		return this.repositorio.save(disco);
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> modificarDiscografica(@PathVariable("id") int id,@RequestBody Discografica disco) {	
		Optional<Discografica> d = this.repositorio.findById(id);	
		if(!d.isPresent()) {
			return new ResponseEntity<>("Hey primo que no existe la disdco hermano", HttpStatus.NOT_FOUND);		
		}
		else {
			
			d.get().setName(disco.getName());
			
			this.repositorio.save(d.get());
			
			return new ResponseEntity<Discografica>(d.get(), HttpStatus.OK);
		}
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> modificarDiscografica(@PathVariable("id") int id) {	
		
		Optional<Discografica> d = this.repositorio.findById(id);	
		
		if(!d.isPresent()) {
			return new ResponseEntity<>(new MiError("Hey primo que no existe la disco a borrar hermano",
					new Date()), HttpStatus.NOT_FOUND);		
		}
		else {
				
			this.repositorio.deleteById(id);
			
			return new ResponseEntity<String>("Se ha borrado la discograficA", HttpStatus.OK);
		}
	}
	
}
