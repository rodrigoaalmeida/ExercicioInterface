package model.services;

public class PaypalService implements OnlinePaymentService {

	@Override
	public Double paymentFee(Double amount) {
		// TODO Auto-generated method stub
		return (amount * 0.02) + amount;
	}

	@Override
	public Double interest(Double amount, Integer months) {
		// juros passando o pagamento e o mes
		return (amount * 0.01 * months) + amount;
	}

}
