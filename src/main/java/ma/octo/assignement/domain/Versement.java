package ma.octo.assignement.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "VERSEMENT")
public class Versement implements Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(precision = 16, scale = 2, nullable = false)
  private BigDecimal montantVersement;

  @Column
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateExecution;

  @Column
  private String nom_prenom_emetteur;

  public Versement() {
	super();
	// TODO Auto-generated constructor stub
}

public Versement(Long id, BigDecimal montantVersement, Date dateExecution, String nom_prenom_emetteur,
		Compte compteBeneficiaire, String motifVersement) {
	super();
	this.id = id;
	this.montantVersement = montantVersement;
	this.dateExecution = dateExecution;
	this.nom_prenom_emetteur = nom_prenom_emetteur;
	this.compteBeneficiaire = compteBeneficiaire;
	this.motifVersement = motifVersement;
}

@ManyToOne
  private Compte compteBeneficiaire;

  @Column(length = 200)
  private String motifVersement;

  public BigDecimal getMontantVersement() {
    return montantVersement;
  }

  public void setMontantVersement(BigDecimal montantVersement) {
    this.montantVersement = montantVersement;
  }

  public Date getDateExecution() {
    return dateExecution;
  }

  public void setDateExecution(Date dateExecution) {
    this.dateExecution = dateExecution;
  }

  public Compte getCompteBeneficiaire() {
    return compteBeneficiaire;
  }

  public void setCompteBeneficiaire(Compte compteBeneficiaire) {
    this.compteBeneficiaire = compteBeneficiaire;
  }

  public String getMotifVersement() {
    return motifVersement;
  }

  public void setMotifVersement(String motifVersement) {
    this.motifVersement = motifVersement;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNom_prenom_emetteur() {
    return nom_prenom_emetteur;
  }

  public void setNom_prenom_emetteur(String nom_prenom_emetteur) {
    this.nom_prenom_emetteur = nom_prenom_emetteur;
  }
}
