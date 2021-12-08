package ma.octo.assignement.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "VIREMENT")
public class Virement implements Serializable{
  public Virement() {
		super();
		// TODO Auto-generated constructor stub
	}

public Virement(Long id, double montantVirement, Date dateExecution, Compte compteEmetteur,
			Compte compteBeneficiaire, String motifVirement) {
		super();
		this.id = id;
		this.montantVirement = montantVirement;
		this.dateExecution = dateExecution;
		this.compteEmetteur = compteEmetteur;
		this.compteBeneficiaire = compteBeneficiaire;
		this.motifVirement = motifVirement;
	}

@Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(precision = 16, scale = 2, nullable = false)
  private double montantVirement;

  @Column
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateExecution;

  @ManyToOne
  private Compte compteEmetteur;

  @ManyToOne
  private Compte compteBeneficiaire;

  @Column(length = 200)
  private String motifVirement;

  public double getMontantVirement() {
    return montantVirement;
  }

  public void setMontantVirement(double d) {
    this.montantVirement = d;
  }

  public Date getDateExecution() {
    return dateExecution;
  }

  public void setDateExecution(Date dateExecution) {
    this.dateExecution = dateExecution;
  }

  public Compte getCompteEmetteur() {
    return compteEmetteur;
  }

  public void setCompteEmetteur(Compte compteEmetteur) {
    this.compteEmetteur = compteEmetteur;
  }

  public Compte getCompteBeneficiaire() {
    return compteBeneficiaire;
  }

  public void setCompteBeneficiaire(Compte compteBeneficiaire) {
    this.compteBeneficiaire = compteBeneficiaire;
  }

  public String getMotifVirement() {
    return motifVirement;
  }

  public void setMotifVirement(String motifVirement) {
    this.motifVirement = motifVirement;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
