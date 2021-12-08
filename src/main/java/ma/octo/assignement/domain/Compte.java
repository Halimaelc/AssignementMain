package ma.octo.assignement.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "COMPTE")
public class Compte implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 16, unique = true)
  private String nrCompte;

  private String rib;

  @Column(precision = 16, scale = 2)
  private double solde;

  @ManyToOne()
  @JoinColumn(name = "utilisateur_id")
  private Utilisateur utilisateur;

  public Compte() {
	super();
	// TODO Auto-generated constructor stub
}

public Compte(Long id, String nrCompte, String rib, double solde, Utilisateur utilisateur) {
	super();
	this.id = id;
	this.nrCompte = nrCompte;
	this.rib = rib;
	this.solde = solde;
	this.utilisateur = utilisateur;
}

public String getNrCompte() {
    return nrCompte;
  }

  public void setNrCompte(String nrCompte) {
    this.nrCompte = nrCompte;
  }

  public String getRib() {
    return rib;
  }

  public void setRib(String rib) {
    this.rib = rib;
  }

  public double getSolde() {
    return solde;
  }

  public void setSolde(double solde) {
    this.solde = solde;
  }

  public Utilisateur getUtilisateur() {
    return utilisateur;
  }

  public void setUtilisateur(Utilisateur utilisateur) {
    this.utilisateur = utilisateur;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
