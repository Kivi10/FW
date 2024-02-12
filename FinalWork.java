package FW;
/*
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
отвечающие фильтру. Критерии фильтрации можно хранить в Map.
Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
5 - поиск
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно
также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.

Частые ошибки:
1. Заставляете пользователя вводить все существующие критерии фильтрации
2. Невозможно использовать более одного критерия фильтрации одновременно
3. При выборке выводятся ноутбуки, которые удовлетворяют только одному фильтру, а не всем введенным пользователем
4. Работа выполнена только для каких то конкретных ноутбуков, и если поменять характеристики ноутбуков
или добавить еще ноутбук, то программа начинает работать некорректно
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class FinalWork {
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop(); 
        laptop1.name = "Lenovo";
        laptop1.ozu = 4;
        laptop1.hdd = 500;
        laptop1.os = "Windows 11";
        laptop1.color = "Gray";

        Laptop laptop2 = new Laptop(); 
        laptop2.name = "Asus";
        laptop2.ozu = 8;
        laptop2.hdd = 500;
        laptop2.os = "Windows 11";
        laptop2.color = "Gray";

        Laptop laptop3 = new Laptop();
        laptop3.name = "Lenovo";
        laptop3.ozu = 4;
        laptop3.hdd = 500;
        laptop3.os = "Windows 10";
        laptop3.color = "Pink";

        Laptop laptop4 = new Laptop();
        laptop4.name = "Dell";
        laptop4.ozu = 4;
        laptop4.hdd = 250;
        laptop4.os = "Windows 10";
        laptop4.color = "Black";

        Laptop laptop5 = new Laptop();
        laptop5.name = "HP";
        laptop5.ozu = 16;
        laptop5.hdd = 1000;
        laptop5.os = "Windows 10";
        laptop5.color = "White";

        Laptop laptop6 = new Laptop();
        laptop6.name = "MacBook";
        laptop6.ozu = 32;
        laptop6.hdd = 1000;
        laptop6.os = "Mac OS";
        laptop6.color = "Gray";

        Laptop laptop7 = new Laptop();
        laptop7.name = "MacBook";
        laptop7.ozu = 16;
        laptop7.hdd = 500;
        laptop7.os = "Mac OS";
        laptop7.color = "Gray";

        Laptop laptop8 = new Laptop();
        laptop8.name = "MSI";
        laptop8.ozu = 32;
        laptop8.hdd = 2000;
        laptop8.os = "Windows 11";
        laptop8.color = "Black";

        Laptop laptop9 = new Laptop();
        laptop9.name = "Lenovo";
        laptop9.ozu = 8;
        laptop9.hdd = 500;
        laptop9.os = "Windows 11";
        laptop9.color = "Black";
        
        Laptop laptop10 = new Laptop();
        laptop10.name = "Samsung";
        laptop10.ozu = 16;
        laptop10.hdd = 500;
        laptop10.os = "Windows 11";
        laptop10.color = "Gray";

        Set<Laptop> laptops = new HashSet<>();
        laptops.add(laptop1);
        laptops.add(laptop2);
        laptops.add(laptop3);
        laptops.add(laptop4);
        laptops.add(laptop5);
        laptops.add(laptop6);
        laptops.add(laptop7);
        laptops.add(laptop8);
        laptops.add(laptop9);
        laptops.add(laptop10);

        Map<String, Object> result = new HashMap<>();

        Scanner scan = new Scanner(System.in);

        int res = 0;
        
        String name = null;
        int ozu = 0;
        int hdd = 0;
        String os = null;
        String color = null;

        while (res != 6) {
            res = input(scan);
            switch (res) {
                case 1:
                    name = name(scan);
                    result.put("name", name);
                    break;
                case 2:
                    ozu = ozu(scan);
                    result.put("ozu", ozu);
                    break;
                case 3:
                    hdd = hdd(scan);
                    result.put("hdd", hdd);
                    break;
                case 4:
                    os = os(scan);
                    result.put("os", os);
                    break;
                case 5:
                    color = color(scan);
                    result.put("color", color);
                    break;
                default:
                    System.out.println("Поиск...");
                    System.out.println();
                    break;
            }
        }

        Set<Laptop> filteredLaptops = filterLaptops(laptops, result);

        if (filteredLaptops.isEmpty()) {
            System.out.println("Нет ноутбука удовлетворяющего ваш запрос :(");
        }
        else{
            for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop);
        } 
        }
       

    }

    static Integer input(Scanner scan){
            int input = 0;
            boolean flag = true;
        while (flag == true){
            printAll();
            System.out.println();
            System.out.print("Введите цифру, соответствующую необходимому критерию: -> ");
            
            if (scan.hasNextInt()){
                input = Integer.parseInt(scan.nextLine());
                if (!(input <= 0 || input >= 7)) {
                    System.out.println("Вы ввели: " + input);
                    System.out.println();
                    flag = false;
                }
                else {
                    System.out.println("Такого числа нет!");
                    System.out.println();
                    flag = true;
                }
            }
            else{
                System.out.println("Ошибка ввода! Потворите попыкту!");
                System.out.println();
                scan.nextLine();
                flag = true;
            }
        }
        return input;
    }

    static Integer ozu(Scanner scan){
        int input = 0;
            boolean flag = true;
        while (flag == true){
            System.out.print("Сколько GB оперативной памяти вам необходимо?: 4, 8, 16, 32 -> ");
            if (scan.hasNextInt()){
                input = Integer.parseInt(scan.nextLine());
                if (input == 4 || input == 8 || input == 16 || input == 32) {
                    System.out.println("Вы ввели: " + input);
                    System.out.println();
                    flag = false;
                }
                else {
                    System.out.println("Такого числа нет!");
                    System.out.println();
                    flag = true;
                }
            }
            else{
                System.out.println("Ошибка ввода! Потворите попыкту!");
                System.out.println();
                scan.nextLine();
                flag = true;
            }
        }
        return input;
    }
    
    static String name(Scanner scan){
        String name = null;
        boolean flag = true;
        while (flag == true){
            System.out.print("Напишите ноутбук какого производителя вы бы хотели?: Lenovo, Asus, MSI, HP, Dell, MacBook -> ");
            if (scan.hasNext()){
                name = scan.nextLine().toLowerCase();
                if (name.equals("lenovo")  || name.equals("asus")  || name.equals("msi")
                    || name.equals("hp")  || name.equals("dell")  || name.equals("macbook")) {
                    System.out.println("Вы ввели: " + name);
                    System.out.println();
                    flag = false;
                }
                else {
                    System.out.println("Ошибка ввода! Повторите ввод!");
                    System.out.println();
                    System.out.flush();
                    flag = true;
                }
            }
        }
        return name;
    }

    static Integer hdd(Scanner scan){
        int input = 0;
            boolean flag = true;
        while (flag == true){
            System.out.print("Сколько GB встроенной памяти вам необходимо?: 250, 500, 1000 -> ");
            if (scan.hasNextInt()){
                input = Integer.parseInt(scan.nextLine());
                if (input == 250 || input == 500 || input == 1000) {
                    System.out.println("Вы ввели: " + input);
                    System.out.println();
                    flag = false;
                }
                else {
                    System.out.println("Такого числа нет!");
                    System.out.println();
                    flag = true;
                }
            }
            else{
                System.out.println("Ошибка ввода! Потворите попыкту!");
                System.out.println();
                scan.nextLine();
                flag = true;
            }
        }
        return input;
    }
    
    static String os(Scanner scan){
        String os = null;
        boolean flag = true;
        while (flag == true){
            System.out.print("Какая операционная система вам подходит больше -> Windows 10, Windows 11, MacOS -> ");
            if (scan.hasNext()){
                os = scan.nextLine().toLowerCase();
                if (os.equals("windows 10")  || os.equals("windows 11")  || os.equals("macos")) {
                    System.out.println("Вы ввели: " + os);
                    System.out.println();
                    flag = false;
                }
                else {
                    System.out.println("Ошибка ввода! Повторите ввод!");
                    System.out.println();
                    System.out.flush();
                    flag = true;
                }
            }
        }
        return os;
    }

    static String color(Scanner scan){
        String color = null;
        boolean flag = true;
        while (flag == true){
            System.out.print("Какой цвет ноутбука вы бы хотели? -> Gray, Black, Pink, White -> ");
            if (scan.hasNext()){
                color = scan.nextLine().toLowerCase();
                if (color.equals("gray")  || color.equals("black")  || color.equals("pink")
                 || color.equals("white")) {
                    System.out.println("Вы ввели: " + color);
                    System.out.println();
                    flag = false;
                }
                else {
                    System.out.println("Ошибка ввода! Повторите ввод!");
                    System.out.println();
                    System.out.flush();
                    flag = true;
                }
            }
        }
        return color;
    }

    static void printAll(){
        System.out.println("1 - Название\r\n" + 
                        "2 - ОЗУ\r\n" +
                        "3 - Объем ЖД\r\n" +
                        "4 - Операционная система\r\n" +
                        "5 - Цвет\r\n" +
                        "6 - Поиск");
    }

    static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<String, Object> filters) {
        return laptops.stream()
                .filter(laptop -> filters.get("name") == null || laptop.getName().equals(filters.get("name")))
                .filter(laptop -> (int) filters.getOrDefault("ozu", 0) == 0 || laptop.getOzu() >= (int) filters.get("ozu"))
                .filter(laptop -> (int) filters.getOrDefault("hdd", 0) == 0 || laptop.getHdd() >= (int) filters.get("hdd"))
                .filter(laptop -> filters.get("os") == null || laptop.getOs().equals(filters.get("os")))
                .filter(laptop -> filters.get("color") == null || laptop.getColor().equals(filters.get("color")))
                .collect(Collectors.toSet());
    
    }
}

