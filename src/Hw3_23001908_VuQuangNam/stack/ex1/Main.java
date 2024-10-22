package Hw3_23001908_VuQuangNam.stack.ex1;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        /*Tùy vào độ dài họ tên và các kí tự của tên mà trong stack sẽ chứa kết quả khác nhau, nhưng sau cùng, trong stack sẽ chứa các kí tự ở vị trí thứ 4, thứ 10, thứ 16... và thêm phần tử vị trí cuối nếu thỏa mãn (1)
        Giải thích: với day index sau 0 1 2 3 4 5 6 7 8 9 10 11 ...
        Ta sẽ không xét các vị trí vừa chia hết cho 2 vừa chia hết cho 3 (push xong rồi pop) -> không thay đổi stack
        Dễ thấy cứ 6 (2 * 3) vị trí sẽ xuất hiện 1 bộ 3 a b c mà a, c chia hết 2, b chia hết 3
        Khi đó, push ở vị trí a, pop ở vị trí b, rồi push ở vị trí c
                --> Cứ cách 6 vị trí thì stack sẽ push them được 1 kí tự
        (1) Và nếu vị trí cuối cùng là phần tử đầu tiene trong bộ 3 a b c thì stack sẽ chứa them kí tự ở vị trí cuối (chưa có pop vị trí b)*/

        Stack<Integer> stack = new Stack<>();
        String name = "vuquangnam";
        for (int i = 0; i < name.length(); i++) {
            if (i % 2 == 0) {
                stack.push(i);
            }
            if (i % 3 == 0) {
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
