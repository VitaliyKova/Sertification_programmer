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
        System.out.println("Введите кличку животного");
        return scanner.nextLine();
    }

    private String inputDateOfBirth(){
        System.out.println("Введите рождения животного");
        return scanner.nextLine();
    }


    private String inputNewCommands(){
        System.out.println("Введите новую команду для животного");
        return scanner.nextLine();
    }

    private String choosingAnimal(){
        System.out.println("Выберите категорию для животного, которого вы хотите добавить из доступных!\n");
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
                case "5":{
                    flag = false;
                    break;
                }
            }
        }
    }
    //endregion
}
