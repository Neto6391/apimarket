package com.neto6391.apimarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neto6391.apimarket.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
