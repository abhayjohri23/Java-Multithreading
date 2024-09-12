package stategyDesignPattern;

public interface PaymentMode {
	public void collectCredentials(String email,String password);
	public boolean checkPaymentDetails();
	public void pay();
}
