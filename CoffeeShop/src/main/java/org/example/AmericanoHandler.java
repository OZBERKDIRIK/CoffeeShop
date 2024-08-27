package org.example;

public class AmericanoHandler extends CoffeeHandler {

    @Override
    public void handleRequest(int coffeeType)
    {
        if(coffeeType==3){
            prepareCoffee();
        }else{
            super.handleRequest(coffeeType);
        }
    }

    @Override
    protected  void prepareCoffee(){
        System.out.println("Americano seçtiniz. Bu içeceğimiz dört doz sıcak su ve bir doz espresso içermektedir. Afiyet Olsun.");
    }
}
