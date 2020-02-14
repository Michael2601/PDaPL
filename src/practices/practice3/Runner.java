package practices.practice3;

import practices.practice3.elements.Battery;
import practices.practice3.elements.Boiler;
import practices.practice3.elements.ExpansionTank;
import utils.GlobalUtil;

import java.util.*;

/**
 * @author Michael Sheshilov
 *
 * <p><strong>Вариант 27</strong></p>
 * Наследование применять только в тех заданиях, в которых это
 * логически обосновано. Аргументировать принадлежность классу каждого
 * создаваемого метода и корректно переопределить для каждого класса методы
 * equals(), hashCode(), toString().
 * Создать объект класса Батарея, используя классы Вода, Котёл.
 * Методы: греть, течь, остывать.
 */
public class Runner {
    public static void main(String[] args) {
        Boiler boiler = new Boiler("Gas", 40, 5);
        ExpansionTank tank = new ExpansionTank(10, "Steel");
        List<Battery> batteries = new ArrayList<>();
        batteries.add(new Battery(20));
        batteries.add(new Battery(30));
        batteries.add(new Battery(20, 900));
        batteries.add(new Battery(30));
        batteries.add(new Battery(20));
        batteries.add(new Battery(10));
        HeatingSystem system = new HeatingSystem(boiler, batteries, tank);
        system.pour(new Water(100));
        system.startHeating();
        system.pour(new Water(100));
        system.startHeating();
        GlobalUtil.postScriptum("Michael Sheshilov", "13.02.2020 22:30");
    }
}
