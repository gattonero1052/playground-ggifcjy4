//{ autofold
package com.mskf.list;

import java.util.Collections;
import java.util.List;
@SuppressWarnings(value={"rawtypes","unchecked"})
public class max {
    public static Integer max(List<Integer> list){
//}
        // stream way:
        // list.stream().max(Comparator.naturalOrder()).get();
        return Collections.max(list);
        // Collections.min works similarly
//{ autofold
    }
}
//}