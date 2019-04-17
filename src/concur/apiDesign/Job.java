//attention to the thread state;

package concur.apiDesign;

import java.util.ArrayList;
import java.util.List;

public class Job {
    private boolean running = false;
    private final String filename;

    public Job(String filename) {
        this.filename = filename;
    }

    public synchronized void start() {
        if (running) {
            throw new IllegalStateException("...");
        }
        /*...*/
    }

    public synchronized List getResults() {
        if (!running) {
            throw new IllegalStateException("...");
        }
        /*...*/
        List returnList = new ArrayList();
        return returnList;
    }
}