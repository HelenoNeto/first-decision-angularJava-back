package com.firstDecision.cadUsuario.Usuario.controller;

import com.firstDecision.cadUsuario.Usuario.model.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UsuarioIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void deveSalvarUsuarioComDadosValidos() {
        Usuario usuario = new Usuario(null, "Heleno", "heleno@gmail.com", "123456");

        ResponseEntity<Usuario> response = restTemplate.postForEntity("/v1/usuarios", usuario, Usuario.class);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals("Heleno", response.getBody().getNome());
    }

    @Test
    public void naoSalvarUsuarioComEmailInvalido() {
        Usuario usuario = new Usuario(null, "Heleno", "emailblabla", "123456");

        ResponseEntity<String> response = restTemplate.postForEntity("/v1/usuarios", usuario, String.class);

        System.out.println("Response retornado:" + response.getBody());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        Assertions.assertTrue(response.getBody().contains("Email inválido"));
    }
}