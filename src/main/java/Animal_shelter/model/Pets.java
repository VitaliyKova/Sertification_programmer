package Animal_shelter.model;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class Pets extends Animals{

    //region Fields
    private final ArrayList<Pets> listAnimal = new ArrayList<>();
    //endregion

    //region Constructor
    public Pets() {
    }
    //endregion

    //region getter

    public ArrayList <Pets> getListAnimal() {
        return listAnimal;
    }

    //endregion

    //region Methods
    public void addNewPetAnimal(Pets animal) {
        listAnimal.add(animal);
    }

    public void printAll(){
        if(this.listAnimal.isEmpty()){
            System.out.println("      Список пуст!\n");
        }else{
            for (Pets var : this.listAnimal) {
                System.out.println(var.toString());
            }
        }
    }
    //endregion
}
