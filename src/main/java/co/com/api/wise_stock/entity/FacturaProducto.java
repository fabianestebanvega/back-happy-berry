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
@Table(name="factura_producto")
public class FacturaProducto {
	
	@Id
	@SequenceGenerator(name = "factura_producto_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "factura_producto_id_seq")
	private Integer id;
	private Integer facturaId;
	@ManyToOne
	@JoinColumn(name="producto_id")
	private Producto producto;
	private Integer cantidad;
	private Double precio;
	private Date fechaRegistro;
	

}
