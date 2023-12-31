public class ChocolateBoiler {
    private boolean empty;
    private boolean boiled;
    private volatile static ChocolateBoiler uniqueInstance;

    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    public static ChocolateBoiler getInstance() {
        if (uniqueInstance == null) {
            synchronized (ChocolateBoiler.class) {
                if (uniqueInstance == null) {
                    System.out.println("Creating unique instance of Chocolate Boiler");
                    uniqueInstance = new ChocolateBoiler();
                }
            }
        }
        System.out.println("Returning instance of Chocolate Boiler");
        return uniqueInstance;
    }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
            System.out.println("Filled the chocolate boiler");
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            empty = true;
            System.out.println("Drained the boiled chocolate mixture");
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            boiled = true;
            System.out.println("Boiled the chocolate mixture");
        }
    }

    public void reportBoilerState() {
        System.out.println("State: empty[" + empty + "] " + "boiled[" + boiled + "]");
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
