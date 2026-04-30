package entities;
// Fig. 23.6: ArrayWriter.java
// Adds integers to an array shared with other Runnables
import java.lang.Runnable;

public class ArrayWriter01 implements Runnable {
   private final SimpleArray01 sharedSimpleArray01;
   private final int startValue;

   public ArrayWriter01(int value, SimpleArray01 array) {
      startValue = value;
      sharedSimpleArray01 = array;
   }

   public void run() {
      for (int i = startValue; i < startValue + 3; i++)
      {
         sharedSimpleArray01.add(i); // add an element to the shared array
      } 
   }
} // end class ArrayWriter

