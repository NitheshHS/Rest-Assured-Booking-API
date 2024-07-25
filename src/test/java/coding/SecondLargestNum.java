package coding;

import io.cucumber.java.sl.In;

import java.util.*;
import java.util.stream.Collectors;

public class SecondLargestNum {
    public static void main(String[] args) {
        Integer[] arr={5,10,10,11,55,1,54};//[5,10,10] //
        List<Integer> list=Arrays.asList(arr);

        System.out.println(secondLargestNum(list));
    }

    static int secondLargestNum(List<Integer> list){
        list=list.stream().parallel().distinct().sorted().collect(Collectors.toList());
        return list.get(list.size()-2);
    }
}
