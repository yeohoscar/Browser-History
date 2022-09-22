import java.util.Iterator;
import java.util.Stack;

public class BrowserHistory {
    private final Stack<String> backHistory;
    private final Stack<String> foreHistory;

    public BrowserHistory(String homepage) {
        backHistory = new Stack<String>();
        foreHistory = new Stack<String>();
        backHistory.push(homepage);
        currentWebsite();
    }

    public void visit(String link) {
        foreHistory.clear();
        backHistory.push(link);
        System.out.println("You are currently in " + link);
    }

    public void back(int steps) {
        for (int i = 0; i < steps; i++) {
            if (backHistory.size() == 1) {
                break;
            }
            foreHistory.push(backHistory.pop());
        }
        currentWebsite();
    }

    public void forward(int steps) {
        for (int i = 0; i < steps; i++) {
            if (foreHistory.isEmpty()) {
                break;
            }
            backHistory.push(foreHistory.pop());
        }
        currentWebsite();
    }

    public void back() {
        if (backHistory.size() == 1) {
            System.out.println("No links behind");
            currentWebsite();
        }
        foreHistory.push(backHistory.pop());
        currentWebsite();
    }

    public void forward() {
        if (foreHistory.isEmpty()) {
            System.out.println("No links forward");
            currentWebsite();
        }
        backHistory.push(foreHistory.pop());
        currentWebsite();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String s : backHistory) {
            sb.append(s).append("\n");
        }
        return sb.toString();
    }

    private void currentWebsite() {
        System.out.println("You are currently in " + backHistory.peek());
    }
}
