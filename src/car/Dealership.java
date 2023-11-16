package car;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Dealership
{

    static ArrayList<Car> cars;

    public static void main(String[] args)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("output.txt"));

            String carInput = reader.readLine();

            cars = new ArrayList<>();

            while (carInput != null)
            {
                Car car = new Car(carInput);

                carInput = reader.readLine();

                cars.add(car);
            }
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        System.out.println("Type 1 to see car inventory. Type 2 to purchase a car. Type 3 to sell your car.");

        Scanner scanner = new Scanner(System.in);
        String userNumberInput = scanner.next();

        if (userNumberInput.equals("1"))
        {
            displayCarInventory();
        }
        else if (userNumberInput.equals("2"))
        {
            purchaseCar();
        }
        else if (userNumberInput.equals("3"))
        {
            sellCar();
        }
        else
        {
            System.out.println("Please enter a valid option. (1, 2, 3)");
        }

    }

    public static void displayCarInventory()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("output.txt"));

            int j = 1;

            String carOutput = reader.readLine();

            while (carOutput != null)
            {
                System.out.println(j + ". " + carOutput);
                carOutput = reader.readLine();
                j++;
            }

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    public static void purchaseCar()
    {
        displayCarInventory();

        System.out.println("Please enter the number of the car you would like to purchase. ");

        Scanner scanner = new Scanner(System.in);
        String carToPurchase = scanner.next();

        int carToPurchaseInteger = Integer.parseInt(carToPurchase);
        if (cars.size() >= carToPurchaseInteger)
        {
            Car carOutput = cars.get(carToPurchaseInteger - 1);
            System.out.println("You have chosen " + carOutput);
            deleteLine(carOutput);
        } else System.err.println("You must enter a valid number that matches a car.");

    }

    public static void sellCar()
    {
    }

    public static void deleteLine(Car carToRemove)
    {
        //take the car array list that is given and if a car equals the car we want to delete we will remove it from the array list
        //,and then we will take that array list, and we will overwrite the output.txt file with the new arraylist.
        try
        {
            cars.remove(carToRemove);
            FileWriter writer = new FileWriter("output.txt");
            for (Car car : cars)
            {
                writer.write(car + "\n");
            }
            writer.close();
            System.out.println(cars);

        } catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }
}