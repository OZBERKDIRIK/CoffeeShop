package org.example;

public abstract class CoffeeHandler {
    protected CoffeeHandler nextHandler;

    public void setNextHandler(CoffeeHandler nextHandler){
        this.nextHandler=nextHandler;
    }

    public void handlerRequest(int coffeeType){
        if(nextHandler != null){
            nextHandler.handlerRequest(coffeeType);
        }
    }
    protected abstract void prepareCoffee();
}
