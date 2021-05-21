package hometask1;

public class ThreadSpawner {
    private final int MAX_THREADS;
    private int threadCount = 0;
    private Object LOCK = new Object();

    ThreadSpawner(int numOfThread) {
        this.MAX_THREADS = numOfThread;
    }

    protected synchronized void addThread(){
        this.threadCount++;
    }

    protected synchronized void removeThread(){
        this.threadCount--;
    }

    public void spawn(final String str, boolean debug) throws InterruptedException{
        synchronized (LOCK) {
            while (this.threadCount == MAX_THREADS){
//                if (debug){
//                    System.out.println("WAIT" ,
//                    Thread.activeCount(), this.threadCount, this.MAX_THREADS);
//                }
                LOCK.wait();
            }
        }
        this.addThread();
        new Thread(() -> {
//            if (debug){
//                System.out.println("count",
//                Thread.currentThread().getName(), Thread.activeCount(), this.threadCount, str.split(" ").length);
//            } else {
//                System.out.println(Thread.currentThread().getName()+" -> "+str.split(" ").length);
//            }
            this.removeThread();
            synchronized (LOCK){
                LOCK.notify();
            }
        }).start();
    }
}
