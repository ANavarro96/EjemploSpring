package liceosorollab.accesoadatos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import liceosorollab.accesoadatos.entidad.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Integer> {

}
