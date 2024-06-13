package co.com.api.wise_stock.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="factura")
public class Factura {
	
	@Id
	@SequenceGenerator(name = "factura_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "factura_id_seq")
	private Integer id;
	@Column(nullable = true,unique = true)
	private Integer facturaId;
	@Column(nullable = true)
	private String descripcion;
	@ManyToOne
	@JoinColumn(name="estado_factura_id")
	private EstadoFactura estadoFactura;
	@Column(nullable = true)
	private Date fechaPedido;
	@Column(nullable = true)
	private Date fechaEntrega;
	@ManyToOne
	@JoinColumn(name="tipo_factura_id")
	private TipoFactura tipoFactura;
	@Column(nullable = true)
	private Integer proveedorId;
	private Double precioBase;
	private Double precioTotal;
	private Double iva;
	@ManyToOne
    @JoinColumn(name = "cliente_id", nullable = true) 
    private Cliente cliente;
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	private Date fechaRegistro;
	@OneToMany(mappedBy = "facturaId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<FacturaProducto>productos;
	

}
