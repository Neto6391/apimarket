package com.neto6391.apimarket.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Request implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy hh:mm")
	private Date instant;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="request")
	private Payment payment;
	
	@ManyToOne
	@JoinColumn(name="address_of_delivery_id")
	private Address addressOfDelivery;

	//Class Request to know items of request associate it
	//Get Reference 'ItemRequest' on this attribute 'id' of 'ItemRequestPK'
	@OneToMany(mappedBy="id.request")
	private Set<ItemRequest> items = new HashSet<>();
	
	public Request() {}


	public Request(Integer id, Date instant, Client client, Address addressOfDelivery) {
		super();
		this.id = id;
		this.instant = instant;
		this.client = client;
		this.addressOfDelivery = addressOfDelivery;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstant() {
		return instant;
	}

	public void setInstant(Date instant) {
		this.instant = instant;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Address getAddressOfDelivery() {
		return addressOfDelivery;
	}

	public void setAddressOfDelivery(Address addressOfDelivery) {
		this.addressOfDelivery = addressOfDelivery;
	}

	public Set<ItemRequest> getItems() {
		return items;
	}

	public void setItems(Set<ItemRequest> items) {
		this.items = items;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
}
