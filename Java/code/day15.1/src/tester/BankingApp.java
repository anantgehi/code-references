package tester;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import com.app.banking.AccountType;
import com.app.banking.BankAccount;

import custom_exception.BankingException;

import static utils.CollectionUtils.populateMap;
import static java.time.LocalDate.parse;
import static com.app.banking.AccountType.*;
import static utils.CollectionUtils.findByAccountNo;

public class BankingApp {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			
			// init phase
			// create suitable D.S
			HashMap<Integer, BankAccount> accounts = populateMap();
			
			boolean exit = false;
			while (!exit) {
				
				System.out.println("Options 1. Create A/C 2. Display 3. Get A/C Summary "
						+ "4. Transfer Funds 5. Close A/C 6. Display all account details of specific account type "
						+ "7.Display all account details of having entered minimum balance 8. Remove all loan accounts10.Exit");
				try {
					switch (sc.nextInt()) {
					
						case 1:
						System.out.println("Enter acct no");
						int acctNo = sc.nextInt();
						
						if (accounts.containsKey(acctNo))
							throw new BankingException("Dup acct no !!!!!");
						
						// => acct no new
						System.out.println("Enter a/c details :   acType,  balance,  creationDate(yr-mon-day) customerName");
						accounts.put(acctNo, new BankAccount(acctNo, valueOf(sc.next().toUpperCase()), sc.nextDouble(), parse(sc.next()), sc.next()));
						System.out.println("A/C created....");
						
						break;
					case 2:
						System.out.println("All A/C Details");
						for (BankAccount a : accounts.values())
							System.out.println(a);

						break;
					case 3:
						System.out.println("Enter A/C no , to get summary");
						System.out.println(findByAccountNo(sc.nextInt(), accounts));

						break;
							
					case 4: // Funds Transfer
						
						System.out.println("Enter src dest acct nos n amount to transfer");
						BankAccount src = findByAccountNo(sc.nextInt(), accounts);
						BankAccount dest = findByAccountNo(sc.nextInt(), accounts);

						// => src n dest a/c exist
						
						src.transferFunds(dest, sc.nextDouble());
						System.out.println("funds transferred....");
						break;
							
					case 5: // close a/c
						
						System.out.println("Enter a/c no to close a/c");
						
						src = accounts.remove(sc.nextInt());
						
						if (src == null)
							throw new BankingException("A/C Closing Failed : Invalid a/c no!!!!!");
						
						System.out.println("Closed a/c details " + src);
						break;
							
					case 6: // display based upon value based criteria - account type
						
						System.out.println("Enter a/c type");
						AccountType type = valueOf(sc.next().toUpperCase());
						System.out.println("A/cs of type " + type);
						for (BankAccount a : accounts.values())
							if (a.getAcType() == type)
								System.out.println(a);

						break;
							
					case 7: // display based upon value based criteria - min balance
						
						System.out.println("Enter amount");
						double bal = sc.nextDouble();
						System.out.println("A/cs having minimum bal" + bal);
						for (BankAccount a : accounts.values())
							if (a.getBalance() >= bal)
								System.out.println(a);

						break;

					case 8: // remove loan accounts
						
						Iterator<BankAccount> itr = accounts.values().iterator();
						//Collection<BankAccount> collection=accounts.values();
						System.out.println("removing loan accounts");
					//	for(BankAccount a : collection) //for each is implicit itr : raises ConcurrentModificationExc
					//	if(a.getAcType()==LOAN)
					//	collection.remove(a);//if we try to use remove other than iterators remove method it throws concurrentmodexc
						while (itr.hasNext()) {
							if (itr.next().getAcType() == LOAN)
								itr.remove();//using this we are removing reference from collection as well as entry from map

						}
					// Think it over : ConcurrentModoficationException , When u use
					// values/keySet/entrySet , Colleciton is backed by the Map n vice versa.Any changes is collection will reflect on map

						break;

					case 10:
						exit = true;
						break;
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				sc.nextLine();
			}

		}

	}

}
