package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	private final LocalDate dataAtual = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public Page<SaleReportDTO> findSaleReport(String minDate, String maxDate, String name, Pageable pageable) {
		minDate = atribuiNovaDataSeDataForEmBranco(minDate,dataAtual.minusYears(1L).toString());
		maxDate = atribuiNovaDataSeDataForEmBranco(maxDate, dataAtual.toString());

        return repository.findSaleReport(LocalDate.parse(minDate), LocalDate.parse(maxDate), name, pageable);
	}

	public List<SaleSummaryDTO> findSalesSummaryBySeller(String minDate, String maxDate) {
		minDate = atribuiNovaDataSeDataForEmBranco(minDate,dataAtual.minusYears(1L).toString());
		maxDate = atribuiNovaDataSeDataForEmBranco(maxDate, dataAtual.toString());

		return repository.findSumSaleBySeller(LocalDate.parse(minDate), LocalDate.parse(maxDate));
	}

	private String atribuiNovaDataSeDataForEmBranco(String data, String novaData){
		if (data.isBlank())
			return novaData;

		return data;
	}
}
