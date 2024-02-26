package Banking;

public class Account{

	public String AccountId;
	public long Balance;
	public long TotalAmtTransferred;
	
	public Account(String AccountId, long Balance) {
		this.AccountId = AccountId;
		this.Balance = Balance;
	}
	
	public String getAccountId() {
		return AccountId;
	}
	
	public long getBalance() {
		return Balance;
	}
	
	public long getTotalAmtTransferred() {
		return TotalAmtTransferred;
	}
	
	public void setBalance(long Balance) {
		this.Balance = Balance;
	}
	
	public long deposit(long amount) {
		Balance+=amount;
		return Balance;
	}
	
	public long withDraw(long amount) {
		if(amount<=Balance) {
			Balance-=amount;
			TotalAmtTransferred += amount;
			return Balance;
		}
		return Balance;
	}
	
}