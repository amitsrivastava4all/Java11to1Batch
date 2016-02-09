class Account
{
	void deposit(){
		System.out.println("This is Account Class Deposit");
	}
	void withDraw(){
		System.out.println("This is Account Class WithDraw");
	}
	void roi(){
		System.out.println("This is Account Class ROI");
	}
}
class SavingAccount extends Account
{
	@Override
void roi(){
		System.out.println("This is Saving Account ROI");
}
}
class CurrentAccount extends Account{
	@Override
void roi(){
		System.out.println("This is Current Account ROI");
}
	void odLimit(){
		System.out.println("Current Account OD Limit");
	}
}

class AccountCaller{
	
	static void callAccount(Account account){
		//Account account = new CurrentAccount(); //Upcasting
		account.deposit();
		account.withDraw();
		account.roi();
		if(account instanceof CurrentAccount){
		CurrentAccount ca = (CurrentAccount)account; // Downcasting
		ca.odLimit();
	}
		System.out.println("**********************************");
}
}

public class Demo1 {

	public static void main(String[] args) {
		
		AccountCaller.callAccount(new SavingAccount());
		AccountCaller.callAccount(new CurrentAccount());
		
		/*SavingAccount sa = new SavingAccount();
		sa.deposit();
		sa.withDraw();
		sa.roi();
		System.out.println("******************************");
		CurrentAccount ca = new CurrentAccount();
		ca.deposit();
		ca.withDraw();
		ca.roi();
		ca.odLimit();*/

	}

}
