package com.firstDecision.cadUsuario.Usuario.controller;

import com.firstDecision.cadUsuario.Usuario.dto.UsuarioDTO;
import com.firstDecision.cadUsuario.Usuario.model.Usuario;
import com.firstDecision.cadUsuario.Usuario.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioDTO> save(@RequestBody @Valid Usuario user) {
        return service.salvar(user);
    }

    @PutMapping("/{id}")
    public UsuarioDTO edite(@PathVariable Long id, @Valid @RequestBody Usuario user) {
        return service.editar(id, user);
    }

    @GetMapping
    public List<UsuarioDTO> listAll() {
        return this.service.listarUsuarios();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        return this.service.buscarUsuario(id)
                .map(usuario -> {
                    this.service.deletarUsuario(usuario);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity
                        .status(404)
                        .body("Usuário com ID " + id + " não encontrado."));
    }

}
