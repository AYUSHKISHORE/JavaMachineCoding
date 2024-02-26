package Banking;


public class Solution {
	
	public static void main(String[]args) {
	
		String[][] query = {
				{"CREATE_ACCOUNT","1","account1"},
				{"DEPOSIT","2","account1","500"},
				{"CREATE_ACCOUNT","3","account2"},
				{"DEPOSIT","4","account2","100"},
				{"TRANSFER","5","account1","account2","100"},
				{"TOP_SPENDERS","6","2"}
		};
		String[] result = BankingFunc(query);
		
		for(int i=0;i<result.length;i++) {
			System.out.println((i+1)+" = "+result[i]);
		}
	}
	
	public static String[] BankingFunc(String[][] queries) {
		Bank bank = new Bank();
		String result[] = new String[queries.length];
		for(int i=0;i<queries.length;i++) {
			if(queries[i][0].equals("CREATE_ACCOUNT")) {
				Account acc = new Account(queries[i][2],0);
				String res = bank.addAccount(acc);
				result[i]=res;
				
			}else if(queries[i][0].equals("DEPOSIT")) {
				String res = bank.deposit(queries[i][2], Long.parseLong(queries[i][3]));
				result[i]=res;
				
			}else if(queries[i][0].equals("TRANSFER")) {
				String res = bank.transfer(queries[i][2], queries[i][3],Long.parseLong(queries[i][4]));
				result[i]=res;
				
			}else if(queries[i][0].equals("TOP_SPENDERS")) {
				String res = bank.getTotalTransferedForAccount(Long.parseLong(queries[i][2]));
				result[i]=res;
			}
		}
		return result;
	}
		
}


// BELOW PART SHOULD BE PUT IN OTHER FILES FOR MODULARITY

//class Bank is operational class on how a bank operate
//class Bank{
//	public Map<String, Account> accounts;
//	public Bank() {
//		accounts = new HashMap<>();
//	}
//	
//	public String addAccount(Account account) {
//		if(!accounts.containsKey(account.getAccountId())) {
//			accounts.put(account.getAccountId(), account);
//			return "true";
//		}
//		return "false";
//	}
//	
//	public String deposit(String accountId, long amount) {
//		Account acc = accounts.get(accountId);
//		if(acc == null) {
//			return "";
//		}
//		return Long.toString(acc.deposit(amount));
//	}
//	
//	public String transfer(String source , String dest , long amt) {
//		//Source and Destination account is same so we can't transfer in same account
//		if(source.equals(dest)) {
//			return "";
//		}
//		Account sourceAcc = accounts.get(source);
//		Account destAcc = accounts.get(dest);
//		if(sourceAcc.getBalance()<amt) {
//			//Due to insufficient balance return blank string
//			return "";
//		}
//		if(sourceAcc!=null && destAcc!=null) {
//			long newBalance = sourceAcc.withDraw(amt);
//			destAcc.deposit(amt);
//			
//			return Long.toString(newBalance);
//		}
//		return "";
//	}
//	
//}




//class Account Defines all the function of Banking Account Related;
// class Account{
//
//	public String AccountId;
//	public long Balance;
//	public long TotalAmtTransferred;
//	
//	public Account(String AccountId, long Balance) {
//		this.AccountId = AccountId;
//		this.Balance = Balance;
//	}
//	
//	public String getAccountId() {
//		return AccountId;
//	}
//	
//	public long getBalance() {
//		return Balance;
//	}
//	
//	public long getTotalAmtTransferred() {
//		return TotalAmtTransferred;
//	}
//	
//	public void setBalance(long Balance) {
//		this.Balance = Balance;
//	}
//	
//	public long deposit(long amount) {
//		Balance+=amount;
//		return Balance;
//	}
//	
//	public long withDraw(long amount) {
//		if(amount<=Balance) {
//			Balance-=amount;
//			TotalAmtTransferred += amount;
//			return Balance;
//		}
//		return Balance;
//	}
//	
//}

