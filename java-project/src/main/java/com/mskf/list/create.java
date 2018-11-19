//{ autofold
package com.mskf.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings(value={"rawtypes","unchecked"})
public class create {
//}
    public static List<Integer> createFromArray(int[] array){
        return Arrays.stream(array)
                .boxed().collect(Collectors.toList());
    }

    public static List<Integer> createFromBoxedArray(Integer...integers){
        return new ArrayList<>(Arrays.asList(integers));
    }
//{ autofold
}
//}