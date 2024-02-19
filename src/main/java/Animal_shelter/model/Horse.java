package Animal_shelter.model;

import java.util.HashSet;

public class Horse extends PackAnimals {

    //region fields
    private final String type = "ЛОШАДЬ";
    private String name;
    private String dateOfBirthday;
    private final HashSet<String> commands = new HashSet<>();
    //endregion

    //region constructor
    public Horse(String name, String dateOfBirthday) {
        this.name = name;
        this.dateOfBirthday = dateOfBirthday;
    }
    //endregion

    //region getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }
    //endregion

    //region methods
    public void addCommand(String command) {
        this.commands.add(command);
    }

    public void printAllCommands() {
        for (String com : this.commands) {
            System.out.print(com + ' ');
        }
    }

    public String toString() {
        return   "----" + type + "-----" +'\n' +
                "Name:"+ ' ' + name +'\n' +
                "Date og birthday:"+ ' ' + dateOfBirthday + '\n';
    }
//endregion
}