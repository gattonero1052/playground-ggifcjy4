//{ autofold
package com.mskf.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@SuppressWarnings(value={"rawtypes","unchecked"})
public class sort {
//}
    public static int[] sortArray(int[] array){
        int[] newArray = Arrays.copyOf(array,array.length);
        Arrays.sort(newArray);
        return newArray;
        // the in-place algo is much simpler
    }

    public static List<Integer> sortList(List<Integer> list){
        List<Integer> newList = new ArrayList(list);

        //in-place
        //Collections.sort(newList);

        //not in-place
        return newList.stream()
                .sorted()
                .collect(Collectors.toList());
    }
//{ autofold
}
//}