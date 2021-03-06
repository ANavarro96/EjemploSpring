package liceosorollab.accesoadatos.entidad;

// default package
// Generated 14-dic-2020 18:49:56 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * Album generated by hbm2java
 */
@Entity
@Table(name = "album", catalog = "musica", uniqueConstraints = @UniqueConstraint(columnNames = { "artista_id",
		"name" }))
public class Album implements java.io.Serializable {

	private int id;
	private Artista artista;
	private String name;
	private int year;
	private Set<Cancion> cancions = new HashSet<Cancion>(0);

	public Album() {
	}

	public Album(int id, Artista artista, String name, int year) {
		this.id = id;
		this.artista = artista;
		this.name = name;
		this.year = year;
	}

	public Album(int id, Artista artista, String name, int year, Set<Cancion> cancions) {
		this.id = id;
		this.artista = artista;
		this.name = name;
		this.year = year;
		this.cancions = cancions;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artista_id", nullable = false)
	public Artista getArtista() {
		return this.artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "year", nullable = false)
	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "album")
	public Set<Cancion> getCancions() {
		return this.cancions;
	}

	public void setCancions(Set<Cancion> cancions) {
		this.cancions = cancions;
	}

}
