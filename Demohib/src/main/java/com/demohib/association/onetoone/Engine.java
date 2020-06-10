package com.demohib.association.onetoone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Engine {
	private Long id;
	private String make;
	private String model;
	private String size;
	private Carro car;
}
