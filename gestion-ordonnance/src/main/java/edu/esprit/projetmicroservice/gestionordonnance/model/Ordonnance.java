package edu.esprit.projetmicroservice.gestionordonnance.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;



import java.io.Serializable;
import java.time.LocalDate;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
//import edu.esprit.projetmicroservice.gestion_ordonnance.medicament.Medicament;

import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Ordonnance implements Serializable  {
	private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(
            strategy = GenerationType.AUTO
  
    )
    private Long id;

    @Column(nullable = false)
    private String nomMedcin;

    @Column(nullable = false)
    private String prenomMedcin;

    @Column(nullable = false)
    private String nomPatient;

    @Column(nullable = false)
    private String prenomPatient;

    @Column(nullable = false)
    private LocalDate dateOrdonnance;

    @Column(nullable = false)
    private String localeCabinet;

    @OneToMany(mappedBy = "ordonnances",fetch= FetchType.EAGER)
    private Set<Medicament> medicaments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomMedcin() {
		return nomMedcin;
	}

	public void setNomMedcin(String nomMedcin) {
		this.nomMedcin = nomMedcin;
	}

	public String getPrenomMedcin() {
		return prenomMedcin;
	}

	public void setPrenomMedcin(String prenomMedcin) {
		this.prenomMedcin = prenomMedcin;
	}

	public String getNomPatient() {
		return nomPatient;
	}

	public void setNomPatient(String nomPatient) {
		this.nomPatient = nomPatient;
	}

	public String getPrenomPatient() {
		return prenomPatient;
	}

	public void setPrenomPatient(String prenomPatient) {
		this.prenomPatient = prenomPatient;
	}

	public LocalDate getDateOrdonnance() {
		return dateOrdonnance;
	}

	public void setDateOrdonnance(LocalDate dateOrdonnance) {
		this.dateOrdonnance = dateOrdonnance;
	}

	public String getLocaleCabinet() {
		return localeCabinet;
	}

	public void setLocaleCabinet(String localeCabinet) {
		this.localeCabinet = localeCabinet;
	}

	public Set<Medicament> getMedicaments() {
		return medicaments;
	}

	public void setMedicaments(Set<Medicament> medicaments) {
		this.medicaments = medicaments;
	}

	


}
