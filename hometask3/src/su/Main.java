package su;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WaterGenerator su = new WaterGenerator();

        Thread t1 = new Thread(() -> {
            try {
                su.hidrogenGenerator();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                su.hidrogenGenerator();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                su.oksigenGenerator();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
