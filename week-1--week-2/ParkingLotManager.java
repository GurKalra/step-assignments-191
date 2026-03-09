import java.util.*;

public class ParkingLotManager {

    static String[] parking = new String[500];

    public static int parkVehicle(String plate) {

        int index = Math.abs(plate.hashCode()) % 500;

        while (parking[index] != null) {
            index = (index + 1) % 500;
        }

        parking[index] = plate;
        return index;
    }

    public static void exitVehicle(String plate) {

        for (int i = 0; i < parking.length; i++) {
            if (plate.equals(parking[i])) {
                parking[i] = null;
                System.out.println(plate + " exited from spot " + i);
                return;
            }
        }
    }

    public static void main(String[] args) {

        int spot = parkVehicle("ABC-1234");
        System.out.println("Assigned spot #" + spot);

        exitVehicle("ABC-1234");
    }
}