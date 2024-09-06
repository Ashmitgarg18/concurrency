public class Test {
    public static void main(String[] args) {

        Counter counter = new Counter();
 
        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }
        catch (Exception e){
            System.out.println(e);
        }
        System.out.println(counter.getCount());

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };


        Runnable task1 = () -> System.out.println("Hello");

        Thread thread = new Thread(task);
        Thread thread1 = new Thread(task1);

        thread.start();
        thread1.start();

    }
}
