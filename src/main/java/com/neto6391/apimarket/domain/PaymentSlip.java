package com.neto6391.apimarket.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.neto6391.apimarket.domain.enums.StatePayment;

@Entity
public class PaymentSlip extends Payment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dateVenciment;
	
	@JsonFormat(pattern="dd/MM/yyyy")
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
