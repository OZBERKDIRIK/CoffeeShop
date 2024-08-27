package org.example;

public abstract class CoffeeHandler {
    protected CoffeeHandler nextHandler;

    public void setNextHandler(CoffeeHandler nextHandler){
        this.nextHandler=nextHandler;
    }

    public void handleRequest(int coffeeType){
        if(nextHandler != null){
            nextHandler.handleRequest(coffeeType);
        }
    }
    protected abstract void prepareCoffee();
}
