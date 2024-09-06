import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<Integer> callable1 = () -> {
            System.out.println("Task 1");
            return 1;
        };
        Callable<Integer> callable2 = () -> {
            System.out.println("Task 2");
            return 2;
        };
        Callable<Integer> callable3 = () -> {
            System.out.println("Task 3");
            return 3;
        };

        List<Callable<Integer>> callableList = Arrays.asList(callable1, callable2, callable3);
        List<Future<Integer>> futures = executor.invokeAll(callableList);
        for(Future<Integer> future : futures){
            System.out.println(future.get());
        }
        executor.shutdown();

    }
}
