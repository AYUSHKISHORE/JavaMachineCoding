package Banking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//class Bank is operational class on how a bank operate
public class Bank{
	public Map<String, Account> accounts;
	public Bank() {
		accounts = new HashMap<>();
	}
	
	public String addAccount(Account account) {
		if(!accounts.containsKey(account.getAccountId())) {
			accounts.put(account.getAccountId(), account);
			return "true";
		}
		return "false";
	}
	
	public String deposit(String accountId, long amount) {
		Account acc = accounts.get(accountId);
		if(acc == null) {
			return "";
		}
		return Long.toString(acc.deposit(amount));
	}
	
	public String transfer(String source , String dest , long amt) {
		//Source and Destination account is same so we can't transfer in same account
		if(source.equals(dest)) {
			return "";
		}
		Account sourceAcc = accounts.get(source);
		Account destAcc = accounts.get(dest);
		if(sourceAcc.getBalance()<amt) {
			//Due to insufficient balance return blank string
			return "";
		}
		if(sourceAcc!=null && destAcc!=null) {
			long newBalance = sourceAcc.withDraw(amt);
			destAcc.deposit(amt);
			
			return Long.toString(newBalance);
		}
		return "";
	}
	
	public String getTotalTransferedForAccount(long n) {
		List<Account> sortedAccount = new ArrayList<>(accounts.values());
		Collections.sort(sortedAccount, new Comparator<Account>(){
			public int compare(Account a1, Account a2) {
				int result = Long.compare(a2.getTotalAmtTransferred(), a1.getTotalAmtTransferred());
				//If result is 0 means both account has same Amount transferred then we sort based on accountId name
				if(result == 0) {
					return a1.getAccountId().compareTo(a2.getAccountId());
				}
				return result;
			}
		});
		
		long count = 0;
		//Using StringBuilder as String is immutable and is faster in any modifying operation
		StringBuilder sb = new StringBuilder();
		for(Account account: sortedAccount) {
			if(count>=n) {
				break;
			}
			sb.append(account.getAccountId()).append("(").append(account.getTotalAmtTransferred()).append("), ");
			count++;
			
		}
		if(sb.length()>0) {
			sb.setLength(sb.length()-2);
		}
		
		return sb.toString();
	}
	
}
