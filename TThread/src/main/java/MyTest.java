import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyTest {

    @Test
    public void t1() throws ExecutionException, InterruptedException {
        TicketRunnable t1=new TicketRunnable("售票员1");
        TicketRunnable t2=new TicketRunnable("售票员2");
        TicketRunnable t3=new TicketRunnable("售票员3");


        ExecutorService executorService= Executors.newFixedThreadPool(3);
        Future<?> submit = executorService.submit(t1);
        Future<?> submit1 = executorService.submit(t2);
        Future<?> submit2 = executorService.submit(t3);

        Object o = submit.get();
        Object o1 = submit1.get();
        Object o2 = submit2.get();

        executorService.shutdown();
    }

}
