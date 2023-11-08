package org.example;

public class Main {
    public static void main(String[] args) {
        ToyStore store = new ToyStore();
        store.addNewToy(1, "Робот", 10, 20);
        store.addNewToy(2, "Кукла", 15, 30);
        store.addNewToy(3, "Машинка", 20, 50);

        store.changeWeight(1, 25);

        store.distributePrize();
        store.distributePrize();
        store.distributePrize();
        store.distributePrize();
        System.out.println("Призы разыграны! Смотрите что вам выпало в файле drop.txt");
    }
}
