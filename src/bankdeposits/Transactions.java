package bankdeposits;

public class Transactions {

    public static void main(String[] args) {

        Account account = new Account();

        TestThread t1 = new TestThread(account);
        TestThread t2 = new TestThread(account);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }
        catch (Exception e){
            System.out.println(e);
        }
        System.out.println(account.getBalance());
    }

}
