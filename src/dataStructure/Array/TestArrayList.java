package dataStructure.Array;

public class TestArrayList {


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.println(list.toString());

        for (int i = 10; i < 20; i++) {
            list.add(i);
        }
        System.out.println(list.toString());
        list.add(0, -2);
        list.add(1, -1);
        list.add(list.size, list.size - 1);
        list.add(list.size, list.size);
        System.out.println(list.toString());
        while (!list.isEmpty()){
            System.out.println(list.remove(0));
        }
        System.out.println(list.toString());
    }

}
