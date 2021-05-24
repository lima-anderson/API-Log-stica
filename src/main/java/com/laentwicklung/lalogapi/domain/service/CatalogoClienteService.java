package com.laentwicklung.lalogapi.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laentwicklung.lalogapi.domain.exception.NegocioException;
import com.laentwicklung.lalogapi.domain.model.Cliente;
import com.laentwicklung.lalogapi.domain.repository.ClienteRepository;

@Service
public class CatalogoClienteService {

	private ClienteRepository clienteRepository;

	public CatalogoClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Cliente buscar(Long idCliente) {
		return clienteRepository.findById(idCliente).orElseThrow(() -> new NegocioException("Cliente não encontrado"));
	}

	@Transactional
	public Cliente salvar(Cliente cliente) {

		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail()).stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

		if (emailEmUso) {
			throw new NegocioException("E-mail já cadastrado.");
		}

		return clienteRepository.save(cliente);
	}

	@Transactional
	public void excluir(Long idCliente) {
		clienteRepository.deleteById(idCliente);
	}

}
