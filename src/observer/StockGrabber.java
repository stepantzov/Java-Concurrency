package observer;

import java.util.ArrayList;

public class StockGrabber implements Subject {
    private ArrayList<Observer> observers;
    private double ibmPrice;
    private double googlePrice;
    private double applePrice;

    public StockGrabber() {
        observers = new ArrayList<>();
    }

    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unregister(Observer deleteObserver) {
        int observerIndex = observers.indexOf(deleteObserver);
        System.out.printf("Observer" + (observerIndex + 1) + "deleted");

        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(ibmPrice, googlePrice, applePrice);
        }
    }

    public void setIbmPrice(double newIbmPrice) {
        this.ibmPrice = newIbmPrice;

        notifyObserver();
    }

    public void setApplePrice(double newApplePrice) {
        this.applePrice = newApplePrice;

        notifyObserver();
    }

    public void setGooglePrice(double newGooglePrice) {
        this.googlePrice = newGooglePrice;

        notifyObserver();
    }
}
