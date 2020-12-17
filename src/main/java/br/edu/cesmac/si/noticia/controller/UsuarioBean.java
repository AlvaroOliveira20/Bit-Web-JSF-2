package br.edu.cesmac.si.noticia.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.edu.cesmac.si.noticia.domain.Usuario;
import br.edu.cesmac.si.noticia.repository.UsuarioJpa;


@ManagedBean
public class UsuarioBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios;

    public void salvar(Usuario usuario) {
        new UsuarioJpa().cadastrar(usuario);
    }

    public List<Usuario> getLista() {
        usuarios = new UsuarioJpa().listar();
        return usuarios;
    }

    public void remover(Usuario usuario) {
        new UsuarioJpa().remover(usuario);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}