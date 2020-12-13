package com.algaworks.algafood.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.NivelUrgencia;
import com.algaworks.algafood.di.notificacao.Notificador;
import com.algaworks.algafood.di.notificacao.TipoNotificador;

public class AtivacaoClienteService {

	// Resolução de ambiguidade com lista de beans.
//	@Autowired
//	private List<Notificador> notificadores;
	
	@Autowired
	// @Qualifier("normal")
	@TipoNotificador(NivelUrgencia.NORMAL)
	private Notificador notificador;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	public void init() {
		System.out.println("INIT");
	}
	
	public void destroy() {
		System.out.println("DESTROY");
	}
	
	public AtivacaoClienteService() {
		System.out.println("AtivacaoClienteService");
	}
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
	}
}
