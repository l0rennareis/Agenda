package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Pessoa;

public class PessoaDao {
	EntityManager em;
	EntityManagerFactory factory;
	
	public PessoaDao() {
		em = getEntityManager();
	}
	
	private EntityManager getEntityManager() {
		factory = Persistence.createEntityManagerFactory("meubanco");
		
		if(em == null){
			em = factory.createEntityManager();
		}
		
		return em;
	}
	
	public void encerrar() {
		factory.close();
		em.close();
	}
	
	//CRUD
	public Integer gravar(Pessoa p) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
		return p.getId();
	}
	
	public void atualizar(Pessoa p) {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}
	
	public Pessoa buscarPorId(Integer id){
		return (Pessoa) em.find(Pessoa.class, id);
	}
	
	public void remover(Integer id){
		Pessoa p = buscarPorId(id);
		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
	}
	
	public List<Pessoa> getTodosObjetos(){
		return em.createQuery("from " + Pessoa.class.getName()).getResultList();
	}

}
