

public class TicketRunnable implements Runnable {
    private static  int  ticketCount=1000;
    public String name;
    private static final String TICKET_KEY = "ticket";

    @Override
    public  synchronized void run() {
        sellTicket();
    }

    public TicketRunnable(String name){
        this.name=name;
    }

    public synchronized void sellTicket()  {

            while (ticketCount>0){
                synchronized(TICKET_KEY){
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
}
