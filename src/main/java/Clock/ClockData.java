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
public class ClockData {
    private int hours;
    private int minutes;
    private int seconds;
    
    public ClockData() { this.hours = 0; this.minutes = 0; this.seconds = 0; }
    public ClockData(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHours() {
        return hours;
    }

    public void addHours(int hours) {
        this.hours = hours;
        if (this.hours >= 24) {
            this.hours %= 24;
        }
    }

    public int getMinutes() {
        return minutes;
    }

    public void addMinutes(int minutes) {
        this.minutes += minutes;
        while (this.minutes >= 60) {
            this.addHours(1);
            this.minutes -= 60;
        }
    }

    public int getSeconds() {
        return seconds;
    }

    public void addSeconds(int seconds) {
        this.seconds += seconds;
        while (this.seconds >= 60) {
            this.addMinutes(1);
            this.seconds -= 60;
        }
    }
    
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d",
                this.hours, this.minutes, this.seconds);
    }
}
