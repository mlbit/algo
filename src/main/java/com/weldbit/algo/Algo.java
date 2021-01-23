package com.weldbit.algo;

import org.joda.time.LocalTime;
import com.weldbit.algo.stack.Stack;

public class Algo {
    public static void main(String[] args) {
        LocalTime currentTime = new LocalTime();
        Stack<Integer> message = new Stack<Integer>();
        message.push(1);
        message.push(2);
        message.push(3);
        message.push(4);
        System.out.println("Message Size." + message.size());

        while (message.size() > 0) {
            System.out.println("Message no." + message.pop());
        }
        Greeter greeter = new Greeter();
        System.out.println(greeter.sayHello());
    }
}