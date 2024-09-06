package locks;

public class Main {
    public static void main(String[] args) {

        BankAccount icici = new BankAccount();

        Runnable withdraw = new Runnable() {
            @Override
            public void run() {
                icici.withdraw(50);
            }
        };

        Thread t1 = new Thread(withdraw, "User1");
        Thread t2 = new Thread(withdraw, "user2");

        t1.start();
        t2.start();



    }
}
