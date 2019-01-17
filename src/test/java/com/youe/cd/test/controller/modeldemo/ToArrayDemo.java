package com.youe.cd.test.controller.modeldemo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ToArrayDemo {
    public static void main(String[] args) {
        Set<String> testSet = new HashSet<String>();
        testSet.add("Jim");
        testSet.add("Lily");
        testSet.add("Lucy");

        System.out.println(testSet);
        testSet.remove("Lucy");
        System.out.println(testSet);
        testSet.add("Poly");
        System.out.println(testSet);


        System.out.println("####################");
        /*Iterator<String> it = testSet.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }*/
        for(String set:testSet) {
            System.out.println(set);
        }

        //定义一个list, 用于set转array(数组)
        String[] testArray = new String[testSet.size()];  //必须加数组维，通过set的size获取
        testSet.toArray(testArray); //将set转换成list, 并直接存于已定义好的数组testArray变量中

        System.out.println("####################");
        for(String list:testArray){
            System.out.println(list);
        }

        System.out.println("####################");
        System.out.println(testArray[0]);

    }

}
