// Target interface
interface Target {
    void request();
}

// Adaptee (the class to be adapted)
class Adaptee {
    public void specificRequest() {
        System.out.println("Adaptee's specificRequest method called");
    }
}

// Class Adapter
class ClassAdapter extends Adaptee implements Target {
    @Override
    public void request() {
        specificRequest();
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        // Using the Target interface to interact with the Adaptee through the Adapter
        Target target = new ClassAdapter();
        target.request();
    }
}
