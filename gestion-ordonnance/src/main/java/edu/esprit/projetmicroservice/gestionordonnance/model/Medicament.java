package edu.esprit.projetmicroservice.gestionordonnance.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Medicament implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    @Id
	    @Column(nullable = false, updatable = false)
	
	    @GeneratedValue(
	            strategy = GenerationType.AUTO
	    )
	    private Long id;

	   

	    @Column(nullable = false)
	    private String nomMedicament;

	    @Column
	    private String dosageMedicament;

	    @ManyToOne
	    private Ordonnance ordonnances;

	    
		public Ordonnance getIdOrdonnance() {
			return ordonnances;
		}

		public void setIdOrdonnance(Ordonnance idOrdonnance) {
			this.ordonnances = idOrdonnance;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

	

		public String getNomMedicament() {
			return nomMedicament;
		}

		public void setNomMedicament(String nomMedicament) {
			this.nomMedicament = nomMedicament;
		}

		public String getDosageMedicament() {
			return dosageMedicament;
		}

		public void setDosageMedicament(String dosageMedicament) {
			this.dosageMedicament = dosageMedicament;
		}

	
	    

}
