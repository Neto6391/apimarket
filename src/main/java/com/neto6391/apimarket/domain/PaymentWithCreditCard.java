package com.neto6391.apimarket.domain;

import java.io.Serializable;

import javax.persistence.Entity;

import com.neto6391.apimarket.domain.enums.StatePayment;

@Entity
public class PaymentWithCreditCard extends Payment implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer numberOfParcels;

	public PaymentWithCreditCard() {
		super();
	}

	public PaymentWithCreditCard(Integer id, StatePayment state, Request request, Integer numberOfParcels) {
		super(id, state, request);
		this.numberOfParcels = numberOfParcels;
	}

	public Integer getNumberOfParcels() {
		return numberOfParcels;
	}

	public void setNumberOfParcels(Integer numberOfParcels) {
		this.numberOfParcels = numberOfParcels;
	}
	
}
