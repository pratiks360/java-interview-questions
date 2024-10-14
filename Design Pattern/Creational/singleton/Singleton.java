package Creational.singleton;

class Singleton {
    private static Singleton instance;

    private Singleton() {
        // Private constructor prevents instantiation from other classes
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();  // Lazy initialization
        }
        return instance;
    }


}

