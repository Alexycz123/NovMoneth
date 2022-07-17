import java.util.concurrent.*;

public class TicketThread implements Callable {

    private static  int  ticketCount=100;
    public String name;
    private static final String TICKET_KEY = "ticket";
    @Override
    public synchronized Object call() throws Exception {
        sellTicket();
        return null;
    }

    public TicketThread(String name){
        this.name=name;
    }


    public synchronized void sellTicket() throws InterruptedException {
        while (true){
            synchronized (TICKET_KEY){
                //            Thread.sleep(100);
                if (ticketCount>0){
                    System.out.println(this.name+"剩余"+ticketCount--);
                }else {
                    System.out.println(this.name+"卖完了");
                    break;
                }
            }

        }

    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TicketThread t1=new TicketThread("售票员1");
        TicketThread t2=new TicketThread("售票员2");
        TicketThread t3=new TicketThread("售票员3");
        ExecutorService executorService= Executors.newFixedThreadPool(3);

        Future future1=executorService.submit(t1);
        Future future2=executorService.submit(t2);
        Future future3=executorService.submit(t3);

        Object o = future1.get();
        Object o1 = future2.get();
        Object o2 = future3.get();

        System.out.println(o);
        System.out.println(o1);
        System.out.println(o2);
        executorService.shutdown();
    }

}
