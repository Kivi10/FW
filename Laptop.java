package FW;

public class Laptop {
    String name;
    int ozu;
    int hdd;
    String os;
    String color;

    public String toString() {
        return "Название модели: " + name + "\n" +"ОЗУ: " + ozu + " Gb" + "\n" + "Объем памяти: " + hdd + " Gb" + "\n" + 
        "Операционная система: " + os + "\n" + "Цвет: " + color + "\n";
    }

    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
    public int getHdd() {
        return hdd;
    }
    public String getOs() {
        return os;
    }
    public int getOzu() {
        return ozu;
    }

}
