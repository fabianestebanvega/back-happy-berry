package co.com.api.wise_stock.entity;

import javax.persistence.Column;
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
@Table(name="rol_usuario")
public class RolUsuario {
	
	@Id
	@SequenceGenerator(name = "rol_usuario_id_seq", sequenceName ="rol_usuario_id_seq", allocationSize = 1, initialValue = 3)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_usuario_id_seq")
	private Integer id;
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	@Column(name="rol_id")
	private Integer rolId;
	

}
