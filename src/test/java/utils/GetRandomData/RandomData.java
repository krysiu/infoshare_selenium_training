package utils.GetRandomData;

import java.util.Random;
import java.util.UUID;

public class RandomData {

    public static String firstName = UUID.randomUUID().toString().replace("-", "").substring(0,5);
    public static String lastName = UUID.randomUUID().toString().replace("-", "").substring(0,7);
    public static String address = UUID.randomUUID().toString().replace("-", "").substring(0,8);
    public static String city = UUID.randomUUID().toString().replace("-", "").substring(0,6);
    public static String telephone = UUID.randomUUID().toString().replaceAll("[^0-9]", "").substring(0, 9);


}
