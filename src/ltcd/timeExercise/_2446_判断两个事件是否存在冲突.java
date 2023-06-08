package ltcd.timeExercise;

public class _2446_判断两个事件是否存在冲突 {

    public boolean haveConflict(String[] event1, String[] event2) {
        String[] split = event1[0].split(":");
        int e1Start = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
        split = event1[1].split(":");
        int e1End = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);

        split = event2[0].split(":");
        int e2Start = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);
        split = event2[1].split(":");
        int e2End = Integer.parseInt(split[1]) + (Integer.parseInt(split[0]) * 60);

        return !(e1End < e2Start || e2End < e1Start);
    }

}
