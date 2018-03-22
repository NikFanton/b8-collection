package ua.training;

import java.util.*;

public class NumberOfRepeatsInArrayList {
    public static Map<Integer, Integer> calcRepeats(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : list) {
            if (map.keySet().contains(num)) {
                Integer oldValue = map.get(num);
                map.replace(num, oldValue, oldValue + 1);
            } else {
                map.put(num, 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 1, 2, 3, 5, 3, 2, 1, 9));
        System.out.println(calcRepeats(list));
    }
}
