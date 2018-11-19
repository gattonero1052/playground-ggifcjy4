//{ autofold
package com.mskf.list;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings(value={"rawtypes","unchecked"})
public class concat {
    public static List<Integer> concatList(List<Integer> listA, List<Integer> listB){
//}
        //in-place: listA.addAll(listB);

        //not in-place
        return Stream.concat(listA.stream(),listB.stream()).collect(Collectors.toList());
//{ autofold
    }
}
//}