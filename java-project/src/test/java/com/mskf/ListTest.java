package com.mskf;

import com.mskf.list.*;
import com.mskf.utils.Printer;
import org.junit.Test;

import static com.mskf.utils.sampleData.*;

public class ListTest {
    @Test
    public void createFromArray(){
        TestUtils.result(Printer.print(createFromArray.createFromArray(samplePrimitiveArray()),false));
        TestUtils.hint("You can get an ArrayList by: Arrays.stream(array).boxed().collect(Collectors.toCollection(ArrayList::new))");
    }

    @Test
    public void createFromBoxedArray(){

        TestUtils.result(Printer.print(createFromBoxedArray.createFromBoxedArray(sampleBoxedArray()),false));

        TestUtils.hint("Arrays.asList creates a list which you can not modify because its type is an inner type: java.util.Arrays$ArrayList");
    }

    @Test
    public void slice(){
        TestUtils.result(Printer.print(slice.slice(sampleList(),1,3),false));
        TestUtils.hint("Stream way: list.stream().skip(from).limit(to-from).collect(Collectors.toList());");
    }

    @Test
    public void sliceToEnd(){
        TestUtils.result(Printer.print(sliceToEnd.sliceToEnd(sampleList(),1),false));
    }

    @Test
    public void sliceFromStart(){
        TestUtils.result(Printer.print(sliceFromStart.sliceFromStart(sampleList(),3),false));
    }

    @Test
    public void max(){
        TestUtils.result(Printer.print(max.max(sampleList()),false));
        TestUtils.hint("Stream way: list.stream().max(Comparator.naturalOrder()).get();");
    }

    @Test
    public void distinctList(){
        TestUtils.result(Printer.print(distinct.distinctList(sampleList()),false));
    }

    @Test
    public void filterList(){
        TestUtils.result(Printer.print(filter.filterList(sampleList()),false));
    }

    @Test
    public void sortArray(){
        TestUtils.result(Printer.print(sortArray.sortArray(samplePrimitiveArray()),false));

        TestUtils.hint("Arrays.sort is an in-place function");
    }

    @Test
    public void sortList(){
        TestUtils.result(Printer.print(sortList.sortList(sampleList()),false));
        TestUtils.hint("in-place: Collections.sort(list)");
    }

    @Test
    public void concatList(){
        TestUtils.result(Printer.print(concat.concatList(sampleList(),sampleList()),false));
        TestUtils.hint("in-place: listA.addAll(listB)");
    }

    @Test
    public void terminal(){
        TestUtils.terminal();
    }
}
