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
        }
        else System.err.println("You must enter a valid number that matches a car.");

    }

    public static void sellCar()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You have chosen to sell a car. Please enter the year of your vehicle: ");
        int yearInput = scanner.nextInt();

        System.out.println("Please enter the make of your vehicle: ");
        String makeInput = scanner.next();

        System.out.println("Please enter the model of your vehicle: ");
        String modelInput = scanner.next();

        System.out.println("Please enter the price of your vehicle: ");
        int priceInput = scanner.nextInt();

        System.out.println("Please enter the mileage of your vehicle: ");
        int mileageInput = scanner.nextInt();


        try
        {
            String fileName = "output.txt";
            FileWriter writer = new FileWriter(fileName, true);
            writer.write("\n" + yearInput + " " + makeInput + " " + modelInput + " " + priceInput + " " + mileageInput);
            writer.close();

        } catch (IOException e)
        {
            System.err.println(e.getMessage());
        }

    }

    public static void deleteLine(Car carToRemove)
    {
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