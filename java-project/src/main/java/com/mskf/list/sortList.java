//{ autofold
package com.mskf.list;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings(value={"rawtypes","unchecked"})
public class sortList {
    public static List<Integer> sortList(List<Integer> list){
//}
        return list.stream()
                .sorted()
                .collect(Collectors.toList());
//{ autofold
    }
}
//}