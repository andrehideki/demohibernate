package com.demohib.collections;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Showroom {
	private Long id;
	private String location;
	private String manager;
	private List<Car> cars;
}
