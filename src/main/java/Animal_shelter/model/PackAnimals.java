package Animal_shelter.model;

import java.util.ArrayList;

public class PackAnimals extends Animals{

    //region fields
    private final ArrayList<PackAnimals> listAnimal = new ArrayList<>();

    //endregion

    //region Getters and Setters

    public ArrayList<PackAnimals> getListAnimal() {
        return listAnimal;
    }

    //endregion

    //region constructor

    public PackAnimals() {
    }

    //endregion

    //region methods
    public void addNewPetAnimal(PackAnimals animal) {
        listAnimal.add(animal);
    }

    public void printAll(){
        for (PackAnimals var : this.listAnimal) {
            System.out.println(var.toString());
        }
    }
    //endregion
}
