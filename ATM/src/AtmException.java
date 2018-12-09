import java.util.Date;
import java.util.Scanner;
//import java.text.SimpleDateFormat;


public class AtmException extends Exception {
	double balance = 0.0;
	// date is of type Date
	Date date;
	int count = 0;

	// constructor
	public AtmException() {
	}

	// parameterized constructor
	public AtmException(String str) {
		super(str);
	}

	// function to assign date and time of transaction
	public void AssignDate() {
		// Creates date object representing current date and time.
		date = new Date();
	}

	// function for withdraw money
	public void withdraw(int bal) {
		balance = balance - bal;
		count++;
	}

	// function for deposit money
	public void deposit(double bal) {
		balance = balance + bal;
		count++;
	}

	// function for returning balance
	public double checkBalance() {
		return balance;
	}

	// function for display Information of last transaction
	// and current balance
	public void display() {
		System.out.println("Info of last transaction :");
		// formatter for define the format of displaying date and time
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println(formatter.format(date));
		System.out.println("balance : " + balance);
	}

	
	public static void main(String arg[]) {
		// object of AtmException class
		AtmException e = new AtmException();
		// money in ATM is 10000 (assume)
		int AtmMoney = 10000;
		// pin is 1111 (assume)
		int pin = 1111;
		System.out.println("Welcome to ATM");
		System.out.println("please enter your 4 digit pin");

		Scanner input = new Scanner(System.in);
		int enterPin = input.nextInt();
		// take pin as input from user till user provide the correct pin
		// if user provide incorrect pin generate exception
		while (enterPin != 1111) {
			// try catch statement to generate exception if pin is incorrect
			try {
				enterPin = input.nextInt();
				if (enterPin != pin) {
					AtmException me = new AtmException("Invalid Pin\n");
					throw me;
				}
			} catch (AtmException me) {
				me.printStackTrace();
			}

		}
		int value = 1;
		// switch case statement for providing options to the user
		while (value != 5) {
			System.out.println("1.Withdraw money");
			System.out.println("2.Diposit money");
			System.out.println("3.Check balance");
			System.out.println("4.Last transaction Info");
			System.out.println("5. exit");
			// if user choose option other than (1-5) then
			// generate exception of invalid option
			try {
				value = input.nextInt();
				if (value < 1 || value > 5) {
					AtmException me = new AtmException("Invalid option\n");
					throw me;
				}
			} catch (AtmException me) {
				me.printStackTrace();
			}
			switch (value) {
			// case 1 for withdraw money
			case 1:
				System.out.println("Enter money you want to withdraw :");
				// if money entered by user is less than 0
				// generate exception of invalid amount
				try {
					int money = input.nextInt();
					if (money < 0) {
						AtmException me = new AtmException("Invalid amount\n");
						throw me;
					}
					// If number of inter-bank transactions exceeds 3 throw exception
					if (e.count > 3) {
						AtmException me = new AtmException("number of inter-bank transactions exceeds 3\n");
						throw me;
					}
					// If money entered by user is not a multiple of 100, 500 or 2000 generate
					// exception
					if (money % 100 != 0 && money % 500 != 0 && money % 2000 != 0) {
						AtmException me = new AtmException("money is not multiple of 100,500 and 1000\n");
						throw me;
					}
					// if money entered by user is greater than current balance
					// then throw exception of insufficient balance
					double currBal = e.checkBalance();
					if (currBal < money) {
						AtmException me = new AtmException("Insufficient balance exception\n");
						throw me;
					}
					// if money entered by user is greater than current ATM balance
					// then throw exception
					if (money > AtmMoney) {
						AtmException me = new AtmException("sufficient amount is not available in ATM\n");
						throw me;
					}
					e.withdraw(money);
					e.AssignDate();
				} catch (AtmException me) {
					me.printStackTrace();
				}
				break;
			// case 2 for depositing money
			case 2:
				System.out.println("Enter money you want to deposit :");
				try {
					double bal = input.nextDouble();
					// if money entered by user is less than 0
					// generate exception of invalid amount
					if (bal < 0) {
						AtmException me = new AtmException("Invalid amount\n");
						throw me;
					}
					// If number of inter-bank transactions exceeds 3 throw exception
					if (e.count > 3) {
						AtmException me = new AtmException("number of inter-bank transactions exceeds 3\n");
						throw me;
					}
					e.deposit(bal);
					e.AssignDate();
				} catch (AtmException me) {
					me.printStackTrace();
				}
				break;
			// case 3 for checking balance
			case 3:
				System.out.println("your current balance is : " + e.checkBalance());
				break;
			// case 4 for displaying last transaction
			case 4:
				e.display();
				break;
			// case 5 for exit
			case 5:
				value = 5;
			}
		}
		input.close();
	}
}

	
	
	
