package ESTsoft;

import java.util.HashSet;

public class Solution_04 {
    public static void main(String[] args) {
        System.out.print(solution("John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker", "Example"));
    }

    public static String solution(String S, String C) {
        String[] name = S.split("; ");
        C = "@" + C.toLowerCase() + ".com";

        HashSet<String> email = new HashSet<>();
        String mail;
        String result = "";

        for (int i = 0; i < name.length; i++) {
            String[] temp = name[i].split(" ");

            // 이름 두 단어
            if (temp.length == 2) {
                mail = temp[1].toLowerCase().replace("-", "") + "_" + temp[0].toLowerCase();
            }
            // 이름 세 단어
            else {
                mail = temp[2].toLowerCase().replace("-", "") + "_" + temp[0].toLowerCase();
            }

            if (email.contains(mail)) {
                int cnt = 2;
                mail += "" + cnt;

                while (email.contains(mail)) {
                    String before = "" + cnt;
                    String after = "" + (cnt + 1);
                    mail = mail.replace(before, after);
                }
            }

            email.add(mail);

            result += name[i] + " <" + mail + C + ">" + "; ";
        }

        result = result.substring(0, result.length() - 2);

        return result;
    }
}
