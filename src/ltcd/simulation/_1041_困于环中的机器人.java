package ltcd.simulation;

public class _1041_困于环中的机器人 {

    public boolean isRobotBounded(String instructions) {
        char[] chars = instructions.toCharArray();
        int x = 0;
        int y = 0;
        // 方向：0-北，1-东，2-南，3-西
        int direction = 0;

        // 如果循环四轮，都没有回到原点，则机器人不会被困住
        // 情况一：如果instructions中只有G，没有转向，则机器人朝着北一直走，不会回到原点
        // 情况二：执行一轮instructions后，最终的方向是朝南，那么在执行一轮方向会向北，故方向会在南-北之间循环调转
        // 情况三：执行一轮instructions后，最终的方向是朝东或者朝西，如果再连续执行三轮，都不会经过原点，则说明不会造成环了
        for (int i = 0; i < 3; i++) {

            // 执行一轮instructions
            for (char c : chars) {
                if (c == 'G') {
                    switch (direction) {
                        case 0 :
                            y++;
                            break;
                        case 1 :
                            x++;
                            break;
                        case 2 :
                            y--;
                            break;
                        case 3 :
                            x--;
                            break;
                        default:
                            break;
                    }
                } else if (c == 'L') {
                    direction = (direction + 3) % 4;
                } else if (c == 'R') {
                    direction = (direction + 1) % 4;
                }
            }

            // 回到原点
            if (x == 0 && y == 0) {
                return true;
            }
        }

        return false;
    }

}
