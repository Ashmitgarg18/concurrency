package bankdeposits;

public class TestThread extends Thread {

    private Account account;

    public TestThread(Account account){
        this.account = account;
    }

    @Override
    public void run() {
        for(int i = 0; i < 500000; i++){
            account.getAndDeposit();
        }
    }
}