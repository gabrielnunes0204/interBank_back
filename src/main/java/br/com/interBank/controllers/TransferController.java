package br.com.interBank.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.interBank.dtos.request.TransferenciaRequestDTO;
import br.com.interBank.dtos.response.CreateResponseDTO;
import br.com.interBank.dtos.response.TransferenciaResponseDTO;
import br.com.interBank.services.TransferService;

@RestController
@RequestMapping(value = "/transfer")
@CrossOrigin(origins = "http://localhost:4200")
public class TransferController {

	@Autowired
	private TransferService transferService;
	
	@GetMapping
	public ResponseEntity<List<TransferenciaResponseDTO>> getTransfer() {
		return ResponseEntity.status(HttpStatus.OK).body(this.transferService.getTransfer());
	}
	
	@PostMapping
	public ResponseEntity<CreateResponseDTO> createTransfer(
			@RequestBody TransferenciaRequestDTO request) {
		return ResponseEntity.status(HttpStatus.OK).body(this.transferService.createTransfer(request));
	}
}
