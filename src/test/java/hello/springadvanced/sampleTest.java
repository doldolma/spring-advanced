package hello.springadvanced;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class sampleTest {

    @Test
    void test() {
        long start = System.currentTimeMillis();

        BigInteger result = new BigInteger("1");
        for(int i=2; i<=100000; i++){
            result.multiply(new BigInteger(String.valueOf(i)));
        }
        long end = System.currentTimeMillis();
        System.out.println("time = " + (end - start));
    }
}
