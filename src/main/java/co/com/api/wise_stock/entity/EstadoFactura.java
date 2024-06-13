package co.com.api.wise_stock.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="estado_factura")
public class EstadoFactura {
	@Id
	@SequenceGenerator(name = "estado_factura_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estado_factura_id_seq")
	private Integer id;
	private String nombre;

}
