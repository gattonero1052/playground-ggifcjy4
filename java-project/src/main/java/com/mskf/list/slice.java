//{ autofold
package com.mskf.list;

import java.util.List;
import java.util.stream.Collectors;
@SuppressWarnings(value={"rawtypes","unchecked"})
public class slice {
//}
    public static List<Integer> slice(List<Integer> list, int from, int to){
        return list.subList(from,to);
    }

    public static List<Integer> sliceToEnd(List<Integer> list,int from){
        return list.stream()
                .skip(from)
                .collect(Collectors.toList());
    }

    public static List<Integer> sliceFromStart(List<Integer> list,int to){
        return list.stream()
                .limit(to)
                .collect(Collectors.toList());
    }
//{ autofold
}
//}
