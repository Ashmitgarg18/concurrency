package executorframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
//        Thread[] threads = new Thread[9];
        ExecutorService executor = Executors.newFixedThreadPool(9);
        for(int i = 1; i < 10; i++){
            int finalI = i;
            executor.submit(
                    () -> {
                        System.out.println(factorial(finalI));
                    }
            );
        }
        executor.shutdown();
//
//        for(Thread thread : threads){
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                thread.interrupt();
//            }
//        }

        try {
            while(!executor.awaitTermination(1, TimeUnit.SECONDS)){

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Total time taken: " + (System.currentTimeMillis() - startTime));
    }

    private static long factorial(int n){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long result = 1;
        for(int i = 1; i <= n; i++){
            result = result*i;
        }
        return result;
    }


}



//package executorframework;
//
//public class Main {
//    public static void main(String[] args) {
//        long startTime = System.currentTimeMillis();
//
//        for (int i = 1; i < 10; i++) {
//            System.out.println(factorial(i));
//        }
//
//        System.out.println("Total time taken: " + (System.currentTimeMillis() - startTime));
//    }
//
//    private static long factorial(int n) {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        long result = 1;
//        for (int i = 1; i <= n; i++) {
//            result = result * i;
//        }
//        return result;
//    }
//}
