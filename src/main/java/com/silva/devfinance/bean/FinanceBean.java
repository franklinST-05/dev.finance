package com.silva.devfinance.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import com.silva.devfinance.dao.FinanceDao;
import com.silva.devfinance.entity.FinanceEntity;
import com.silva.devfinance.enums.FinanceTypeEnum;

@ManagedBean(name = "financeBean")
@ViewScoped
public class FinanceBean {
	private FinanceEntity financeEntity = new FinanceEntity();
	private FinanceDao dao = new FinanceDao();
	private List<FinanceEntity> listFinances;

	private Long expense;
	private Long income;

	public void save() {
		dao.merge(financeEntity);
		this.financeEntity = new FinanceEntity();
		setDataListFinances();
	}

	public void delete(FinanceEntity entity) {
		dao.deleteById(entity);
		setDataListFinances();
	}

	public void editSetInfo(FinanceEntity entity) {
		financeEntity = entity;
	}

	public SelectItem[] getFinanceTypes() {
		SelectItem[] items = new SelectItem[FinanceTypeEnum.values().length];
		int i = 0;
		for (FinanceTypeEnum t: FinanceTypeEnum.values()) {
			items[i++] = new SelectItem(t,t.getName());
		}
		return items;
	}
	
	@PostConstruct
	public void setDataListFinances() {
		this.listFinances = dao.getAllResultList(FinanceEntity.class);
		
		this.expense = 0L;
		this.income = 0L;

		for (FinanceEntity a: listFinances) {
			if(a.getFinanceTypeEnum().name() == FinanceTypeEnum.EXPENSE.name()) {
				this.expense += a.getPrice();
			} else if(a.getFinanceTypeEnum().name() == FinanceTypeEnum.INCOME.name()) {
				this.income += a.getPrice();
			}
		}
		
		
	}

	public FinanceEntity getFinanceEntity() {
		return financeEntity;
	}

	public void setFinanceEntity(FinanceEntity financeEntity) {
		this.financeEntity = financeEntity;
	}

	public List<FinanceEntity> getListFinances() {
		return listFinances;
	}

	public void setListFinances(List<FinanceEntity> listFinance) {
		this.listFinances = listFinance;
	}


	public Long getExpense() {
		return expense;
	}

	public void setExpense(Long expense) {
		this.expense = expense;
	}

	public Long getIncome() {
		return income;
	}

	public void setIncome(Long income) {
		this.income = income;
	}

}
