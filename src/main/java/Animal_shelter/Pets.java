package Animal_shelter;
import java.util.ArrayList;
import java.util.Date;

public class Pets extends Animals{

    //region Fields
    private final ArrayList<Pets> listAnimal = new ArrayList<>();
    //endregion

    //region Constructor
    public Pets(String type) {
        super(type);
    }
    //endregion

    //region Methods
    public void addNewPetAnimal(Pets animal){ //Метод для добавления новых домашних животных.
        this.listAnimal.add(animal);
    }

    public void printAll(){
        for (Pets var : this.listAnimal) {
            System.out.println(var.toString());
        }
    }
    //endregion

}
