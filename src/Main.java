public class Main {
    public static void main(String[] args) {
        World world = new World();
        new Thread(world).start();
        for(int i = 0; i< 100000; i++){
            System.out.println(Thread.currentThread().getName());
        }
    }
}