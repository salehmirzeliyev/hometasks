package ZeroEvenOdd;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class ZeroEvenOdd {
    private int n;

    public ZeroEvenOdd(int n){
        this.n=n;
    }

    public synchronized void zero() throws InterruptedException{
        IntStream.range(1, n+1).forEach(i -> System.out.println("0"));

    }

    public void even() {
        IntStream.range(1, n+1).forEach(i ->
        {
            if (i%2 == 0){
                System.out.println(i);
            }
        });
    }

    public void odd(){
        IntStream.range(1, n+1).forEach(i ->
        {
            if (i%2 == 1){
                System.out.println(i);
            }
        });
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> zeroEvenOdd.even()).start();
        new Thread(() -> zeroEvenOdd.odd()).start();

    }
}
