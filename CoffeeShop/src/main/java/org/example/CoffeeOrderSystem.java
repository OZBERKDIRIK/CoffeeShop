package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeOrderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            CoffeeFactory.listCoffees();
            int coffeeType = -1;
            boolean validInput = false;

            while (!validInput) {
                System.out.println("Lütfen içmek istediğiniz kahvenin numarasını giriniz (Çıkmak için 0 girin):");
                try {
                    coffeeType = scanner.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Geçersiz giriş. Lütfen bir tam sayı giriniz.");
                    scanner.next();
                }
            }
            if(coffeeType==0){
                System.out.println("Başka bir tecihiniz yok çıkış yapılıyor .... ");
                break;
            }

            CoffeeRecipe coffee = CoffeeFactory.getCoffee(coffeeType);

            if (coffee != null) {
                coffee.prepare();
            } else {
                System.out.println("Geçersiz kahve seçimi. Lütfen geçerli bir numara giriniz.");
            }
        }
    }
}
