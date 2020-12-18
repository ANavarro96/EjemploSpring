package liceosorollab.accesoadatos.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import liceosorollab.accesoadatos.entidad.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Integer> {

	// select * from album where year = anyo
	List<Album> findByYear(int anyo);
	
	// select * from album where year = anyo
		List<Album> findByName(String name);
	
	// select * from album where year < anyo
	List<Album> findByYearLessThan(int anyo);
	
	// select * from album where year = anyo and name = name
	List<Album> findByYearAndName(int anyo,String name);
	
	// select * from album where year = anyo or name = name
	List<Album> findByYearOrName(int anyo,String name);
}
