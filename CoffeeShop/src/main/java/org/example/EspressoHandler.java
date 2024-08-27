package org.example;

public class EspressoHandler extends CoffeeHandler{

    @Override
    public void handleRequest(int coffeeType){
        if(coffeeType==1){
            prepareCoffee();
        }else{
            super.handleRequest(coffeeType);
        }
    }

    @Override
    protected void prepareCoffee(){
        System.out.println("Espresso seçtiniz. Bu içeceğimiz bir doz espresso içermektedir. Afiyet Olsun.");
    }
}
