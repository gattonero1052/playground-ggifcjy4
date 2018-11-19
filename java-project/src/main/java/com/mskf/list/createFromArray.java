//{ autofold
package com.mskf.list;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings(value={"rawtypes","unchecked"})
public class createFromArray {
//}
    public static List<Integer> createFromArray(int[] array){
        return Arrays.stream(array)
                .boxed().collect(Collectors.toList());
//{ autofold
    }
}
//}