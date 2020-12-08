package aoc.week_one.day_five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DayFive {
    public int getHighestId(List<Seat> seats) {
        int highest = -1;

        for (Seat seat : seats) {
            if (seat.getId() > highest) highest = seat.getId();
        }

        return highest;
    }

    public int getMySeat(List<Seat> list) {
        Collections.sort(list);

        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).getId() + 1 != list.get(i+1).getId()) {
                return list.get(i).getId() + 1;
            }
        }

        return -1;
    }
}
