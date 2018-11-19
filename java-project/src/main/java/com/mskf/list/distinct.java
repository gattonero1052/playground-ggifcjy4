//{ autofold
package com.mskf.list;

import java.util.List;
import java.util.stream.Collectors;
@SuppressWarnings(value={"rawtypes","unchecked"})
public class distinct {
    public static List<Integer> distinctList(List<Integer> list){
//}
        return list.stream()
                .distinct()
                .collect(Collectors.toList());
//{ autofold
    }
}
//}