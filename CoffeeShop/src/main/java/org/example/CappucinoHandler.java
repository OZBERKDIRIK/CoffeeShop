package org.example;

public class CappucinoHandler extends CoffeeHandler {

    @Override
    public void handleRequest(int coffeeType){
        if(coffeeType==4){
            prepareCoffee();
        }else{
            super.handleRequest(coffeeType);
        }
    }
    protected void prepareCoffee() {
        System.out.println("Cappucino seçtiniz. Bu içeceğimiz 1 doz Espresso 2 doz süt ve 2 doz süt köpüğü içerir");
    }
}
