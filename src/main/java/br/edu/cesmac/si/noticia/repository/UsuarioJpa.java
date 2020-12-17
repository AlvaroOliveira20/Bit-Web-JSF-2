package br.edu.cesmac.si.noticia.repository;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.cesmac.si.noticia.JPA.JpaUtil;
import br.edu.cesmac.si.noticia.domain.Usuario;

public class UsuarioJpa {

    public void cadastrar(Usuario usuario) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public void alterar(Usuario usuario) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Usuario usuario) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        usuario = em.merge(usuario);
        em.remove(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public List<Usuario> listar() {
        EntityManager em = JpaUtil.getEntityManager();

        List<Usuario> usuarios = em.createQuery("select e from usuario e").getResultList();
        em.close();

        return usuarios;
    }

}
