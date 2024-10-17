public class FunctionalInterfaces8 {

    public static void main(String... args) {

        ABC a = () -> System.out.println("hello from functional interface");
        a.show();
    }

    @FunctionalInterface
    interface ABC {
        void show();

    }

}
