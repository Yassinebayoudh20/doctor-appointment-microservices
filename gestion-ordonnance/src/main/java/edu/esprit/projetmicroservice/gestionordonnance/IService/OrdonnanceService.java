package edu.esprit.projetmicroservice.gestionordonnance.IService;

import java.util.List;

import edu.esprit.projetmicroservice.gestionordonnance.model.Ordonnance;


public interface OrdonnanceService {
	public List<Ordonnance> findAll() ;
	  public Ordonnance get(final Long id) ;

	    public Long create(Ordonnance ordonnance);
	    public void update(final Long id, final Ordonnance ordonnance);
	    public void delete(final Long id) ;
}
