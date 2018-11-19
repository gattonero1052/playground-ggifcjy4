//{ autofold
package com.mskf.list;

import java.util.Arrays;
@SuppressWarnings(value={"rawtypes","unchecked"})
public class sortArray {
    public static int[] sortArray(int[] array){
//}
        int[] newArray = Arrays.copyOf(array,array.length);
        Arrays.sort(newArray);
        return newArray;
//{ autofold
    }
}
//}