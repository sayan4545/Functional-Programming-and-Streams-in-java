package com.dev.reactive.lambdas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FunctionalInterface
public interface MathOperation {
    public static final Logger log = LoggerFactory.getLogger(MathOperation.class);
    int operate(int x, int y);

    static void printCall(){
        log.info("Default methodn is called");
        //System.out.println("default method is called");
    }

}
