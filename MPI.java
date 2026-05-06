import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MPI
{
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        AtomicInteger sum = new AtomicInteger(0);
        int numThreads = 2;
        Thread[] threads = new Thread[numThreads];

        for (int t = 0; t < numThreads; t++) {
            final int threadId = t;
            threads[t] = new Thread(() -> {
                int localSum = 0;
                for (int i = threadId; i < n; i += numThreads) {
                    localSum += arr[i];
                }
                System.out.println("Thread " + threadId + " partial sum = " + localSum);
                sum.addAndGet(localSum);
            });
            threads[t].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Final Sum = " + sum.get());
        scanner.close();
    }
}