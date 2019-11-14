/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clock;

/**
 *
 * @author jpolanco
 */
public class Clock {
    protected ClockData data;
    private Counter c_seconds;
    private ClockCallback callback;
    public Clock(ClockData data) {
        this.data = data;
        this.StartupClock();
    }
    public Clock() {
        this.data = new ClockData();
        this.StartupClock();
    }
    
    private void StartupClock() {
        this.c_seconds = new Counter(CounterSets.COUNTER_SECONDS, () -> {
            if (callback != null) {
                callback.ClockCallback(this.data);
            }
            this.data.addSeconds(1);
        });
        this.c_seconds.start();
    }
    
    public void setClockCallback(ClockCallback callback) {
        this.callback = callback;
    }

    /**
     * @return the data
     */
    public ClockData getData() {
        return data;
    }
    
}
