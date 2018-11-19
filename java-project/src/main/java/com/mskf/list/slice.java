//{ autofold
package com.mskf.list;

import java.util.List;
import java.util.stream.Collectors;
@SuppressWarnings(value={"rawtypes","unchecked"})
public class slice {
//}
    public static List<Integer> slice(List<Integer> list, int from, int to){
//        list.stream().skip(from).limit(to-from).collect(Collectors.toList());
        return list.subList(from,to);
    }

    public static List<Integer> sliceToEnd(List<Integer> list,int from){
        return list.stream()
                .skip(from)
                .collect(Collectors.toList());
        // obviously, this also works: list.subList(from,list.size())
    }

    public static List<Integer> sliceFromStart(List<Integer> list,int to){
        return list.stream()
                .limit(to)
                .collect(Collectors.toList());
        // obviously, this also works: list.subList(0,to)
    }
//{ autofold
}
//}
