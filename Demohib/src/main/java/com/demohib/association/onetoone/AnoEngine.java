package com.demohib.association.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class AnoEngine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ENGINE_ID")
	private Long id;
	private String make;
	private String model;
	private String size;
	@OneToOne(mappedBy = "engine")
	private AnoCar car;
}
