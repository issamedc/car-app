package car;

public class Car
{
    public int year;
    public String make;
    public String model;
    public double price;
    public double mileage;

    public Car(int year, String make, String model, double price, double mileage)
    {
        this.year = year;
        this.make = make;
        this.model = model;
        this.price = price;
        this.mileage = mileage;

    }

    @Override
    public String toString()
    {
        return year + " " + make + " " + model + " " + price + " " + mileage;
    }

    public Car(String carInput)
    {
        int year = 0;
        String make = null;
        String model = null;
        double price = 0;
        double mileage = 0;

        int yearEndIndex = 0;
        int makeEndIndex = 0;
        int modelEndIndex = 0;
        int priceEndIndex = 0;

        for (int i = 0; i < carInput.length(); i++)
        {
            char currentCharacter = carInput.charAt(i);
            if (currentCharacter == ' ')
            {
                year = Integer.parseInt(carInput.substring(0, i));
                yearEndIndex = i + 1;
                break;
            }
        }

        for (int i = yearEndIndex; i < carInput.length(); i++)
        {
            char currentCharacter = carInput.charAt(i);
            if (currentCharacter == ' ')
            {
                make = carInput.substring(yearEndIndex, i);
                makeEndIndex = i + 1;
                break;
            }
        }
        for (int i = makeEndIndex; i < carInput.length(); i++)
        {
            char currentCharacter = carInput.charAt(i);
            if (currentCharacter == ' ')
            {
                model = carInput.substring(makeEndIndex, i);
                modelEndIndex = i + 1;
                break;
            }
        }
        for (int i = modelEndIndex; i < carInput.length(); i++)
        {
            char currentCharacter = carInput.charAt(i);
            if (currentCharacter == ' ')
            {
                price = Double.parseDouble(carInput.substring(modelEndIndex, i));
                priceEndIndex = i + 1;
                break;
            }
        }
        mileage = Double.parseDouble(carInput.substring(priceEndIndex));

        this.year = year;
        this.make = make;
        this.model = model;
        this.price = price;
        this.mileage = mileage;
    }
}
