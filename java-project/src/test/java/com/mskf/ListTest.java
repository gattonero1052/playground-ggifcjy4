package com.mskf;

import com.mskf.utils.Printer;
import org.junit.Test;

import static com.mskf.ListFunc.*;

public class ListTest {


    @Test
    public void createFromArray(){
        TestUtils.msg("Create List From Array...",
                Printer.print(ListFunc.createFromArray(samplePrimitiveArray()),false));
    }

    @Test
    public void createFromBoxedArray(){

        TestUtils.msg("Create List From Boxed Array...",
                Printer.print(ListFunc.createFromBoxedArray(sampleBoxedArray()),false));
    }

    @Test
    public void slice(){
        TestUtils.msg("Slice List From 1 to 3...",
                Printer.print(ListFunc.slice(sampleList(),1,3),false));
    }

    @Test
    public void sliceToEnd(){
        TestUtils.msg("Slice List From 1 to End...",
                Printer.print(ListFunc.sliceToEnd(sampleList(),1),false));
    }

    @Test
    public void sliceFromStart(){
        TestUtils.msg("Slice List From Beginning to 3...",
                Printer.print(ListFunc.sliceFromStart(sampleList(),3),false));
    }

    @Test
    public void max(){
        TestUtils.msg("Get max value from list...",
                Printer.print(ListFunc.max(sampleList()),false));
    }

    @Test
    public void distinctList(){
        TestUtils.msg("Get dictinct values from list...",
                Printer.print(ListFunc.distinctList(sampleList()),false));
    }

    @Test
    public void filterList(){
        TestUtils.msg("Filter postive values out of list...",
                Printer.print(ListFunc.filterList(sampleList()),false));
    }

    @Test
    public void sortArray(){
        TestUtils.msg("Sort Array...",
                Printer.print(ListFunc.sortArray(samplePrimitiveArray()),false));
    }

    @Test
    public void sortList(){
        TestUtils.msg("Sort List...",
                Printer.print(ListFunc.sortList(sampleList()),false));
    }

    @Test
    public void concatList(){
        TestUtils.msg("Concat List...",
                Printer.print(ListFunc.concatList(sampleList(),sampleList()),false));
    }
}
