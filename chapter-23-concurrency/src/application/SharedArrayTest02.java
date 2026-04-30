package application;
// Fig 23.7: SharedArrayTest.java
// Executing two Runnables to add elements to a shared SimpleArray.
import entities.ArrayWriter02;
import entities.SimpleArray02;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class SharedArrayTest02
{
   public static void main(String[] arg)
   {
      // construct the shared object
      SimpleArray02 sharedSimpleArray02 = new SimpleArray02(6);

      // create two tasks to write to the shared SimpleArray
      ArrayWriter02 writer1 = new ArrayWriter02(1, sharedSimpleArray02);
      ArrayWriter02 writer2 = new ArrayWriter02(11, sharedSimpleArray02);

      // execute the tasks with an ExecutorService
      ExecutorService executorService = Executors.newCachedThreadPool();
      executorService.execute(writer1);
      executorService.execute(writer2);

      executorService.shutdown();

      try {
         // wait 1 minute for both writers to finish executing
         boolean tasksEnded = 
            executorService.awaitTermination(1, TimeUnit.MINUTES);

         if (tasksEnded)
         {
            System.out.printf("%nContents of SimpleArray:%n");
            System.out.println(sharedSimpleArray02); // print contents
         }
         else
            System.out.println(
               "Timed out while waiting for tasks to finish.");
      } catch (InterruptedException ex) {
         System.out.println(
            "Interrupted while waiting for tasks to finish.");
      } 
   } // end main
} // end class SharedArrayTest
