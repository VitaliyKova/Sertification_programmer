package Animal_shelter.view;

import Animal_shelter.controller.Controller;

import java.util.Scanner;

public class View {

    //region field
    private final Scanner scanner = new Scanner(System.in);
    private final Controller controller = new Controller();
    //endregion

    //region constructor
    public View() {
    }
    //endregion

    //region Requests
    private String inputName(){
        boolean flag = true;
        while (flag) {
            System.out.print("\nВведите кличку животного: ");
            String value = scanner.nextLine();
            if (value.isEmpty()) {
                System.out.println("\nВы ничего не ввели!\n");
            } else {
                flag = false;
                return value;
            }
        }
        return null;
    }

    private String inputDateOfBirth() {
        boolean flag = true;
        while (flag) {
            System.out.print("\nВведите дату рождения животного: ");
            String value = scanner.nextLine();
            if (value.isEmpty()) {
                System.out.println("\nВы ничего не ввели!\n");
            } else {
                flag = false;
                return value;
            }
        }
        return null;
    }

    private String inputNewCommands(){
        boolean flag = true;
        while (flag) {
            System.out.print("\nВведите новую команду для животного: ");
            String value = scanner.nextLine();
            if (value.isEmpty()) {
                System.out.println("\nВы ничего не ввели!\n");
            } else {
                flag = false;
                return value;
            }
        }
        return null;
    }

    private String choosingAnimal(){
        System.out.println("\nВыберите категорию животного из доступных!\n");
        System.out.print("Ваш выбор -> ");
        return scanner.nextLine();
    }

    //endregion

    //region methods
    public void start(){
        boolean flag = true;
        String menu = "\n       ---MENU---\n\n" +                  // Задаем значения МЕНЮ
                "1 -> Добавить животного\n" +
                "2 -> Смотреть список всех животных\n" +
                "3 -> Смотреть список команд животного\n" +
                "4 -> Обучить животного новой команде\n" +
                "5 -> Выход\n\n" +
                "Ваш выбор -> ";

        String listAnimals = "\n---Доступные категории---\n\n" +
                "1 -> СОБАКА\n" +
                "2 -> КОТ\n" +
                "3 -> ХОМЯК\n" +
                "4 -> ВЕРБЛЮД\n" +
                "5 -> ОСЁЛ\n" +
                "6 -> ЛОШАДЬ\n" +
                "7 -> Выход\n\n";

        while (flag) {                                   // Запускаем цикл обработки
            System.out.print(menu);
            String input = scanner.nextLine();
            switch (input){
                case "1":{
                    System.out.println(listAnimals);
                    String result = choosingAnimal();
                    boolean flagIn = result.equals("7");
                    if(flagIn) break;
                    else {
                        controller.addAnimals(result,inputName(),inputDateOfBirth());
                    }
                    break;
                }
                case "2":{
                    controller.printAllAnimals();
                    break;
                }
                case "3":{
                    System.out.println(listAnimals);
                    String result = choosingAnimal();
                    boolean flagIn = result.equals("7");
                    if(flagIn) break;
                    else {
                        controller.printCommands(result,inputName());
                    }
                    break;
                }
                case "4":{
                    System.out.println(listAnimals);
                    String result = choosingAnimal();
                    boolean flagIn = result.equals("7");
                    if(flagIn) break;
                    else {
                        controller.newComand(result,inputName(),inputNewCommands());
                    }
                    break;
                }
                case "5":{
                    flag = false;
                    break;
                }
                default:{
                    System.out.println("\nНекорректно введен номер пункта!\n");
                }
            }
        }
    }
    //endregion
}
