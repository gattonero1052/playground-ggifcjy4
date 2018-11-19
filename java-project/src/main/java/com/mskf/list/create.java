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
        //if you want to change inputs, for example, you can use "ArrayList<Integer> list = sampleList(3,4,5,6,7)" to get a new list.
        return Arrays.stream(array)
                .boxed().collect(Collectors.toList());
        // You can get an ArrayList by: Arrays.stream(array).boxed().collect(Collectors.toCollection(ArrayList::new));
    }

    public static List<Integer> createFromBoxedArray(Integer...integers){
        return new ArrayList<>(Arrays.asList(integers));
        // Attention: Arrays.asList creates a list which you can not modify because its type is an inner type: java.util.Arrays$ArrayList
    }
//{ autofold
}
//}