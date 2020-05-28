package com.atguigu.factory.factorymethod.pizzastore.pizza;

import com.atguigu.factory.factorymethod.pizzastore.pizza.Pizza;

public class LDPepperPizza extends Pizza {

    @Override
    public void prepare() {
        setName("伦敦的胡椒pizza");
        System.out.println(" 伦敦的胡椒pizza 准备原材料 ");
    }
}
