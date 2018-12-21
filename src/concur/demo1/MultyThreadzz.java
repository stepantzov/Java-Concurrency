package concur.demo1;

public class MultyThreadzz {
    public static void main(String[] args) {
        Runner threadRunner = new Runner();
        threadRunner.start();

        Runner threadRunner2 = new Runner();
        threadRunner2.start();
    }
}
