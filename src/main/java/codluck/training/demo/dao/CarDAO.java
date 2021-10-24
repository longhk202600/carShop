package codluck.training.demo.dao;

public class CarDAO {

    public static final String sout ="/newCar";

    public static String getPrice(int priceFrom, int priceTo) {
        String result = "";

        if (priceFrom < 1000) {
            result = priceFrom + "  Triệu";
        } else {
            String s1 = String.valueOf(priceFrom);
            String temp = s1.substring(0, s1.length() - 3);
            result = temp + " Tỷ " + s1.substring(s1.length() - 3, s1.length())+ " Triệu";
        }
        if (priceTo < 1000) {
            result += " -"+priceTo + "  Triệu";
        } else {
            String s2 = String.valueOf(priceTo);
            String temp = s2.substring(0, s2.length() - 3);
            result +="  -  "+ temp + " Tỷ " + s2.substring(s2.length() - 3, s2.length())+" Triệu";
        }
        System.out.println(result);
        return result;
    }

}
