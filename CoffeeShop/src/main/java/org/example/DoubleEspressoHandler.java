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
        System.out.println("Double Espresso seçtiniz. Bu içeceğimiz iki doz espresso içermektedir. Afiyet Olsun.");
    }
}
