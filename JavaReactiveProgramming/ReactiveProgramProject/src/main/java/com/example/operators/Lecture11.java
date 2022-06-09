package com.example.operators;

import com.example.utility.OrderService;
import com.example.utility.UserService;
import com.example.utility.Util;

public class Lecture11 {
    //working with flatmap
    public static void main(String[] args) throws InterruptedException {
        UserService.getUsers()
                //used to subscribe to different publisher, extra data, flatten the data, and give to the pipleline
                .flatMap(user -> OrderService.getOrders(user.getUserId()))
                .subscribe(Util.onNext());
        Util.sleepSec(10);
    }
}
