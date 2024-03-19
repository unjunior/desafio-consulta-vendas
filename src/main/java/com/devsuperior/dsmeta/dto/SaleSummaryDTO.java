package com.devsuperior.dsmeta.dto;

public class SaleSummaryDTO {
	
	private String nomeSeller;
	private Double sumSale;
	
	public SaleSummaryDTO(String nomeSeller, Double sumSale) {
		this.nomeSeller = nomeSeller;
		this.sumSale = sumSale;
	}

	public String getNomeSeller() {
		return nomeSeller;
	}

	public Double getSumSale() {
		return sumSale;
	}
	
	
	
}
