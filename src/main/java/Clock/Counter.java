/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clock;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jpolanco
 */
public class Counter extends Thread {
    private final CounterCallback callback;
    private final CounterSets type;
    public Counter(CounterSets type, CounterCallback callback) {
        this.callback = callback;
        this.type = type;
    }
    
    @Override
    public void run() {
        super.run();
        long sleep_time = getSecondsSleepByType();
        while(true) {
            try {
                this.callback.CounterCallback();
                sleep(sleep_time);
            } catch (InterruptedException ex) {
                Logger.getLogger(Counter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private long getSecondsSleepByType() {
        switch (this.type) {
            case COUNTER_SECONDS: return 1000;
            case COUNTER_MINUTES: return 60000;
            case COUNTER_HOURS:   return 3600000;
        }
        return 0;
    }
}
