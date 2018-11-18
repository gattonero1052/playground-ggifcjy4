package com.mskf;

import com.mskf.utils.Printer;
import org.junit.Test;

public class ListTest {
    @Test
    public void test(){
        int num[] = new int[]{3,1,5,4};
        TestUtils.msg("Running ListFunc.create({3,1,5,4})...", Printer.print(ListFunc.create(num),false));
    }

//    @Test
//    public void create2(){
//        int num[] = new int[]{3,1,5,4};
//        TestUtils.msg("Running ListFunc.create({3,1,5,4})...", Printer.print(ListFunc.create(num),false));
//    }
}
