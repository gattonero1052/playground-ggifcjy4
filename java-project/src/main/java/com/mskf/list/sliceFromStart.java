//{ autofold
package com.mskf.list;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings(value={"rawtypes","unchecked"})
public class sliceFromStart {

    public static List<Integer> sliceFromStart(List<Integer> list,int to){
//}
        return list.stream()
                .limit(to)
                .collect(Collectors.toList());
//{ autofold
    }
}
//}
