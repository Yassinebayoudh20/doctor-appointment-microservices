package edu.esprit.projetmicroservice.gestionordonnance.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.esprit.projetmicroservice.gestionordonnance.model.Medicament;
import edu.esprit.projetmicroservice.gestionordonnance.model.Ordonnance;
import edu.esprit.projetmicroservice.gestionordonnance.repository.MedicamentRepository;
import edu.esprit.projetmicroservice.gestionordonnance.repository.OrdonnanceRepository;





@Service
public class MedicamentService {
 
	   private final MedicamentRepository medicamentRepository;
 
	    private final OrdonnanceRepository ordonnanceRepository;

	    public MedicamentService(final MedicamentRepository medicamentRepository,
	            final OrdonnanceRepository ordonnanceRepository) {
	        this.medicamentRepository = medicamentRepository;
	        this.ordonnanceRepository = ordonnanceRepository;
	    }
	    @Transactional
	    public List<Medicament> findAll() {
	      
	    	List<Medicament> medicament	=medicamentRepository.findAll()
	             ;
	        		  return medicament;
	    }

	    public Medicament get(final Long id) {
	        return medicamentRepository.findById(id).get()
	                ;
	    }
    
	    public Long create(final Medicament medicament) {
	    
	        return medicamentRepository.save(medicament).getId();
	    }

	    public void update(final Long id,final Medicament Medicament) {
	        final Medicament medicament = medicamentRepository.findById(id).get();
	        medicamentRepository.save(medicament);
	    }
  
	    public void delete(final Long id) {
	        medicamentRepository.deleteById(id);
	    }
	
		public void affecterMedicamentaOrdonnance(int medicId, int ordId) {
		Medicament mid = medicamentRepository.findById((long) medicId).get() ;
		Ordonnance ord = ordonnanceRepository.findById((long) ordId).get() ;
		if (ord.getMedicaments()==null)
		{
			Set<Medicament> medicaments = new HashSet<Medicament>() ;
			medicaments.add(mid);
			mid.setIdOrdonnance(ord);
		}
		else 
			{mid.setIdOrdonnance(ord);}
		
		medicamentRepository.save(mid);
		
		
		
		
		}

}
