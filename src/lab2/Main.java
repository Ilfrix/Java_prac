package lab2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Human> humans = new ArrayList<>();
        humans.add(new Human(20, "Steeve", "Snow", LocalDate.of(2000,10, 30), 100));
        humans.add(new Human(29, "John", "Cambel", LocalDate.of(1991,1, 19), 89));
        humans.add(new Human(40, "Michael", "Kerri", LocalDate.of(1980,7, 5), 140));
        humans.add(new Human(12, "Avram", "Linkoln", LocalDate.of(2012,3, 7), 50));
        humans.add(new Human(31, "Elizabeth", "Windsor", LocalDate.of(1989,2, 13), 90));

        List<Human> first = humans.stream().sorted(Comparator.comparing(Human::getAge).reversed()).toList();
        System.out.println("Сортировка по возрасту в обратном порядке");
        first.forEach(System.out::println);

        List<Human> second = humans.stream().filter(human -> human.getFirstName().charAt(0) == 'A').toList();
        System.out.println("Фильтрация по имени, начинающемуся с буквы А");
        second.forEach(System.out::println);

        List<Human> third = humans.stream().sorted(Comparator.comparing(Human::getBirthDay)).toList();
        System.out.println("Сортировка по дате рождения");
        third.forEach(System.out::println);

        float fourth = humans.stream().mapToInt(Human::getWeight).sum() / humans.stream().count();
        System.out.println("Среднее значение веса");
        System.out.println(fourth);
    }
}
