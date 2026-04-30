package application;
// Fig 23.7: SharedArrayTest.java
// Executing two Runnables to add elements to a shared SimpleArray.
import entities.ArrayWriter01;
import entities.SimpleArray01;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class SharedArrayTest01 {
   public static void main(String[] arg) {
      // construct the shared object
      SimpleArray01 sharedSimpleArray01 = new SimpleArray01(6);

      // create two tasks to write to the shared SimpleArray
      ArrayWriter01 writer1 = new ArrayWriter01(1, sharedSimpleArray01);
      ArrayWriter01 writer2 = new ArrayWriter01(11, sharedSimpleArray01);

      // execute the tasks with an ExecutorService
      ExecutorService executorService = Executors.newCachedThreadPool();
      executorService.execute(writer1);
      executorService.execute(writer2);

      executorService.shutdown();

      try
      {
         // wait 1 minute for both writers to finish executing
         boolean tasksEnded = 
            executorService.awaitTermination(1, TimeUnit.MINUTES);

         if (tasksEnded)
         {
            System.out.printf("%nContents of SimpleArray:%n");
            System.out.println(sharedSimpleArray01); // print contents
         }
         else
            System.out.println(
               "Timed out while waiting for tasks to finish.");
      } 
      catch (InterruptedException ex)
      {
         ex.printStackTrace();
      } 
   } // end main
} // end class SharedArrayTest
