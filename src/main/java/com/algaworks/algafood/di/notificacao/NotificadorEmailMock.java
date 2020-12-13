package com.algaworks.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Profile("dev")
@Component
@TipoNotificador(NivelUrgencia.NORMAL)
public class NotificadorEmailMock implements Notificador {

	@Autowired
	private NotificadorProperties properties;
	private boolean caixaAlta;
	
	public NotificadorEmailMock() {
		System.out.println("NotificadorEmail MOCK");
	}
	
	public void notificar(Cliente cliente, String mensagem) {
		if (caixaAlta) {
			mensagem = mensagem.toUpperCase();
		}
		
		System.out.printf("MOCK: Notificando %s através do e-mail %s através do servidor smtp %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), this.properties.getHostServidor(), mensagem);
	}
	
	public void setCaixaAlta(boolean caixaAlta) {
		this.caixaAlta = caixaAlta;
	}
}
