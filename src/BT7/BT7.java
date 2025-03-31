package BT7;

import java.util.List;

public class BT7 {
    public static void main(String[] args) {
        String filename = "data.txt";

        FileHandler.writeSampleData(filename);

        List<Country> countries = FileHandler.readCountriesFromFile(filename);

        System.out.println("Danh sách quốc gia:");
        for (Country country : countries) {
            System.out.println(country);
        }
    }
}
