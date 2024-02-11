package FW;

import Sem6.Cat.Cat;

public class Laptop {
    String name;
    int ozu;
    int hdd;
    String os;
    String color;

    public String toString() {
        return "name: " + name + "\n" +"ОЗУ: " + ozu + "\n" + "Объем памяти: " + hdd + "\n" + 
        "Операционная система: " + os + "\n" + "Цвет: " + color + "\n";
    }
}
