public class FunctionalInterfaces8 {

    @FunctionalInterface
    interface ABC {
        void show();

    }

    public static void main(String ... args){

        ABC a = () -> System.out.println("hello from functional interface");
        a.show();
    }

}
