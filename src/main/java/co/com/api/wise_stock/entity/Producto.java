package co.com.api.wise_stock.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.Data;

@Entity
@Data
@CrossOrigin
public class Producto {
	
	@Id
	@SequenceGenerator(name = "producto_id_seq", sequenceName = "producto_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "producto_id_seq")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	private String modelo;
	private String marca;
	private Integer cantidad;
	private String color;
	private String detalles;
	private String imagen;
	private Double precioCompra;
	private Double precioVenta;
	private Double descuento;
	private Boolean estado;

	private Date fechaResgistro;
	
	/*
	 	@OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProveedorArticulo> proveedorArticulos = new HashSet<>();
	 */

}
