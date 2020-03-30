package ESTsoft;

public class Solution_03 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 4, 5, 3, 7}));
        System.out.println(solution(new int[]{1, 2, 3, 4}));
        System.out.println(solution(new int[]{1, 3, 1, 2}));
    }

    public static int solution(int[] A) {
        int check = 0;
        Boolean result = true;
        int count = 0;

        // return 0
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                if (check == 1) {
                    result = false;
                    break;
                }
                check = 1;
            } else if (A[i] > A[i + 1]) {
                if (check == -1) {
                    result = false;
                    break;
                }
                check = -1;
            } else {
                result = false;
                break;
            }
        }

        if (result) {
            return 0;
        }

        result = true;

        for (int i = 0; i < A.length; i++) {
            check = 0;
            for (int j = 0; j < A.length - 1; j++) {
                if (i != j) {
                    if (j + 1 == i) {
                        if (A[j] < A[j + 2]) {
                            if (check == 1) {
                                result = false;
                                break;
                            }
                            check = 1;
                        } else if (A[j] > A[j + 2]) {
                            if (check == -1) {
                                result = false;
                                break;
                            }
                            check = -1;
                        } else {
                            result = false;
                            break;
                        }
                    } else {
                        if (A[j] < A[j + 1]) {
                            if (check == 1) {
                                result = false;
                                break;
                            }
                            check = 1;
                        } else if (A[j] > A[j + 1]) {
                            if (check == -1) {
                                result = false;
                                break;
                            }
                            check = -1;
                        } else {
                            result = false;
                            break;
                        }
                    }
                }
            }

            if (result) {
                count++;
            }
        }

        if (count == 0) {
            return -1;
        }

        return count;
    }
}
