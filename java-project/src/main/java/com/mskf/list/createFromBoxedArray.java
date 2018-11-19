//{ autofold
package com.mskf.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings(value={"rawtypes","unchecked"})
public class createFromBoxedArray {
    public static List<Integer> createFromBoxedArray(Integer...integers){
//}
        return new ArrayList<>(Arrays.asList(integers));
//{ autofold
    }
}
//}