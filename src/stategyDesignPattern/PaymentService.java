package stategyDesignPattern;
/*
 * Strategy Design Patterns are used to separate out different implementations of the base contract, which are otherwise coupled into a single class, violating OCP and SRP.
 * These implementations are completely unaware of each other implementations and behavior of the object is decided by the implementation used.
 * Example: paymentStrategy can be implemented to have some base functions apart from their own functions. Object passed decided the nature of the payment service used by the client.
 * */
public class PaymentService {
	private PaymentMode paymentStrategy;
	private int cost;
	private boolean includeDelivery;
	
	public PaymentService(PaymentMode modeOfPayment,boolean inlcudeDelivery) {
		this.includeDelivery=inlcudeDelivery;
		this.paymentStrategy=modeOfPayment;
	}
	
	public void processOrder(String email,String password) {
		paymentStrategy.collectCredentials(email, password);
		if(!paymentStrategy.checkPaymentDetails()) {
			System.out.println("Credentials could not be processed!");
			System.exit(0);
		}
		
		paymentStrategy.pay();
	}
	
	public int getTotalAmount() {
		return includeDelivery?cost+10:cost;
	}

}
