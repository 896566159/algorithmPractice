//package ltcd.classExercise;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//public class _341_扁平化嵌套列表迭代器 implements Iterator<Integer>{
//
//    private List<Integer> vals;
//    private Iterator<Integer> cur;
//
//    public _341_扁平化嵌套列表迭代器(List<_341_扁平化嵌套列表迭代器> nestedList) {
//        vals = new ArrayList<Integer>();
//        dfs(nestedList);
//        cur = vals.iterator();
//    }
//
//    @Override
//    public Integer next() {
//        return cur.next();
//    }
//
//    @Override
//    public boolean hasNext() {
//        return cur.hasNext();
//    }
//
//    private void dfs(List<_341_扁平化嵌套列表迭代器> nestedList) {
//        for (_341_扁平化嵌套列表迭代器 nest : nestedList) {
//            if (nest.isInteger()) {
//                vals.add(nest.getInteger());
//            } else {
//                dfs(nest.getList());
//            }
//        }
//    }
//
//}
