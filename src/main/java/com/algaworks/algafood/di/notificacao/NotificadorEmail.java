package com.algaworks.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Profile("prod")
@Component
@TipoNotificador(NivelUrgencia.NORMAL)
public class NotificadorEmail implements Notificador {

	@Autowired
	private NotificadorProperties properties;
	private boolean caixaAlta;
	
	public NotificadorEmail() {
		System.out.println("NotificadorEmail");
	}
	
	public void notificar(Cliente cliente, String mensagem) {
		if (caixaAlta) {
			mensagem = mensagem.toUpperCase();
		}
		
		System.out.println("Porta servidor configurada no properties: " + properties.getPortaServidor());
		System.out.printf("Notificando %s através do e-mail %s através do servidor smtp %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), properties.getHostServidor(), mensagem);
	}
	
	public void setCaixaAlta(boolean caixaAlta) {
		this.caixaAlta = caixaAlta;
	}
}
