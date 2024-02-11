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

import java.util.HashSet;
import java.util.Set;

public class FinalWork {
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop(); 
        laptop1.name = "Lenovo";
        laptop1.ozu = 4;
        laptop1.hdd = 500;
        laptop1.os = "Windows 11";
        laptop1.color = "Серый";

        Laptop laptop2 = new Laptop(); 
        laptop2.name = "Asus";
        laptop2.ozu = 8;
        laptop2.hdd = 500;
        laptop2.os = "Windows 11";
        laptop2.color = "Серый";

        Laptop laptop3 = new Laptop();
        laptop3.name = "Lenovo";
        laptop3.ozu = 4;
        laptop3.hdd = 500;
        laptop3.os = "Windows 8";
        laptop3.color = "Розовый";

        Laptop laptop4 = new Laptop();
        laptop4.name = "Dell";
        laptop4.ozu = 4;
        laptop4.hdd = 250;
        laptop4.os = "Windows 8";
        laptop4.color = "Черный";

        Laptop laptop5 = new Laptop();
        laptop5.name = "HP";
        laptop5.ozu = 16;
        laptop5.hdd = 1000;
        laptop5.os = "Windows 10";
        laptop5.color = "Белый";

        Laptop laptop6 = new Laptop();
        laptop6.name = "MacBook Pro";
        laptop6.ozu = 24;
        laptop6.hdd = 1000;
        laptop6.os = "Mac OS";
        laptop6.color = "Серый";

        Laptop laptop7 = new Laptop();
        laptop7.name = "MacBook Air";
        laptop7.ozu = 16;
        laptop7.hdd = 500;
        laptop7.os = "Mac OS";
        laptop7.color = "Серый";

        Laptop laptop8 = new Laptop();
        laptop8.name = "MSI";
        laptop8.ozu = 32;
        laptop8.hdd = 2000;
        laptop8.os = "Windows 11";
        laptop8.color = "Черный";

        Laptop laptop9 = new Laptop();
        laptop9.name = "Lenovo";
        laptop9.ozu = 8;
        laptop9.hdd = 500;
        laptop9.os = "Windows 11";
        laptop9.color = "Черный";
        
        Laptop laptop10 = new Laptop();
        laptop10.name = "Samsung";
        laptop10.ozu = 16;
        laptop10.hdd = 500;
        laptop10.os = "Windows 11";
        laptop10.color = "Серый";

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

        for (Laptop laptop : laptops) {
            System.out.println(laptop);
        }
    }
}
