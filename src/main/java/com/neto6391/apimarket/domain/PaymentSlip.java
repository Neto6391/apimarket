package com.neto6391.apimarket.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import com.neto6391.apimarket.domain.enums.StatePayment;

@Entity
public class PaymentSlip extends Payment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Date dateVenciment;
	private Date datePayment;
	
	public PaymentSlip() {
		super();
	}

	public PaymentSlip(Integer id, StatePayment state, Request request, Date dateVenciment, Date datePayment) {
		super(id, state, request);
		this.dateVenciment = dateVenciment;
		this.datePayment = datePayment;
	}

	public Date getDateVenciment() {
		return dateVenciment;
	}

	public void setDateVenciment(Date dateVenciment) {
		this.dateVenciment = dateVenciment;
	}

	public Date getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(Date datePayment) {
		this.datePayment = datePayment;
	}
	
	
}
