package me.leig.study.bean;

import org.springframework.stereotype.Component;

/**
 * @title: MathCalculator
 * @description:
 * @author: leig
 * @create: 2020-04-06 22:11
 **/
@Component
public class MathCalculator {

    public int div(int i, int j) {
        System.out.println("MathCalculator...div");
        return i / j;
    }
}
