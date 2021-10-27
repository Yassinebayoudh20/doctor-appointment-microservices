package com.esprit.microservice.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Suivi implements Serializable  {
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
    private String nomPatient;


    @Column(nullable = false)
    private LocalDate dateDebut;

    @Column(nullable = false)
    private LocalDate dateFin;

    @Column(nullable = false)
    private Long nbrSeances;

    @OneToMany(mappedBy = "suivis",fetch= FetchType.EAGER)
    private Set<Seance> seances;

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

	public String getNomPatient() {
		return nomPatient;
	}

	public void setNomPatient(String nomPatient) {
		this.nomPatient = nomPatient;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public Long getNbrSeances() {
		return nbrSeances;
	}

	public void setNbrSeances(Long nbrSeances) {
		this.nbrSeances = nbrSeances;
	}

	public Set<Seance> getSeances() {
		return seances;
	}

	public void setSeances(Set<Seance> seances) {
		this.seances = seances;
	}
    

}
