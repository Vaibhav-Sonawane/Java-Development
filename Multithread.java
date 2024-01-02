class SharedResource {
    private int count = 0;
    private boolean isCountUpdated = false;

    synchronized void increment() {
        while (isCountUpdated) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        System.out.println("Incremented: " + count);
        isCountUpdated = true;
        notify(); // Notify other threads waiting to consume
    }

    // Method to consume count
    synchronized void consume() {
        while (!isCountUpdated) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumed: " + count);
        isCountUpdated = false;
        notify();
    }
}

class Producer implements Runnable {
    private SharedResource sharedResource;

    Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            sharedResource.increment();
        }
    }
}

class Consumer implements Runnable {
    private SharedResource sharedResource;

    Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            sharedResource.consume();
        }
    }
}

public class Multithread {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread producerThread = new Thread(new Producer(sharedResource));
        Thread consumerThread = new Thread(new Consumer(sharedResource));

        producerThread.start();
        consumerThread.start();
    }
}
