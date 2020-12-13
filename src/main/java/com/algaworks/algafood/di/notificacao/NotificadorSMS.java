package com.algaworks.algafood.di.notificacao;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Component
@TipoNotificador(NivelUrgencia.URGENTE)
public class NotificadorSMS implements Notificador {
	
	public NotificadorSMS() {
		System.out.println("NotificadorSMS");
	}
	
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s através do e-mail %s: %s\n", 
				cliente.getNome(), cliente.getTelefone(), mensagem);
	}
}
