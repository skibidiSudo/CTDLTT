//package Hw5_23001908_VuQuangNam.ex5;
//
//import java.util.Date;
//import java.util.Random;
//
//public class TestSystem {
//    private static final long BOUND = 1000000000;
//    public static void main(String[] args) {
//        test();
//    }
//
//    public static void test() {
//        Random random = new Random();
//        OperatingSystem operatingSystem = new OperatingSystem();
//        int numberOfEvent = random.nextInt(20) * 2;
//        Date takeoffTime, landingTime;
//        long landingOffset;
//        int idCounter = 1;
//
//        for (int i = 0; i < numberOfEvent; i += 2) {
//            takeoffTime = new Date(System.currentTimeMillis() + random.nextLong(BOUND));
//            landingOffset = 60 * random.nextLong(BOUND / 1000);
//            landingTime = new Date(takeoffTime.getTime() + landingOffset);
//
//            String id = String.format("%03d", idCounter);
//            operatingSystem.addEvents(new Event<>(takeoffTime, "take off " + id));
//            operatingSystem.addEvents(new Event<>(landingTime, "landing " + id));
//            idCounter++;
//        }
//
//        for (int i = 0; i < numberOfEvent; i++) {
//            System.out.println(operatingSystem.upcomingEvent());
//        }
//    }
//}
