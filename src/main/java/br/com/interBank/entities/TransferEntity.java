package br.com.interBank.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TransferEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nomeUsuario")
	private String nomeUsuario;
	
	@Column(name = "documentoUsuario")
	private String documentoUsuario;
	
	@Column(name = "contaOrigem")
	private Long contaOrigem;
	
	@Column(name = "contaDestino")
	private Long contaDestino;
	
	@Column(name = "valorTransferencia")
	private BigDecimal valorTransferencia;
	
	@Column(name = "valorTaxa")
	private BigDecimal valorTaxa;
	
	@Column(name = "dataHoraTransferencia")
	private LocalDateTime dataHoraTransferencia;

	@Column(name = "dataHoraAgendamento")
	private LocalDateTime dataHoraAgendamento;
}
