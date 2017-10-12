
package asenkron;

class Timer
{
 private long startTime = 0, endTime = 0;

 public void start() 
 {
  this.startTime = System.currentTimeMillis();
 }

 public void end() 
 {
  this.endTime = System.currentTimeMillis();
 }

 public long getStartTime() 
 {
  return this.startTime;
 }

 public long getEndTime() 
 {
  return this.endTime;
 }

 public long getTotalTimeInMillis() 
 {
  return this.endTime - this.startTime;
 }

 public double getTotalTimeInSec() 
 {
     
  return ((double) (this.endTime - this.startTime)) / 1000;
  
 }
 
}

public class Asenkron {
             private int count = 0;
             private int timer = 0;
             Timer t = new Timer();
             Timer m = new Timer();
             
    public static void main(String[] args) {
        Asenkron application = new Asenkron();
        application.doCount();
    }
    
    
    private void doCount() 
     {
        Thread thread1 = new Thread(new Runnable() {
           
            @Override
            public void run() 
            {
                int [] sayilar = {100,200,300}; 
         t.start();
                for (int i = 0; i < sayilar.length ; i++) { //sayılar dizisinin değeri tek tek sayi değişkenine atanıyor
         t.end();
                System.out.print(sayilar[i]+" ");//Yan yana yazdırmak için .println yerine .print kullandık
        
      
            }
               
      }
        });

        Thread thread2 = new Thread(new Runnable() {
        
            @Override
            public void run() 
            {
                int [] sayilar = {100,200,300,400};
         m.start();
                for (int sayi : sayilar) { //sayılar dizisinin değeri tek tek sayi değişkenine atanıyor
                System.out.print(sayi+" ");
       
         m.end();
                }
            }
        }); 
        thread1.start();
        thread2.start();
  try
     {
        thread1.join();
        thread2.join();
     } 
 
  catch (InterruptedException e) 
     {
         
     }

     ///System.out.println("Thread 1 Sayaç: " + timer);
     ///System.out.println("Thread 2 Sayaç: " + count);
     
     System.out.println("Thread1:"+t.getTotalTimeInSec()); 
     
     System.out.println("Thread2:"+m.getTotalTimeInSec()); 
    
    
     
    }
    
}
