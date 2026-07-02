public class AnimalFactory {

    public static Animal getAnimal(String animalType) {

        if (animalType == null) {

            return null;

        }

        if (animalType.equalsIgnoreCase("Dog")) {

            return new Dog();

        }

        else if (animalType.equalsIgnoreCase("Cat")) {

            return new Cat();

        }

        else if (animalType.equalsIgnoreCase("Lion")) {

            return new Lion();

        }

        return null;

    }

}