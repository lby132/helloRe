package mvcre.hello.lotto;

public class LottoTest {
    public static void main(String[] args) {
        int lotto[] = new int[6];

        //번호 생성
        for (int i = 0; i < 6; i++) {
            lotto[i] = (int) (Math.random() * 45) + 1;

            //번호 중복 제거
            for (int j = 0; j < 6; j++) {
                if (lotto[i] == lotto[j]) {
                    i--;
                    break;
                }
            }
        }
        System.out.println("로또 번호");

        //번호 출력
        for (int i = 0; i < 6; i++) {
            System.out.println(lotto[i]);
        }
    }
}
