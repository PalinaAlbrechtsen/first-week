package list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListMergerTest {

    @Test
    public void checkMerging() {
        List<Integer> first = new ArrayList<>();
        first.add(0, 1);
        first.add(1, 3);
        first.add(2, 5);
        List<Integer> second = new ArrayList<>();
        second.add(0, 2);
        second.add(1, 4);
        second.add(2, 6);
        List<Integer> third = new ArrayList<>();
        third.add(0, 2);
        third.add(1, 3);
        third.add(2, 4);
        third.add(3, 5);
        third.add(4, 6);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(first);
        lists.add(second);
        lists.add(third);

        List<Integer> finishHasToBe = new ArrayList<>();
        finishHasToBe.add(0, 1);
        finishHasToBe.add(1, 2);
        finishHasToBe.add(2, 2);
        finishHasToBe.add(3, 3);
        finishHasToBe.add(4, 3);
        finishHasToBe.add(5, 4);
        finishHasToBe.add(6, 4);
        finishHasToBe.add(7, 5);
        finishHasToBe.add(8, 5);
        finishHasToBe.add(9, 6);
        finishHasToBe.add(10, 6);

        ListMerger.mergeLists(first, second, third);
        assertEquals(3, second.size());
        assertEquals(5, third.size());
        assertEquals(11, first.size());
        assertEquals(finishHasToBe, first);
    }
}
