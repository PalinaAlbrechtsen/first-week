package list;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ListMerger {

    @SuppressWarnings("unchecked")
    public static void mergeLists(List<Integer>... listz) {
        List<List<Integer>> sourceList = Arrays.asList(listz);
        List<List<Integer>> lists = new ArrayList<>();
        for (List<Integer> list : listz) {
            lists.add((List) ((ArrayList) list).clone());
        }

        int totalSize = 0;
        for (List<Integer> list : lists) {
            totalSize += list.size();
        }

        List<Integer> resultList = new ArrayList<>(totalSize);
        List<Integer> smaller;
        while (resultList.size() < totalSize) {
            smaller = null;
            for (List<Integer> list : lists) {
                if (!list.isEmpty()) {
                    if (smaller == null) {
                        smaller = list;
                    } else if (list.get(0).compareTo(smaller.get(0)) <= 0) {
                        smaller = list;
                    }
                }
            }
            if (smaller != null) {
                resultList.add(smaller.get(0));
                smaller.remove(0);
            }
        }

        sourceList.get(0).clear();
        sourceList.get(0).addAll(resultList);
    }
}
