package Animal_shelter.model;

import java.util.HashSet;

public class Dogs extends Pets{

    //region fields
    private final String type = "СОБАКА";
    private String name;
    private String dateOfBirthday;
    private final HashSet<String> commands = new HashSet<>();
    //endregion

    //region constructor
    public Dogs(String name, String dateOfBirthday) {
        this.name = name;
        this.dateOfBirthday = dateOfBirthday;
    }
    //endregion


    //region methods
    public void addCommand(String command){
        this.commands.add(command);
    }

    public void printAllCommands(){
        if(!this.commands.isEmpty()){
            System.out.print("\n Животное знает следующие команды: ");
            for (String com:this.commands) {
                System.out.print(com +' ');
            }
            System.out.println();
        }else{
            System.out.println("\nСписок команд пуст!\n");
        }
    }

    @Override
    public String toString() {
        return   "----" + type + "-----" +'\n' +
                "Name:"+ ' ' + name +'\n' +
                "Date og birthday:"+ ' ' + dateOfBirthday + '\n';
    }
    //endregion
}
