package com.devsuperior.dslearnbds.entities;

import java.time.Instant;

import com.devsuperior.dslearnbds.entities.pk.EnrollmentPK;

public class Enrollment {
	
	private EnrollmentPK id = new EnrollmentPK(); //PK para classe de associação - precisa instanciar
	
	private Instant enrollMoment;
	private Instant refundMoment;
	private boolean available;
	private boolean onlyUpdate;
	
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

	/*
	 * public EnrollmentPK getId() { return id; }
	 */
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

	/*
	 * public void setId(EnrollmentPK id) { this.id = id; }
	 */

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
	

}
