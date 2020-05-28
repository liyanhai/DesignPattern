package com.atguigu.factory.absfactory.pizzastore.order;

import com.atguigu.factory.absfactory.pizzastore.pizza.Pizza;

public interface AbsFactory {

    Pizza createPizza(String orderType);

}
