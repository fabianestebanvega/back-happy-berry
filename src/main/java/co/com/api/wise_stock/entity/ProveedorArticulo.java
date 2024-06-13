package co.com.api.wise_stock.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "proveedor_articulo")
public class ProveedorArticulo {

	@Id
	@SequenceGenerator(name = "proveedor_articulo_id_seq", sequenceName = "proveedor_articulo_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proveedor_articulo_id_seq")

	private Integer id;
	@ManyToOne
	@JoinColumn(name = "proveedor_id")
	private Proveedor proveedor;

	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;

	private Date fechaPedido;
	private Integer cantidad;

}
