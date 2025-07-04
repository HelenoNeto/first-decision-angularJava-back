package com.firstDecision.cadUsuario.Usuario.service;

import com.firstDecision.cadUsuario.Usuario.dto.UsuarioDTO;
import com.firstDecision.cadUsuario.Usuario.dto.mapper.UsuarioMapper;
import com.firstDecision.cadUsuario.Usuario.exception.RecordNotFoundException;
import com.firstDecision.cadUsuario.Usuario.model.Usuario;
import com.firstDecision.cadUsuario.Usuario.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    public UsuarioRepository repository;
    @Autowired
    public UsuarioMapper mapper;

    public ResponseEntity<UsuarioDTO> salvar(@Valid Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(this.repository.save(usuario)));
    }

    public UsuarioDTO editar(Long id, @Valid Usuario usuario) {
        return this.repository.findById(id).map(user -> {
            user.setNome(usuario.getNome());
            user.setEmail(usuario.getEmail());
            user.setSenha(usuario.getSenha());
            return mapper.toDto(this.repository.save(user));
        }).orElseThrow(() -> new RecordNotFoundException(usuario.getId()));
    }

    public List<UsuarioDTO> listarUsuarios() {
        return this.repository.findAll().stream().map(mapper::toDto).toList();
    }

    public Optional<Usuario> buscarUsuario(Long id) {
        return this.repository.findById(id);
    }

    public void deletarUsuario(Usuario usuario) {
        this.repository.delete(usuario);
    }

}
