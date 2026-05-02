package application;
// Fig 23.15: BlockingBufferTest.java
// Two threads manipulating a blocking buffer that properly 
// implements the producer/consumer relationship.
import entities.BlockingBuffer;
import entities.Consumer02;
import entities.Producer02;
import interfaces.Buffer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BlockingBufferTest
{
   public static void main(String[] args) throws InterruptedException
   {
      // create new thread pool with two threads
      ExecutorService executorService = Executors.newCachedThreadPool();

      // create BlockingBuffer to store ints
      Buffer sharedLocation = new BlockingBuffer();

      executorService.execute(new Producer02(sharedLocation));
      executorService.execute(new Consumer02(sharedLocation));

      executorService.shutdown();
      executorService.awaitTermination(1, TimeUnit.MINUTES); 
   } 
} // end class BlockingBufferTest
