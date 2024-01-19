public class Singleton {
    private static Singleton instance = null;
    private static final Object obj = new Object();

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (obj) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
