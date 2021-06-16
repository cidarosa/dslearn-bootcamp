package com.devsuperior.dslearnbds.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.devsuperior.dslearnbds.entities.pk.EnrollmentPK;

@Entity
@Table(name = "tb_enrollment")
public class Enrollment {
	
	//PK para classe de associação - precisa instanciar
	//chave composta
	@EmbeddedId
	private EnrollmentPK id = new EnrollmentPK(); //PK para classe de associação - precisa instanciar
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE") //UTC
	private Instant enrollMoment;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE") //UTC
	private Instant refundMoment;
	private boolean available;
	private boolean onlyUpdate;
	
	//associação
	@ManyToMany(mappedBy = "enrollmentsDone") //nome do atributo do outro lado
	private Set<Lesson> lessonsDone = new HashSet<>();
	
	@OneToMany(mappedBy = "enrollment")
	private List<Deliver> deliveries = new ArrayList<>();
	
	public Enrollment() {}

	/*Macete no construtor para o ID*/
	public Enrollment(User user, Offer offer, Instant enrollMoment, Instant refundMoment, boolean available,
			boolean onlyUpdate) {
		super();
		id.setUser(user);
		id.setOffer(offer);
		this.enrollMoment = enrollMoment;
		this.refundMoment = refundMoment;
		this.available = available;
		this.onlyUpdate = onlyUpdate;
	}
	
	//feito manualmente
	public User getStudent() {
		return id.getUser();
	}
	
	public void setStudent(User user) {
		id.setUser(user);
	}
	
	public Offer getOffer() {
		return id.getOffer();
	}
	
	public void setOffer(Offer offer) {
		id.setOffer(offer);
	}

	public Instant getEnrollMoment() {
		return enrollMoment;
	}

	public Instant getRefundMoment() {
		return refundMoment;
	}

	public boolean isAvailable() {
		return available;
	}

	public boolean isOnlyUpdate() {
		return onlyUpdate;
	}
	
	public void setEnrollMoment(Instant enrollMoment) {
		this.enrollMoment = enrollMoment;
	}

	public void setRefundMoment(Instant refundMoment) {
		this.refundMoment = refundMoment;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void setOnlyUpdate(boolean onlyUpdate) {
		this.onlyUpdate = onlyUpdate;
	}

	public Set<Lesson> getLessonsDone() {
		return lessonsDone;
	}	

}
