package com.dev.reactive.streams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamDemo01 {

    private static final Logger log = LoggerFactory.getLogger(StreamDemo01.class);

    public static void main(String[] args) {
        Supplier<String> supplier = ()->"hello Stream!";
        Stream<String> infiniteStream = Stream.generate(supplier).limit(10);
//        List<String> listOfStream = infiniteStream.toList();
//        log.info("The generated stream is : {}",listOfStream);
//        System.out.println(listOfStream);

        infiniteStream.limit(2).forEach(x->log.info("The value is : {}",x));

        Stream<Integer> finiteStream = Stream.of(1,2,3,4,5,6);
        //finiteStream.forEach(x->log.info("The value is :{}",x));
        //Stream<Integer> mappedStream = finiteStream.map(x->x*2);
        Stream<Integer> filterredStream = finiteStream.filter(x->x%2==0);

        List<Integer> filterredList = filterredStream.toList();
        //List<Integer> mappedList = mappedStream.toList();
        //log.info("The mapped list is : {}",mappedList);
        log.info("The filterred list is : {}",filterredList);
    }
}
