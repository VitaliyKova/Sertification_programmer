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
    public void addNewPackAnimal(PackAnimals animal) {
        listAnimal.add(animal);
    }

    public void printAll(){
        if(this.listAnimal.isEmpty()){
            System.out.println("      Список пуст!\n");
        }else{
            for (PackAnimals var : this.listAnimal) {
                System.out.println(var.toString());
            }
        }
    }
    //endregion
}
