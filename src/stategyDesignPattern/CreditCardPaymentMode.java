package stategyDesignPattern;

public class CreditCardPaymentMode implements PaymentMode{
	private String email;
	private String password;
	
	@Override
	public void collectCredentials(String email, String password) {
		// TODO Auto-generated method stub
		this.email=email;
		this.password=password;
		System.out.println("email for the account is: "+email+" with password XXXXX"+password.substring(password.length()-2));
	}

	@Override
	public boolean checkPaymentDetails() {
		// TODO Auto-generated method stub
		String encryptPassword="xyzpassword";
		return encryptPassword.equals(this.password);
	}

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		System.out.println("Payment has been done!");
	}

}
