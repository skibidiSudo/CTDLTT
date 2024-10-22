package Hw1_23001908_VuQuangNam.ex9;

import java.io.*;
import java.util.*;

public class Ex9 {
    public static void main(String[] args) {
        // Đọc từ file đầu vào
        try (Scanner scanner = new Scanner(new File("findnewpos.inp"))) {
            int n = scanner.nextInt();
            int pos = scanner.nextInt() - 1;

            int[] heights = new int[n];
            int[] indices = new int[n];
            for (int i = 0; i < n; i++) {
                heights[i] = scanner.nextInt();
                indices[i] = i;
            }

            // Tạo danh sách các học sinh với chiều cao và chỉ số gốc
            List<int[]> students = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                students.add(new int[]{heights[i], indices[i]});
            }

            // Sắp xếp danh sách học sinh
            students.sort((a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            });

            // Tìm vị trí mới của Tí
            int newPosition = 1; // Vị trí bắt đầu từ 1
            for (int[] student : students) {
                if (student[1] == pos) {
                    break;
                }
                newPosition++;
            }

            // Ghi kết quả vào file đầu ra
            try (PrintWriter writer = new PrintWriter(new FileWriter("findnewpos.out"))) {
                writer.println(newPosition);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
