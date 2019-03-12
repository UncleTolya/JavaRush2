package com.javarush.task.task35.task3506;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
/* 
Wildcards
*/
public class Solution {

//    public static <D, H extends D, S extends H> void add(List<D> destinationList, List<S> sourceList) {
//        ListIterator<D> destListIterator = destinationList.listIterator();
//        ListIterator<S> srcListIterator = sourceList.listIterator();
//        for (int i = 0; i < sourceList.size(); i++) {
//            destListIterator.add(srcListIterator.next());
//        }
//    }

    public static <D> void add(List<? super D> destinationList, List<? extends D> sourceList) {
        ListIterator<? super D> destListIterator = destinationList.listIterator();
        ListIterator<? extends D> srcListIterator = sourceList.listIterator();
        for (int i = 0; i < sourceList.size(); i++) {
            destListIterator.add(srcListIterator.next());
        }
    }


    public static void main(String[] args) {
        List<B> destination = new ArrayList<>();
        destination.add(new B());
        List<C> source = new ArrayList<>();
        source.add(new C());
        add(destination, source);
        System.out.println(destination);
        System.out.println(source);

        /*
[com.javarush.tests.level39.lesson08.task01.Solution$C@203b4f0e, com.javarush.tests.level39.lesson08.task01.Solution$B@15c330aa]
[com.javarush.tests.level39.lesson08.task01.Solution$C@203b4f0e]
         */
    }

    static class A {
    }

    static class B extends A {
    }

    static class C extends B {
    }
}
