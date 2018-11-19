package com.mskf.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class sampleData {
    public static int[] samplePrimitiveArray(Integer...integers){
        if(integers.length==0)
            return new int[]{3,1,5,4,1,-2};

        int[] array = new int[integers.length];

        for (int i = 0; i < integers.length; i++) {
            array[i] = integers[i];
        }

        return array;
    }

    public static Integer[] sampleBoxedArray(Integer...integers){
        return Arrays.stream(samplePrimitiveArray(integers)).boxed().toArray(Integer[]::new);
    }

    public static ArrayList<Integer> sampleList(Integer...integers){
        return Arrays.stream(samplePrimitiveArray(integers)).boxed().collect(Collectors.toCollection(ArrayList::new));
    }
}
