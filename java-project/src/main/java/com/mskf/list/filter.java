//{ autofold
package com.mskf.list;

import java.util.List;
import java.util.stream.Collectors;
@SuppressWarnings(value={"rawtypes","unchecked"})
public class filter {
    public static List<Integer> filterList(List<Integer> list){
//}
        return list.stream()
                .filter(i->i>0)
                .collect(Collectors.toList());
//{ autofold
    }
}
//}