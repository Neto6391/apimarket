package com.neto6391.apimarket.domain.enums;

public enum TypeClient {
	
	PERSONPHYSICAL(1, "Pessoa Física"),
	PERSONJURIDIC(2, "Pessoa Jurídica");
	
	private int cod;
	private String description;
	
	private TypeClient(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}
	
	public static TypeClient toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TypeClient x: TypeClient.values()) {
			if(cod.equals(x)) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id Inválido: " + cod);
	}
	
}


