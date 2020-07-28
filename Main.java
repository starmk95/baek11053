import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] numbers = new int[cnt+1]; // 수열 담기
        int[] len = new int[cnt+1]; // 수열의 각 수에 대한 가장 긴 증가하는 부분 수열의 길이
        int maxLen = 0;
        for (int i=0;i<cnt;i++) {
            numbers[i+1] = sc.nextInt();
        }
        // Bottom-Up 방식
        // A[i] = 수열의 i번째 수까지 주어졌을 때, 가장 긴 증가하는 부분 수열
        // 점화식 : A[i] = A[j] + 1, j = 수열의 i-1번째 수까지 주어졌을 때, 가장 긴 증가하는 부분 수열의 마지막 수가 위치하는 인덱스
        for (int i=0;i<cnt+1;i++) {
            for (int j=0;j<i;j++) {
                if (numbers[j] < numbers[i] && len[i] < len[j]+1) {
                    len[i] = len[j] + 1;
                    if (maxLen < len[i]) {
                        maxLen = len[i];
                    }
                }
            }
        }
        System.out.println(maxLen);
    }
}
