package ma.octo.assignement.domain;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "UTILISATEUR")
public class Utilisateur implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 10, nullable = false, unique = true)
  private String username;

  @Column(length = 10, nullable = false)
  private String gender;

  @Column(length = 60, nullable = false)
  private String lastname;

  @Column(length = 60, nullable = false)
  private String firstname;
  
  @OneToMany(mappedBy="utilisateur",fetch=FetchType.LAZY)
  private Collection<Compte> comptes;

  @Temporal(TemporalType.DATE)
  private Date birthdate;
  
  


  public Utilisateur() {
	super();
	// TODO Auto-generated constructor stub
}

public Utilisateur(Long id, String username, String gender, String lastname, String firstname,
		Collection<Compte> comptes, Date birthdate) {
	super();
	this.id = id;
	this.username = username;
	this.gender = gender;
	this.lastname = lastname;
	this.firstname = firstname;
	this.comptes = comptes;
	this.birthdate = birthdate;
}

public Collection<Compte> getComptes() {
	return comptes;
}

public void setComptes(Collection<Compte> comptes) {
	this.comptes = comptes;
}

public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public Date getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(Date birthdate) {
    this.birthdate = birthdate;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
