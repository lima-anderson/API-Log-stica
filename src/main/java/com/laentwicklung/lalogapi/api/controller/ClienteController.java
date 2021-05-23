package com.laentwicklung.lalogapi.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.laentwicklung.lalogapi.domain.model.Cliente;
import com.laentwicklung.lalogapi.domain.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	ClienteRepository clienteRepository;

	public ClienteController(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	@GetMapping("/{idCliente}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long idCliente) {

		return clienteRepository.findById(idCliente).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

//		return clienteRepository.findById(idCliente)
//				.map(cliente -> ResponseEntity.ok(cliente))
//				.orElse(ResponseEntity.notFound().build());

//		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
//		if(cliente.isPresent()) {
//			return ResponseEntity.ok(cliente.get());
//		}
//		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@PutMapping("/{idCliente}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long idCliente, @RequestBody Cliente cliente) {

		if (!clienteRepository.existsById(idCliente)) {
			return ResponseEntity.notFound().build();
		}

		cliente.setId(idCliente);
		cliente = clienteRepository.save(cliente);

		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("/{idCliente}")
	public ResponseEntity<Void> excluir(@PathVariable Long idCliente) {
		if (!clienteRepository.existsById(idCliente)) {
			return ResponseEntity.notFound().build();
		}

		clienteRepository.deleteById(idCliente);

		return ResponseEntity.noContent().build();

	}

}