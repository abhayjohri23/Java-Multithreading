package stategyDesignPattern;

public class UpiPaymentMode implements PaymentMode {
	private String password;
	@Override
	public void collectCredentials(String email, String password) {
		// TODO Auto-generated method stub
		System.out.println("Password is already stored for the given email");
	}

	@Override
	public boolean checkPaymentDetails() {
		// TODO Auto-generated method stub
		System.out.println("Payment credentials have been processed and verified.");
		return true;
	}

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		int amount=100;
		double discount=0.1;
		System.out.println("Total Amount of the order is: "+amount*(1-discount));
	}
	

}
