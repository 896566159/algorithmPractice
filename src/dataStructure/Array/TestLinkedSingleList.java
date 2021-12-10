package dataStructure.Array;

public class TestLinkedSingleList {


    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.println(list.toString());
//        for (int i = 9; i >= 0; i--) {
            list.remove(3);
            list.remove(6);
            System.out.println(list.toString());
//        }

//        list.add(0, -1);
//        list.add(0, -2);
//        System.out.println(list.toString());
//        list.add(list.size, list.size - 2);
//        list.add(list.size, list.size - 2);
//        System.out.println(list.toString());
//        list.add(1, 1111);
//        list.add(list.size - 1, 999);
//        System.out.println(list.toString());

//        for (int i = 10; i < 20; i++) {
//            list.add(i);
//        }
//        System.out.println(list.toString());
//        list.add(0, -2);
////        list.add(1, -1);
//        System.out.println(list.toString());
//        list.add(list.size, list.size - 1);
//        System.out.println(list.toString());
//        list.add(list.size, list.size);
//        System.out.println(list.toString());
//        while (!list.isEmpty()){
//            System.out.println(list.remove(0));
//        }
//        System.out.println(list.toString());
    }

}
