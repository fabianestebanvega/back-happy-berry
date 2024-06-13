package co.com.api.wise_stock.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="codigo_cambio")
@Data
public class CodigoCambio {
	
	@Id
	@SequenceGenerator(name = "codigo_registro_id_seq", sequenceName = "codigo_registro_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "codigo_registro_id_seq")
	private Integer id;
	private String codigo;
	private String email;
	private String password;
	private String uuid;
	private Date fecha;

}
