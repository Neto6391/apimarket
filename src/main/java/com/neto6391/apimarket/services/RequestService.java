package com.neto6391.apimarket.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neto6391.apimarket.domain.Request;
import com.neto6391.apimarket.repositories.RequestRepository;
import com.neto6391.apimarket.services.exceptions.ObjectNotFoundException;

@Service
public class RequestService {

	@Autowired
	private RequestRepository repo;
	
	public Request search(Integer id) {
		Optional<Request> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id+ ", Tipo: "+Request.class.getName()));
	}
	
}
