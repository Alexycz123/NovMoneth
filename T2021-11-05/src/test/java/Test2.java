import org.junit.Test;

import java.util.HashSet;

public class Test2 {
    @Test
    public void t2(){


        int count=0;
        for (int i=1;i<5;i++){
            for (int j=1;j<5;j++){
                for (int k=1;k<5;k++){
                    if (i!=j && j!=k && i!=k){
                        count+=1;
                        System.out.println(i*100+j*10+k);
                    }

                }
            }
        }
        System.out.println(count);
    }
}
