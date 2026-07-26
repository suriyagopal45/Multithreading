
class Thread1 implements Runnable
{

    @Override
    public void run() {
        for(int i=0;i<20;i++)
        {
            System.out.println("From Thread 1"+i);
        }
    }
}

class Thread2 implements Runnable
{

    @Override
    public void run() {
        for(int i=0;i<20;i++)
        {
            System.out.println("From Thread 2"+i);
        }

    }
}
public class Main
{
    static void main() throws InterruptedException {
        Thread t1 = new Thread(new Thread1());

        Thread t2 = new Thread(new Thread2());

        t1.start();
        t2.start();

        Thread three = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<50;i++)
                {
                    System.out.println(i);
                }
            }
        });  //using anonymous class


       Thread four =new Thread(() -> {
           for(int i=0;i<50;i++)
           {
               System.out.println(i);
           }

       });  //Replace with lambda






        System.out.println("Inbetween ");
        t1.join();
        t2.join();







    }
}