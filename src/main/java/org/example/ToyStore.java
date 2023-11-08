package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore {
    private List<Toy> toysList = new ArrayList<>();

    public void listAllToys() {
        System.out.println("Список всех игрушек:");
        for (Toy toy : toysList) {
            System.out.println("id: " + toy.getId() + ", Наименование: " + toy.getName() +
                    ", кол-во: " + toy.getQuantity() + ", Шанс выпадения: " + toy.getWeight() + "%");
        }
    }

    public void addNewToy(int id, String name, int quantity, double weight) {
        Toy newToy = new Toy(id, name, quantity, weight);
        toysList.add(newToy);
    }

    public void changeWeight(int toyId, double newWeight) {
        for (Toy toy : toysList) {
            if (toy.getId() == toyId) {
                toy.setWeight(newWeight);
                break;
            }
        }
    }

    public Toy selectToy() {
        double random = new Random().nextDouble() * 100;
        double cumulativeWeight = 0.0;
        for (Toy toy : toysList) {
            cumulativeWeight += toy.getWeight();
            if (random < cumulativeWeight) {
                return toy;
            }
        }
        return null;
    }

    public void distributePrize() {
        Toy selectedToy = selectToy();
        if (selectedToy != null && selectedToy.getQuantity() > 0) {
            selectedToy.quantity -= 1;
            toysList.remove(selectedToy);
            saveToTextFile(selectedToy);
        }
    }

    private void saveToTextFile(Toy toy) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("drop.txt", true))) {
            writer.write("Ваш выигрыш: " + toy.getName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}