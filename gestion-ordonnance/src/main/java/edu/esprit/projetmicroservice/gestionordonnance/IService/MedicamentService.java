package edu.esprit.projetmicroservice.gestionordonnance.IService;

import java.util.List;

import edu.esprit.projetmicroservice.gestionordonnance.model.Medicament;





public interface MedicamentService {

    public List<Medicament> findAll();
    public Medicament get(final Long id);
    public Long create(final Medicament medicament) ;
    public void update(final Long id, final Medicament medicamentDTO) ;
    public void delete(final Long id);
	public void affecterMedicamentaOrdonnance(int medicId, int ordId);

}
