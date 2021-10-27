package com.esprit.microservice.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Seance implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @Id
    @Column(nullable = false, updatable = false)

    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long id;

   

    @Column(nullable = false)
    private String typeAvancement;
    @Column(nullable = false)
    private String remarques;

    @Column(nullable = false)
    private LocalDate dateSeance;
    @Column(nullable = true)
    private Long idOrdonnance;

    @ManyToOne
    private Suivi suivis;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeAvancement() {
		return typeAvancement;
	}

	public void setTypeAvancement(String typeAvancement) {
		this.typeAvancement = typeAvancement;
	}

	public String getRemarques() {
		return remarques;
	}

	public void setRemarques(String remarques) {
		this.remarques = remarques;
	}

	public LocalDate getDateSeance() {
		return dateSeance;
	}

	public void setDateSeance(LocalDate dateSeance) {
		this.dateSeance = dateSeance;
	}

	public Suivi getSuivis() {
		return suivis;
	}

	public void setSuivis(Suivi suivis) {
		this.suivis = suivis;
	}

	public Long getIdOrdonnance() {
		return idOrdonnance;
	}

	public void setIdOrdonnance(Long idOrdonnance) {
		this.idOrdonnance = idOrdonnance;
	}
	
    
}
