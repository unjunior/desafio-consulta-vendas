package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

import com.devsuperior.dsmeta.entities.Sale;

public class SaleReportDTO {

	private Long id;
	private LocalDate date;
	private Double amount;
	private String nameSeller;
	
	public SaleReportDTO() {
	}

	public SaleReportDTO(Long id, LocalDate date, Double amount, String nameSeller) {
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.nameSeller = nameSeller;
	}
	
	public SaleReportDTO(Sale entity) {
		id = entity.getId();
		date = entity.getDate();
		amount = entity.getAmount();
		nameSeller = entity.getSeller().getName();
	}
	
	public Long getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}

	public Double getAmount() {
		return amount;
	}

	public String getNameSeller() {
		return nameSeller;
	}

}
