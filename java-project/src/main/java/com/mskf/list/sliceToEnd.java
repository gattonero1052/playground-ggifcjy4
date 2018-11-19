//{ autofold
package com.mskf.list;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings(value={"rawtypes","unchecked"})
public class sliceToEnd {
    public static List<Integer> sliceToEnd(List<Integer> list,int from){
//}
        return list.stream()
                .skip(from)
                .collect(Collectors.toList());
//{ autofold
    }
}
//}
