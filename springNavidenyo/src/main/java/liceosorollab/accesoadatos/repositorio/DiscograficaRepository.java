package liceosorollab.accesoadatos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import liceosorollab.accesoadatos.entidad.Discografica;

@Repository
public interface DiscograficaRepository extends JpaRepository<Discografica,Integer>  {

}
