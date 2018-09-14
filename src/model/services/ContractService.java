package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService paymentService;
	
	Calendar cal = Calendar.getInstance();
	private Date date;
	private Double amount;
	
	//construtor para não criar o objeto como nulo
	public ContractService(OnlinePaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public void processContract(Contract contract, Integer months) {
		
		double parcela = contract.getTotalValue() / months;
		
		
		
		for(int i = 1; i <= months; i++) {
			//amount = ;
			amount = paymentService.paymentFee(paymentService.interest(parcela, i));
			
			cal.setTime(contract.getDate());
			cal.add(Calendar.MONTH, i);
			
			date = cal.getTime();
			
			contract.adicionarList(new Installment(date, amount));
		}
	}

}
