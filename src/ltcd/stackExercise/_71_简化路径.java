package ltcd.stackExercise;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class _71_简化路径 {

    public String simplifyPath(String path) {
        Deque<Character> deque = new LinkedList<>();
        int index = 0;
        char pre = '0';

        while (index < path.length()) {
            if (pre == '.') {
                //case1: ./
                if (path.charAt(index) == '/') {//poll the pre, and don't push current character
                    deque.pollLast();
                    index++;
                    pre = '/';
                    continue;
                } else if (path.charAt(index) == '.') {
                    //case2: ../
                    if (index - 2 > 0 && path.charAt(index - 2) != '/') {
                        while (index < path.length() && path.charAt(index) != '/') {
                            deque.offerLast(path.charAt(index));
                            index++;
                        }

                        if (index == path.length()) {
                            break;
                        }
                    }

                    if (index + 1 < path.length() && path.charAt(index + 1) == '/') {//poll the pre path
                        if (deque.size() == 2) {
                            deque.pollLast();
                            pre = '/';
                            index += 2;
                            continue;
                        }

                        int count = 2;
                        while (count > 0 && deque.size() > 1) {
                            if (deque.pollLast() == '/') {
                                count--;
                            }
                        }
                        pre = '/';
                        index++;
                        continue;
                    } else {//push into path
                        //case3: .../
                        while (index < path.length() && path.charAt(index) != '/') {
                            deque.offerLast(path.charAt(index));
                            index++;
                        }

                        if (index == path.length()) {
                            break;
                        }
                    }
                } else {
                    Character last = deque.pollLast();
                    deque.offerLast('/');
                    deque.offerLast(last);
                }
            }

            if (pre == '/' && path.charAt(index) == '/') {
                index++;
                continue;
            }

            pre = path.charAt(index);
            deque.offerLast(pre);
            index++;
        }

        if (deque.size() > 1 && deque.peekLast() == '/') {
            deque.pollLast();
        }

        if (deque.size() > 1 && deque.peekLast() == '.') {
            pre = deque.pollLast();
            if (deque.peekLast() == '/') {
                deque.pollLast();
            } else {
                deque.offerLast(pre);
            }
        }

        StringBuffer sb = new StringBuffer();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        _71_简化路径 v = new _71_简化路径();
        System.out.println(v.simplifyPath("/a//b////c/d//././/.."));
    }
}
