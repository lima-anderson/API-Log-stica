package com.laentwicklung.lalogapi.api.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.laentwicklung.lalogapi.domain.service.CatalogoClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	ClienteRepository clienteRepository;
	CatalogoClienteService catalogoClienteService;

	public ClienteController(ClienteRepository clienteRepository, CatalogoClienteService catalogoClienteService) {
		this.clienteRepository = clienteRepository;
		this.catalogoClienteService = catalogoClienteService;
	}

	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	@GetMapping("/{idCliente}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long idCliente) {

		return clienteRepository.findById(idCliente).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {

		return catalogoClienteService.salvar(cliente);
	}

	@PutMapping("/{idCliente}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long idCliente, @Valid @RequestBody Cliente cliente) {

		if (!clienteRepository.existsById(idCliente)) {
			return ResponseEntity.notFound().build();
		}

		cliente.setId(idCliente);
		cliente = catalogoClienteService.salvar(cliente);

		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("/{idCliente}")
	public ResponseEntity<Void> excluir(@PathVariable Long idCliente) {
		if (!clienteRepository.existsById(idCliente)) {
			return ResponseEntity.notFound().build();
		}

		catalogoClienteService.excluir(idCliente);

		return ResponseEntity.noContent().build();

	}

}