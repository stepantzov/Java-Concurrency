package observer;

public class GrabStock {
    public static void main(String[] args) {
        StockGrabber stockGrabber = new StockGrabber();
        StockObserver stockObserver1 = new StockObserver(stockGrabber);

        stockGrabber.setApplePrice(1113.00);
        stockGrabber.setGooglePrice(1333.55);
        stockGrabber.setIbmPrice(0.00);

        StockObserver stockObserver2 = new StockObserver(stockGrabber);
        stockGrabber.setApplePrice(55.55);
        stockGrabber.setGooglePrice(66.66);
        stockGrabber.setIbmPrice(1.00);

        Runnable getIbm= new GetTheStock(stockGrabber, 2, "IBM", 231.02);
        Runnable getGoogle= new GetTheStock(stockGrabber, 2, "Google", 231.02);
        Runnable getApple= new GetTheStock(stockGrabber, 2, "Apple", 231.02);
    }
}
