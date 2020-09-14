package br.com.sefaz.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.sefaz.model.Usuario;
import br.com.sefaz.model.util.JpaUtil;


public class UsuarioDaoImpl1 implements UsuarioDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaProject");
	
	
	//private EntityManager em = factory.createEntityManager();
	private EntityManager em;
	private EntityTransaction et;
	
	
	/**
	 * Método responsavel por inserir no banco.
	 * @param sql
	 */
	public void cadastrar(Usuario usuario) {
		
		try {
			this.em = factory.createEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(usuario);
			et.commit();
		} catch (Exception e) {
			if(em.isOpen()) {
				et.rollback();
			}
			System.out.println(e.getMessage());
			System.out.println("Erro transacao");
		} finally {
			if(em.isOpen()) {
				em.close();
			}
		}
	}
	
	/**
	 * Metodo para deletar informação no banco
	 * @param sql
	 */
	public void remover(Usuario usuario) {
		
		try {
			this.em = factory.createEntityManager();
			et = em.getTransaction();
			et.begin();
			em.remove(em.find(Usuario.class, usuario.getId()));
			et.commit();
		} catch (Exception e) {
			if(em.isOpen()) {
				et.rollback();
			}
			System.out.println(e.getMessage());
			System.out.println("Erro transa��o");
		} finally {
			if(em.isOpen()) {
				em.close();
			}
		}
	}
	
	/**
	 * Metodo responsavel por atualizar no banco
	 * @param sql
	 */
	public void alterar(Usuario usuario) {
		try {
			this.em = factory.createEntityManager();
			et = em.getTransaction();
			et.begin();
			em.merge(usuario);
			et.commit();
		} catch (Exception e) {
			if(em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro transa��o");
		} finally {
			if(em.isOpen()) {
				em.close();
			}
		}
	}
	
	/**
	 * Metodo para listar informações do banco
	 * @param sql
	 * @return List<Endereco>
	 */
	public List<Usuario> listarUsuarios() {
		
		this.em = factory.createEntityManager();
		Query query = em.createQuery("from Usuario u");
		List<Usuario> listaConta = query.getResultList();
		em.close();
		return listaConta;
	}

}