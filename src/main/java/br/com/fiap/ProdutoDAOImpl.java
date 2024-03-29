package br.com.fiap;

import javax.persistence.EntityManager;


public class ProdutoDAOImpl implements ProdutoDAO{
	
	private EntityManager em;
	
	public ProdutoDAOImpl(EntityManager em) {
		
		this.em = em;
	}
	
	public Produto buscarProdutoPorId(int id) throws RuntimeException {
		
		Produto produto = em.find(Produto.class, id);
		
		if (produto == null)
			throw new RuntimeException("Produto não encontrado.");
		
		return produto;
	}
	
}
