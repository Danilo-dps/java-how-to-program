package application;
// Fig. 23.13: SharedBufferTest.java
// Application with two threads manipulating an unsynchronized buffer.
import entities.Consumer01;
import entities.Producer01;
import entities.UnsynchronizedBuffer;
import interfaces.Buffer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedBufferTest {
   public static void main(String[] args) throws InterruptedException {
      // create new thread pool with two threads
      ExecutorService executorService = Executors.newCachedThreadPool();

      // create UnsynchronizedBuffer to store ints       
      Buffer sharedLocation = new UnsynchronizedBuffer();

      System.out.println(
         "Action\t\tValue\tSum of Produced\tSum of Consumed");
      System.out.printf(
         "------\t\t-----\t---------------\t---------------%n%n");

      // execute the Producer and Consumer, giving each 
      // access to the sharedLocation
      executorService.execute(new Producer01(sharedLocation));
      executorService.execute(new Consumer01(sharedLocation));

      executorService.shutdown(); // terminate app when tasks complete
      executorService.awaitTermination(1, TimeUnit.MINUTES); 
   } // end main
} // end class SharedBufferTest
