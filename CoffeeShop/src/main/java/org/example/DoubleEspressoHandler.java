package org.example;

public class DoubleEspressoHandler extends CoffeeHandler {

    @Override
    public void handleRequest(int coffeeType){
        if(coffeeType==2){
            prepareCoffee();
        }else{
            super.handleRequest(coffeeType);
        }
    }

    @Override
    protected void prepareCoffee() {

    }
}
