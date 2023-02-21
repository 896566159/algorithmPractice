package ltcd.timeExercise;

import java.util.*;

/**
 * 将时间都转化成分钟来计算
 */
public class _1604_警告一小时内使用相同员工卡大于等于三次的人 {

    public static void main(String[] args) {
        alertNames1(new String[]{"daniel","daniel","daniel","luis","luis","luis","luis"},
                new String[]{"10:00","10:40","11:00","09:00","11:00","13:00","15:00"});
    }

    public static List<String>  alertNames1(String[] keyName, String[] keyTime) {
        List<String> ans = new ArrayList<>();
        Map<String, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < keyName.length; i++) {
            String[] split = keyTime[i].split(":");
            int time = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            //如果map中有name为key的键值对，则直接将时间加入，如果不存在，则新建一个满足键值对的value的结构的数据类型，并将元素加入value中
            //判断一个map中是否存在这个key，如果存在则处理value的数据，如果不存在，则创建一个满足value要求的数据结构放到value中
            map.computeIfAbsent(keyName[i], key -> new ArrayList<>()).add(time);
        }

        for (Map.Entry<String, List<Integer>> kv : map.entrySet()) {
            if (kv.getValue().size() > 2) {
                List<Integer> value = kv.getValue();
                Collections.sort(value);

                for (int i = 2; i < value.size(); i++) {
                    if (value.get(i) - value.get(i - 2) <= 60) {
                        ans.add(kv.getKey());
                        break;
                    }
                }
            }
        }

        return ans;
    }
}
