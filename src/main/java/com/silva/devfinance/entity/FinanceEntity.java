package com.silva.devfinance.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.silva.devfinance.enums.FinanceTypeEnum;

@Entity
public class FinanceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private Long price;
	private Date date;
	private FinanceTypeEnum financeTypeEnum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public FinanceTypeEnum getFinanceTypeEnum() {
		return financeTypeEnum;
	}

	public void setFinanceTypeEnum(FinanceTypeEnum financeTypeEnum) {
		this.financeTypeEnum = financeTypeEnum;
	}

}
