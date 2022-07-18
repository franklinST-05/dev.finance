package com.silva.devfinance.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;

import com.silva.devfinance.dao.FinanceDao;
import com.silva.devfinance.entity.FinanceEntity;
import com.silva.devfinance.enums.FinanceTypeEnum;

@ManagedBean(name = "reportBean")
public class ReportBean {
	private List<FinanceEntity> listFinances = new ArrayList<>();
	private Long expense;
	private Long income;

	private FinanceDao dao = new FinanceDao();
	private PieChartModel pieModel;

	@PostConstruct
	public void setDataListFinances() {
		this.listFinances = dao.getAllResultList(FinanceEntity.class);

		this.expense = 0L;
		this.income = 0L;

		for (FinanceEntity a : listFinances) {
			if (a.getFinanceTypeEnum().name() == FinanceTypeEnum.EXPENSE.name()) {
				this.expense += a.getPrice();
			} else if (a.getFinanceTypeEnum().name() == FinanceTypeEnum.INCOME.name()) {
				this.income += a.getPrice();
			}
		}

		createPieModel();

	}

	private void createPieModel() {
		pieModel = new PieChartModel();
		ChartData data = new ChartData();

		PieChartDataSet dataSet = new PieChartDataSet();

		List<Number> values = new ArrayList<>();

		values.add(income);
		values.add(expense);
		dataSet.setData(values);

		List<String> bgColors = new ArrayList<>();
		bgColors.add("rgb(255, 99, 132)");
		bgColors.add("rgb(54, 162, 235)");
		dataSet.setBackgroundColor(bgColors);

		data.addChartDataSet(dataSet);
		List<String> labels = new ArrayList<>();
		labels.add("Income");
		labels.add("Expense");
		data.setLabels(labels);

		pieModel.setData(data);
	}



	public PieChartModel getPieModel() {
		return pieModel;
	}

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}

	public List<FinanceEntity> getListFinances() {
		return listFinances;
	}

	public void setListFinances(List<FinanceEntity> listFinances) {
		this.listFinances = listFinances;
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
