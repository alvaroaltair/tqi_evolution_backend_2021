package com.alvaro.emprestimo.controller;

import com.alvaro.emprestimo.domain.AuthorityEntity;
import com.alvaro.emprestimo.domain.ClienteEntity;
import com.alvaro.emprestimo.domain.UsuarioEntity;
import com.alvaro.emprestimo.dto.UsuarioDTO;
import com.alvaro.emprestimo.repository.AuthorityRepository;
import com.alvaro.emprestimo.repository.CadastroUsuarioRepository;
import com.alvaro.emprestimo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class CadastroUsuarioController {

    @Autowired
    private CadastroUsuarioRepository cadastroUsuarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @GetMapping("/cadastroUsuario")
    public String CadastroUsuario(UsuarioDTO requisicao) {
        return "cadastroUsuario";
    }

    @PostMapping("/cadastroUsuario")
    public String salvaUsuario(@Valid UsuarioDTO requisicao, BindingResult result, Principal principal) {

        if (result.hasErrors()) {
            return "cadastroUsuario";
        }

        ClienteEntity temp = requisicao.toUsuario();
        cadastroUsuarioRepository.save(temp);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        UsuarioEntity novoUsuario = new UsuarioEntity();
        novoUsuario.setUsuario(temp.getEmail());
        novoUsuario.setSenha(encoder.encode(temp.getSenha()));
        novoUsuario.setEnabled(true);

        AuthorityEntity authority = new AuthorityEntity();
        authority.setUsername(novoUsuario.getUsuario());
        authority.setAuthority("ROLE_USER");

        usuarioRepository.save(novoUsuario);
        authorityRepository.save(authority);

        return "index";
    }
}
