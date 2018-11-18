//{ autofold
package com.mskf;

import com.mskf.utils.Printer;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mskf on 2018/11/18.
 */
@SuppressWarnings(value={"rawtypes","unchecked"})
public class ListFunc {
    //if you want to change inputs, for example, you can use "ArrayList<Integer> list = sampleList(3,4,5,6,7)" to get a new list.
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

    public static void main(String[] args) throws Exception{
        Integer[] res = Arrays.stream( new int[]{3,1,5,4}).boxed().toArray(Integer[]::new);

        Integer num[] = new Integer[]{3,1,5,4};
        ArrayList<Integer> list = new ArrayList(Arrays.asList(3,1,5,4));
//        Printer.print(list.stream().skip(1).limit(3-1).collect(Collectors.toList()));
//        new ArrayList<Integer>(num);
        List newList = list.stream()
                .sorted()
                .collect(Collectors.toList());

        ArrayList<Integer> anotherlist = new ArrayList<>(Arrays.asList(1,-3,-5,-4));
        Printer.print(Stream.concat(list.stream(),anotherlist.stream()).collect(Collectors.toList()));
        Printer.print(list);
    }


    public static List<Integer> createFromArray(int[] array){
//}
        return Arrays.stream(array)
                .boxed().collect(Collectors.toList());
        // You can get an ArrayList by: Arrays.stream(array).boxed().collect(Collectors.toCollection(ArrayList::new));
//{ autofold
    }
//}

    public static List<Integer> createFromBoxedArray(Integer...integers){
        return new ArrayList<>(Arrays.asList(integers));
        // Attention: Arrays.asList creates a list which you can not modify because its type is an inner type: java.util.Arrays$ArrayList
    }

    public static List<Integer> slice(List<Integer> list,int from,int to){
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

    public static Integer max(List<Integer> list){
        // stream way:
        // list.stream().max(Comparator.naturalOrder()).get();

        return Collections.max(list);
        // Collections.min works similarly
    }

    public static List<Integer> distinctList(List<Integer> list){
        return list.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Integer> filterList(List<Integer> list){
        return list.stream()
                .filter(i->i>0)
                .collect(Collectors.toList());
    }

    public static int[] sortArray(int[] array){
        int[] newArray = Arrays.copyOf(array,array.length);
        Arrays.sort(newArray);
        return newArray;
        // the in-place algo is much simpler
    }

    public static List<Integer> sortList(List<Integer> list){
        List<Integer> newList = new ArrayList(list);

        //in-place
        //Collections.sort(newList);

        //not in-place
        return newList.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<Integer> concatList(List<Integer> listA, List<Integer> listB){
        //in-place: listA.addAll(listB);

        //not in-place
        return Stream.concat(listA.stream(),listB.stream()).collect(Collectors.toList());
    }
}
