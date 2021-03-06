package liceosorollab.accesoadatos.entidad;
// default package
// Generated 14-dic-2020 18:49:56 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Discografica generated by hbm2java
 */
@Entity
@Table(name = "discografica", catalog = "musica", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Discografica implements java.io.Serializable {

	private int id;
	private String name;
	private Set<Artista> artistas = new HashSet<Artista>(0);

	public Discografica() {
	}

	public Discografica(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Discografica(int id, String name, Set<Artista> artistas) {
		this.id = id;
		this.name = name;
		this.artistas = artistas;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name", unique = true, nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "discografica")
	public Set<Artista> getArtistas() {
		return this.artistas;
	}

	public void setArtistas(Set<Artista> artistas) {
		this.artistas = artistas;
	}

}
