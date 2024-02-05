package LinkedLists;

import java.util.ArrayList;
import java.util.LinkedList;

public class Linked {
    public static void main(String[] args) {
        LinkedList<String> namesLinkedList = new LinkedList<>();
        namesLinkedList.add("Halil");
        namesLinkedList.add("Walter");
        namesLinkedList.add("Jessie");
        System.out.println(namesLinkedList.get(2));
        namesLinkedList.add(1,"Jerry");


        ArrayList<String>  namesArrayList = new ArrayList<>();
        namesArrayList.add("Halil");
        namesArrayList.add("Walter");
        namesArrayList.add("Jessie");
        System.out.println(namesArrayList .get(2));

    }
}
