package bankdeposits;

public class Account {

    private int balance = 0;

    public synchronized int getBalance(){
        return balance;
    }

    public synchronized void getAndDeposit(){
        synchronized (this){
            int amount = getBalance();
            balance = amount + 1;
        }

    }

}
