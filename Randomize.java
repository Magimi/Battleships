import java.util.concurrent.ThreadLocalRandom;
public class Randomize {


    public static int rint(double min, double max){
        int random = (int)ThreadLocalRandom.current().nextDouble(min, max + 1);

        return random;
    }
}