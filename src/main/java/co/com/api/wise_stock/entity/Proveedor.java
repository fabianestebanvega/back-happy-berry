package co.com.api.wise_stock.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data

public class Proveedor {

	@Id
	@SequenceGenerator(name = "proveedor_id_seq", sequenceName = "proveedor_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proveedor_id_seq")

	private Integer id;

	@Column(unique = true)
	private Integer documento;

	private String nombres;
	private String apellidos;
	private String telefono;
	private String direccion;
	private String barrio;

	@OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ProveedorArticulo> proveedorArticulos = new HashSet<>();

}
