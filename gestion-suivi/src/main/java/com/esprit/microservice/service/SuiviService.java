package com.esprit.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esprit.microservice.model.Suivi;
import com.esprit.microservice.repository.SuiviRepository;


@Service
public class SuiviService {
	 @Autowired
		private final SuiviRepository suiviRepository;
	   
	    public SuiviService (final SuiviRepository suiviRepository) {
	        this.suiviRepository = suiviRepository;
	    }
	    @Transactional
	    public List<Suivi> findAll() {
	        return suiviRepository.findAll()
	               ;
	    }
	    public Suivi get(final Long id) {
	        return suiviRepository.findById(id).get()
	              ;
	    }
	    public Long create(Suivi suivi) {
	     
	        return suiviRepository.save(suivi).getId();
	    }
	 
	    public void update(final Long id, final Suivi suivi) {
	        final Suivi suivie = suiviRepository.findById(id).get()
	              ;
	        suiviRepository.save(suivie);
	    }
	    public void delete(final Long id) {
	    	suiviRepository.deleteById(id);
	    }

}
