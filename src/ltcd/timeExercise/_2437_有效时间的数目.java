package ltcd.timeExercise;

public class _2437_有效时间的数目 {

    public static void main(String[] args) {
        _2437_有效时间的数目 v = new _2437_有效时间的数目();
        System.out.println(v.countTime("?1:??"));
    }

    public int countTime(String time) {
        char a = time.charAt(0);
        char b = time.charAt(1);
        char c = time.charAt(3);
        char d = time.charAt(4);
        int x = 1;
        if (a == '?' && b == '?') {
            x = 24;
        } else if (a == '?') {
            if (b <= '3') {
                x = 3;
            } else {
                x = 2;
            }
        } else if (b == '?') {
            if (a < '2') {
                x = 10;
            } else {
                x = 4;
            }
        }

        int y = 1;

        if (c == '?' && d == '?') {
            y = 60;
        } else if (c == '?') {
            y = 6;
        } else if (d == '?') {
            y = 10;
        }
        return x * y;
    }


    public int countTime1(String time) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (time.charAt(i) == '?') {
                count++;
            }
        }

        if (count == 0) {
            return 1;
        } else if (count == 4) {
            return 1440;
        } else if (count == 3) {
            if (time.charAt(4) != '?') {
                return 144;
            } else if (time.charAt(3) != '?') {
                return 240;
            } else if (time.charAt(1) != '?') {
                // H?:MM
                if (time.charAt(1) - '0' > 3) {
                    return 120;
                } else {
                    return 180;
                }
            } else {
                // H?:??
                if (time.charAt(0) == '2') {
                    return 240;
                } else {
                    return 600;
                }
            }
        } else if (count == 2) {
            if (time.charAt(3) == '?' && time.charAt(4) == '?') {
                // HH:??
                return 60;
            } else if (time.charAt(0) == '?' && time.charAt(1) == '?') {
                return 24;
            } else if (time.charAt(0) == '?' && time.charAt(3) == '?') {
                // ?H:?M
                if (time.charAt(1) > '3') {
                    return 12;
                } else {
                    return 18;
                }
            } else if (time.charAt(0) == '?' && time.charAt(4) == '?') {
                // ?H:M?
                if (time.charAt(1) > '3') {
                    return 20;
                } else {
                    return 30;
                }
            } else if (time.charAt(1) == '?' && time.charAt(3) == '?') {
                // H?:?M
                if (time.charAt(1) == '2') {
                    return 24;
                } else {
                    return 60;
                }
            } else if (time.charAt(1) == '?' && time.charAt(4) == '?') {
                // H?:M?
                if (time.charAt(0) == '2') {
                    return 40;
                } else {
                    return 100;
                }
            }
        } else {
            if (time.charAt(4) == '?') {
                return 10;
            } else if (time.charAt(3) == '?') {
                return 6;
            } else if (time.charAt(1) == '?') {
                // H?:MM
                if (time.charAt(0) - '0' > 1) {
                    return 4;
                } else {
                    return 10;
                }
            } else {
                // ?H:MM
                if (time.charAt(1) > '3') {
                    return 2;
                } else {
                    return 3;
                }
            }
        }

        return -1;
    }

}
