package com.firstDecision.cadUsuario.Usuario.dto.mapper;

import com.firstDecision.cadUsuario.Usuario.dto.UsuarioDTO;
import com.firstDecision.cadUsuario.Usuario.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioDTO toDto(Usuario user) {
        if (user == null) {
            return null;
        }

        return new UsuarioDTO(user.getId(), user.getNome(), user.getEmail(), user.getSenha());
    }

    public Usuario toEntity(UsuarioDTO dto) {
        if (dto == null) {
            return null;
        }

        Usuario user = new Usuario();
        user.setId(dto.id() == 0 ? null : dto.id());
        user.setNome(dto.nome());
        user.setEmail(dto.email());
        user.setSenha(dto.senha());

        return user;
    }
}
