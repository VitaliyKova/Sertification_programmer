package Animal_shelter.model;
import java.util.ArrayList;

public class Pets extends Animals{

    //region Fields
    private final ArrayList<Pets> listAnimal = new ArrayList<>();
    //endregion

    //region Constructor
    public Pets() {
    }
    //endregion

    //region Methods
    public void addNewPetAnimal(Pets animal) {
        listAnimal.add(animal);
    }

    public void printAll(){
        for (Pets var : this.listAnimal) {
            System.out.println(var.toString());
        }
    }
    //endregion
}
