package com.mskf;

import com.mskf.list.*;
import com.mskf.utils.Printer;
import org.junit.Test;

import static com.mskf.utils.sampleData.*;

public class ListTest {


    @Test
    public void createFromArray(){
        TestUtils.msg("Create List From Array...",
                Printer.print(create.createFromArray(samplePrimitiveArray()),false));
    }

    @Test
    public void createFromBoxedArray(){

        TestUtils.msg("Create List From Boxed Array...",
                Printer.print(create.createFromBoxedArray(sampleBoxedArray()),false));
    }

    @Test
    public void slice(){
        TestUtils.msg("Slice List From 1 to 3...",
                Printer.print(slice.slice(sampleList(),1,3),false));
    }

    @Test
    public void sliceToEnd(){
        TestUtils.msg("Slice List From 1 to End...",
                Printer.print(slice.sliceToEnd(sampleList(),1),false));
    }

    @Test
    public void sliceFromStart(){
        TestUtils.msg("Slice List From Start to 3...",
                Printer.print(slice.sliceFromStart(sampleList(),3),false));
    }

    @Test
    public void max(){
        TestUtils.msg("Get max value from list...",
                Printer.print(max.max(sampleList()),false));
    }

    @Test
    public void distinctList(){
        TestUtils.msg("Get dictinct values from list...",
                Printer.print(distinct.distinctList(sampleList()),false));
    }

    @Test
    public void filterList(){
        TestUtils.msg("Filter postive values out of list...",
                Printer.print(filter.filterList(sampleList()),false));
    }

    @Test
    public void sortArray(){
        TestUtils.msg("Sort Array...",
                Printer.print(sort.sortArray(samplePrimitiveArray()),false));
    }

    @Test
    public void sortList(){
        TestUtils.msg("Sort List...",
                Printer.print(sort.sortList(sampleList()),false));
    }

    @Test
    public void concatList(){
        TestUtils.msg("Concat List...",
                Printer.print(concat.concatList(sampleList(),sampleList()),false));
    }
}
