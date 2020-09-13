package random;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {
    public static int NumberBetween(int start, int end){
        return ThreadLocalRandom.current().nextInt(start, end);
    }
}
