package edu.esprit.projetmicroservice.gestionordonnance.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.esprit.projetmicroservice.gestionordonnance.model.Ordonnance;
import edu.esprit.projetmicroservice.gestionordonnance.repository.OrdonnanceRepository;


@Service
public class OrdonnanceService {
    @Autowired
	private final OrdonnanceRepository ordonnanceRepository;
   
    public OrdonnanceService(final OrdonnanceRepository ordonnanceRepository) {
        this.ordonnanceRepository = ordonnanceRepository;
    }
    @Transactional
    public List<Ordonnance> findAll() {
        return ordonnanceRepository.findAll()
               ;
    }
    public Ordonnance get(final Long id) {
        return ordonnanceRepository.findById(id).get()
              ;
    }
    public Long create(Ordonnance ordonnance) {
     
        return ordonnanceRepository.save(ordonnance).getId();
    }
 
    public void update(final Long id, final Ordonnance Ordonnance) {
        final Ordonnance ordonnance = ordonnanceRepository.findById(id).get()
              ;
        ordonnanceRepository.save(ordonnance);
    }
    public void delete(final Long id) {
        ordonnanceRepository.deleteById(id);
    }
}
