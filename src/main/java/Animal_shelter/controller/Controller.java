package Animal_shelter.controller;
import Animal_shelter.model.Dogs;
import Animal_shelter.model.PackAnimals;
import Animal_shelter.model.Pets;

public class Controller{

    //region fields
    PackAnimals packAnimals = new PackAnimals();
    Pets pets = new Pets();
    //endregion

    //region constructor

    public Controller() {
    }

    //endregion

    //region addPets Animals
    public void addAnimals(String type,String name, String birth) {      /* 1 -> СОБАКА
                                                                            2 -> КОТ
                                                                            3 -> ХОМЯК
                                                                            4 -> ВЕРБЛЮД
                                                                            5 -> ОСЁЛ
                                                                            6 -> ЛОШАДЬ */
        switch (type){
            case "1":{
                pets.addNewPetAnimal(new Dogs(name,birth));
                break;
            }
            case "2":{break;}
            case "3":{break;}
            case "4":{break;}
            case "5":{break;}
            case "6":{break;}
            default:{
                System.out.println(type + " - Такая категория не существует");
            }
        }



    }
    //endregion
}
