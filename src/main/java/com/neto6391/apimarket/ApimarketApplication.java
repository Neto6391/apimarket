package com.neto6391.apimarket;


import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.neto6391.apimarket.domain.Address;
import com.neto6391.apimarket.domain.Category;
import com.neto6391.apimarket.domain.City;
import com.neto6391.apimarket.domain.Client;
import com.neto6391.apimarket.domain.Payment;
import com.neto6391.apimarket.domain.PaymentSlip;
import com.neto6391.apimarket.domain.PaymentWithCreditCard;
import com.neto6391.apimarket.domain.Product;
import com.neto6391.apimarket.domain.Request;
import com.neto6391.apimarket.domain.State;
import com.neto6391.apimarket.domain.enums.StatePayment;
import com.neto6391.apimarket.domain.enums.TypeClient;
import com.neto6391.apimarket.repositories.AddressRepository;
import com.neto6391.apimarket.repositories.CategoryRepository;
import com.neto6391.apimarket.repositories.CityRepository;
import com.neto6391.apimarket.repositories.ClientRepository;
import com.neto6391.apimarket.repositories.PaymentRepository;
import com.neto6391.apimarket.repositories.ProductRepository;
import com.neto6391.apimarket.repositories.RequestRepository;
import com.neto6391.apimarket.repositories.StateRepository;

@SpringBootApplication
public class ApimarketApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private RequestRepository requestRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ApimarketApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritorio");
		
		Product p1 = new Product(null, "Computador", 2000.00);
		Product p2 = new Product(null, "Impressora", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		State est1 = new State(null, "Minas Gerais");
		State est2 = new State(null, "São Paulo");
		
		City c1 = new City(null, "Unberlândia", est1);
		City c2 = new City(null, "São Paulo", est2);
		City c3 = new City(null, "Campinas", est2);
		
		est1.getCities().addAll(Arrays.asList(c1));
		est2.getCities().addAll(Arrays.asList(c2, c3));
		
		stateRepository.saveAll(Arrays.asList(est1, est2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", TypeClient.PERSONPHYSICAL);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Address ad1 = new Address(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cli1, c1);
		Address ad2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getAddresses().addAll(Arrays.asList(ad1, ad2));
		
		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(ad1, ad2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Request req1 = new Request(null, sdf.parse("30/09/2017 10:32"), cli1, ad1);
		Request req2 = new Request(null, sdf.parse("10/10/2017 19:35"), cli1, ad2);
		
		Payment pay1 = new PaymentWithCreditCard(null, StatePayment.PAYED, req1, 6);
		req1.setPayment(pay1);
		
		Payment pay2 = new PaymentSlip(null, StatePayment.PENDENT, req2, sdf.parse("20/10/2017 00:00"), null);
		req2.setPayment(pay2);
		
		cli1.getRequests().addAll(Arrays.asList(req1, req2));
		
		requestRepository.saveAll(Arrays.asList(req1, req2));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2));
	}
	
	
}
