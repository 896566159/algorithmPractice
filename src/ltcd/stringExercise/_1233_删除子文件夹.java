package ltcd.stringExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1233_删除子文件夹 {

    public List<String> removeSubfolders(String[] folder) {

        List<String> ans = new ArrayList<>();
        Arrays.sort(folder);

        for (int i = 0; i < folder.length; i++) {
            for (int j = i + 1; j < folder.length; j++) {
                if (folder[j].startsWith(folder[i] + "/")) {
                    folder[j] = "**";
                }
            }
        }

        for (int i = 0; i < folder.length; i++) {
            if (!folder[i].equals("**")) {
                ans.add(folder[i]);
            }
        }

        return ans;
    }

}
