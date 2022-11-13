package com.esprit.examen.dto;

import java.util.Date;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import com.esprit.examen.entities.DetailFacture;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.Reglement;
@Getter
@Setter
public class DtoFacture {
	
	private Long idFacture;
	private float montantRemise;
	private float montantFacture;
	private Date dateCreationFacture;
	private Date dateDerniereModificationFacture;
	private Boolean archivee;
	private Set<DetailFacture> detailsFacture;
    private Fournisseur fournisseur;
    private Set<Reglement> reglements;
    
	public DtoFacture(float montantRemise, float montantFacture, Date dateCreationFacture,
			Date dateDerniereModificationFacture, Boolean archivee) {
		super();
		this.montantRemise = montantRemise;
		this.montantFacture = montantFacture;
		this.dateCreationFacture = dateCreationFacture;
		this.dateDerniereModificationFacture = dateDerniereModificationFacture;
		this.archivee = archivee;
	}
    
    

}
