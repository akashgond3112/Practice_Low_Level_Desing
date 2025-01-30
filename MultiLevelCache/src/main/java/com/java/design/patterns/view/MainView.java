package com.java.design.patterns.view;

import com.java.design.patterns.services.MultiLevelCache;

import java.util.Scanner;
import java.util.List;

public class MainView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Read the number of layers
            System.out.println("Enter the number of cache layers:");
            int numLayers = Integer.parseInt(scanner.nextLine());

            // Read capacities for each layer
            System.out.println("Enter the capacities of each layer (space-separated):");
            String[] capacitiesInput = scanner.nextLine().split(" ");
            String[] capacities = new String[numLayers];
			System.arraycopy(capacitiesInput, 0, capacities, 0, numLayers);

            // Read read times for each layer
            System.out.println("Enter the read times for each layer (space-separated):");
            String[] readTimesInput = scanner.nextLine().split(" ");
            String[] readTimes = new String[numLayers];
			System.arraycopy(readTimesInput, 0, readTimes, 0, numLayers);

            // Read write times for each layer
            System.out.println("Enter the write times for each layer (space-separated):");
            String[] writeTimesInput = scanner.nextLine().split(" ");
            String[] writeTimes = new String[numLayers];
			System.arraycopy(writeTimesInput, 0, writeTimes, 0, numLayers);

            // Initialize the MultiLevelCache
            MultiLevelCache mlcache = new MultiLevelCache(numLayers);
            for (int i = 0; i < numLayers; i++) {
                mlcache.addLayer(capacities[i], readTimes[i], writeTimes[i], i + 1);
            }

            // Start command loop
            while (true) {
                System.out.println("Enter a command (WRITE key / READ key / CACHESIZE / EXIT):");
                String command = scanner.nextLine();
                String[] commands = command.split(" ");
                String commandType = commands[0].toUpperCase();

                switch (commandType) {
                case "WRITE" -> {
                    if (commands.length < 2) {
                        System.out.println("Invalid WRITE command. Usage: WRITE key");
                    } else {
                        String key = commands[1];
                        System.out.println("Write Time is: " + mlcache.write(key));
                    }
                }
                case "READ" -> {
                    if (commands.length < 2) {
                        System.out.println("Invalid READ command. Usage: READ key");
                    } else {
                        String key = commands[1];
                        System.out.println("Read Time is: " + mlcache.read(key));
                    }
                }
                case "CACHESIZE" -> {
                    System.out.println("Cache Size for Each Layer is:");
                    List<Integer> cacheSizes = mlcache.getCacheSize();
                    for (int i = 0; i < cacheSizes.size(); i++) {
                        System.out.println("Layer " + (i + 1) + ": " + cacheSizes.get(i));
                    }
                }
                case "EXIT" -> {
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid command. Please try again.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values where required.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
