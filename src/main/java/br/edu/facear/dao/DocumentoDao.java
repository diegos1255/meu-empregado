package br.edu.facear.dao;

import javax.persistence.EntityManager;

import br.edu.facear.model.Documento;

public class DocumentoDao extends DAO{

	EntityManager em = getEntityManager();
	
	public void salvar(Documento documento){

		try {

			em.getTransaction().begin();

			if (documento.getId() != null) {

				//faz a edicao 
				em.merge(documento);

			} else {

				//faz a persistencia
				em.persist(documento);

			}

			//salva no BD
			em.getTransaction().commit();
		} catch (Exception e) {
			//se der erro, ele cancela o insert
			em.getTransaction().rollback();
		}

	}
	
}
