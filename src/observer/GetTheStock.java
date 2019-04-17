package observer;

import java.text.DecimalFormat;

public class GetTheStock implements Runnable {
    private int startTime;
    private String stock;
    private double price;

    private Subject stockGrabber;

    public GetTheStock(Subject newStockGrabber, int newStartTime, String newStock, double newPrice) {
        this.stockGrabber = newStockGrabber;
        startTime = newStartTime;
        stock = newStock;
        price = newPrice;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            double random = (Math.random() * (.06) - .03);
            DecimalFormat decimalFormat = new DecimalFormat("#.##");

            price = Double.valueOf(decimalFormat.format(price + random));

            if (stock == "IBM") ((StockGrabber) stockGrabber).setIbmPrice(price);
            if (stock == "Apple") ((StockGrabber) stockGrabber).setApplePrice(price);
            if (stock == "Google") ((StockGrabber) stockGrabber).setGooglePrice(price);

            System.out.println(stock + ": " + decimalFormat.format((price + random)) + " " + decimalFormat.format(random));
            System.out.println();
        }
    }
}