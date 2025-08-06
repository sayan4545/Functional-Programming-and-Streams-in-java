package com.dev.reactive.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo02 {
    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5,6,7,8,9};
        // print the nums greater than 5 only

//        List<Integer> listOfFilterredNums = Arrays.stream(nums)
//                .filter(x->x>5)
//                .toList();
//        System.out.println(listOfFilterredNums);

        for(Integer n : nums){
            if(n%2==0) System.out.print(n+" ");
        }
        System.out.println();
        Arrays.stream(nums).filter(x->x%2==0).forEach(System.out::println);
    }
}
