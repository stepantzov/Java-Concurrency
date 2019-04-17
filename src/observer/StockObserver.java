package observer;

public class StockObserver implements Observer {
    private double ibmPrice;
    private double googlePrice;
    private double applePrice;

    private static int observerIdTracker = 0;
    private int observerId;
    private Subject stockGrabber;

    public StockObserver(Subject stockGrabber) {
        this.stockGrabber = stockGrabber;

        this.observerId = ++observerIdTracker;
        System.out.println("New Observer " + this.observerId);
        stockGrabber.register(this);
    }

    @Override
    public void update(double ibmPrice, double gogglePrice, double applePrice) {
        this.ibmPrice = ibmPrice;
        this.applePrice = applePrice;
        this.googlePrice = gogglePrice;

        printThePrices();
    }

    private void printThePrices() {
        System.out.println(observerId + "\nIBM: " + ibmPrice + "\nApple: " + applePrice + "\nGoogle: " + googlePrice + "\n");
    }
}