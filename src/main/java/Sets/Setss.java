package Sets;

import java.util.*;

public class Setss {
    public static void main(String[] args) {

        Set<String> names = new HashSet<>();

        names.add("lol");
        names.add("haha");
        names.add("lol");
        //names.remove("lol");
        //names.clear();
        //System.out.println(names);

        names.forEach(System.out::println);
//        Iterator<String> namesIterator = names.iterator();
//        while (namesIterator.hasNext()){
//            System.out.println(namesIterator.next());
//        }

    List<Integer> numberList = new ArrayList<>();
    numberList.add(1);
    numberList.add(3);
    numberList.add(3);
    numberList.add(4);

    Set<Integer> numberSet = new HashSet<>();
    numberSet.addAll(numberList);

    System.out.println(numberSet);

    }
}
