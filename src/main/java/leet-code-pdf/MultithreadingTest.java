public class MultithreadingTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(()->{
            System.out.println("Thread");
        });
        t.start();
        t.join();
        t.run();
        //t.start();
    }
}
