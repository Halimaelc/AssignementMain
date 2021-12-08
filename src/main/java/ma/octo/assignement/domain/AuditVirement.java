package ma.octo.assignement.domain;

import ma.octo.assignement.domain.util.EventType;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "AUDIT")
public class AuditVirement implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 100)
  private String message;

  @Enumerated(EnumType.STRING)
  private EventType eventType;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public AuditVirement() {
	super();
	// TODO Auto-generated constructor stub
}

public AuditVirement(Long id, String message, EventType eventType) {
	super();
	this.id = id;
	this.message = message;
	this.eventType = eventType;
}

public EventType getEventType() {
    return eventType;
  }

  public void setEventType(EventType eventType) {
    this.eventType = eventType;
  }
}
