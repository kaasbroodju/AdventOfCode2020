package aoc.week_one.day_three;

public class FlightRoute {
    private int stepX;
    private int stepY;

    public FlightRoute(int stepX, int stepY) {
        this.stepX = stepX;
        this.stepY = stepY;
    }

    public int getStepX() {
        return stepX;
    }

    public int getStepY() {
        return stepY;
    }
}
