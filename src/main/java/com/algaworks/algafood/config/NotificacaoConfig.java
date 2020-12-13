package com.algaworks.algafood.config;

import org.springframework.context.annotation.Bean;

import com.algaworks.algafood.di.notificacao.NivelUrgencia;
import com.algaworks.algafood.di.notificacao.NotificadorEmail;
import com.algaworks.algafood.di.notificacao.NotificadorEmailMock;
import com.algaworks.algafood.di.notificacao.TipoNotificador;

// @Configuration
public class NotificacaoConfig {

	// Primary - Indicar qual bean tem prioridade na injeção quando houver ambiguidade.
	@Bean
	// @Primary
	// @Qualifier("normal")
	@TipoNotificador(NivelUrgencia.NORMAL)
	public NotificadorEmail notificadorEmail() {
		NotificadorEmail notificadorEmail = new NotificadorEmail();
		notificadorEmail.setCaixaAlta(true);
		
		return notificadorEmail;
	}
	
	@TipoNotificador(NivelUrgencia.NORMAL)
	public NotificadorEmailMock notificadorEmailMock() {
		NotificadorEmailMock notificadorEmail = new NotificadorEmailMock();
		notificadorEmail.setCaixaAlta(true);
		
		return notificadorEmail;
	}
}
