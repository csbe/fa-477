package ifa.example.threads;

public class Banking {

	private float amount;
	public static int failed = 0;
	
	public Banking(float amount){
		this.amount = amount;
	}
	
	public void amount(float saldi){
		amount+=saldi;
	}
	
	public boolean deposit(float saldi){
		if(amount-saldi > 0){
			amount-=saldi;
			return true;
		}
		failed++;
		return false;
	}
	
	public float getAmount(){
		return amount;
	}
	
}
