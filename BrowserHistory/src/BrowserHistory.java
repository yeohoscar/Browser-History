import java.util.Iterator;
import java.util.Stack;

public class BrowserHistory {
    private final Stack<String> backHistory;
    private final Stack<String> foreHistory;

    public BrowserHistory(String homepage) {
        backHistory = new Stack<String>();
        foreHistory = new Stack<String>();
        backHistory.push(homepage);
    }

    public void visit(String link) {

        foreHistory.clear();
        backHistory.push(link);
        System.out.println("You are currently in " + link);
    }

    public String back(int steps) {
        for (int i = 0; i < steps; i++) {
            if (backHistory.size() == 1) {
                break;
            }
            foreHistory.push(backHistory.pop());
        }
        return backHistory.peek();
    }

    public String forward(int steps) {
        for (int i = 0; i < steps; i++) {
            if (foreHistory.isEmpty()) {
                break;
            }
            backHistory.push(foreHistory.pop());
        }
        return backHistory.peek();
    }

    public String back() {
        if (backHistory.size() == 1) {
            System.out.println("No links behind");
            return backHistory.peek();
        }
        foreHistory.push(backHistory.pop());
        return backHistory.peek();
    }

    public String forward() {
        if (foreHistory.isEmpty()) {
            System.out.println("No links forward");
            return backHistory.peek();
        }
        backHistory.push(foreHistory.pop());
        return backHistory.peek();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String s : backHistory) {
            sb.append(s).append("\n");
        }
        return sb.toString();
    }
}
