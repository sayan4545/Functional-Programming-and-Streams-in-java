package com.dev.reactive.lambdas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.*;
import java.util.stream.Collectors;

public class Test {
    private static final Logger log = LoggerFactory.getLogger(Test.class);
    public static void main(String[] args) {
        MathOperation sum = Integer::sum;
        MathOperation prod = (a,b)-> a*b;
        log.info("The result of the operation is : {}",sum.operate(1,4));
        log.info("The result of the operation is : {}",prod.operate(2,3));

        MathOperation.printCall();
        List<Integer> list = List.of(1,2,3,4);
        Predicate<Integer> isEven = x -> x%2==0;

        log.info("The result is : {}",isEven.test(4));
        log.info("The result is : {}",isEven.test(17));

        // To test if a string starts with A :

        Predicate<String> isStartswith = a-> a.startsWith("A");
        Predicate<String> isEndsWith = a-> a.toLowerCase().endsWith("T");
        Predicate<String> andOperation = isStartswith.and(isEndsWith);

        //Boolean a = isStartswith.and(x->x.endsWith("T".toLowerCase())).test("Ankit");

        log.info("Starts with A : {}",isStartswith.test("abvxcfg"));
        log.info("The result of the operation is : {}",andOperation.test("Ankit"));

        Function<String,Integer> stringLengthCheck = a-> a.length();
        log.info("The value of the function is: {}",stringLengthCheck.apply("Abhishek"));

        Consumer<List<Integer>> printList = x->{
            x.forEach(System.out::println);
        };

        printList.accept(List.of(2,3,4,5));
        Supplier<String> giveHelloWorld = ()-> "Hello World";
        log.info("Supplies the given string: {}",giveHelloWorld.get());

        Predicate<Integer> test1 = x->x%2==0;
        Function<Integer,Integer> fun = x -> x*2;
        Consumer<Integer> con = x-> log.info("Consumed {}",x);
        Supplier<Integer> sup = ()->18;
        log.info("Testing all the functions simultaneously");
        if(test1.test(sup.get())) con.accept(fun.apply(sup.get()));

        BiConsumer<String,Integer> biCon = (x,y)-> y=x.length()+y;
        BiFunction<Integer,String,Integer> biFun = (a,b) -> a+b.length();
        biFun.apply(5,"chandrika");

        List<String> listAsPhone = Arrays.asList("A","B","C");
        List<MobilePhone> mobiles = listAsPhone.stream()
                .map(MobilePhone::new).toList();

        Consumer<List<MobilePhone>> conn = m -> {
            m.forEach(System.out::println);
        };

        conn.accept(mobiles);



    }
    static class MobilePhone{
        String name;
        public MobilePhone(String name){
            this.name = name;
        }
        @Override
        public String toString(){
            return this.name+" ";
        }
    }
}
