public class Main {
    public static void main(String[] args) {
        BrowserHistory bh = new BrowserHistory("www.google.com");

        bh.visit("www.facebook.com");
        bh.visit("www.youtube.com");
        bh.visit("www.twitter.com");
        bh.back();
        bh.back(2);
        bh.forward(3);
    }
}
