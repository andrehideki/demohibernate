package com.demohib.association.onetoone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Carro2 {
	private Long id;
	private String name;
	private String color;
	private Engine2 engine;
}
