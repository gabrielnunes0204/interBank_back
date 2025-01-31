package br.com.interBank.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	@Column(name = "dataHoraTransferencia")
	private LocalDateTime dataHoraTransferencia;

	@Column(name = "dataHoraAgendamento")
	private LocalDateTime dataHoraAgendamento;
}
