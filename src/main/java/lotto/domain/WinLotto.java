package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class WinLotto {
    private static List<Integer> inputWinningNumber;
    private static boolean isCorrectLottoNumber, isCorrectBonusNumber;
    public static void inputWinningNumber() {
        //당첨 번호 및 보너스 번호 입력
        while(!isCorrectLottoNumber){
            System.out.println("당첨 번호를 입력해 주세요.");
            inputWinningNumber = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(readLine(), ",");
            while(st.hasMoreElements()){
                int num = Integer.valueOf(st.nextToken());
                inputWinningNumber.add(num);
            }
            validateLottoError();
        }
    }

    private static void validateLottoError() {
        try{
            new Lotto(inputWinningNumber);
            isCorrectLottoNumber = true;
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 올바른 번호를 입력해 주세요.");
        }
    }

    public static void inputBonusNumber() {
        while(!isCorrectBonusNumber){
            System.out.println("보너스 번호를 입력해 주세요.");
            int bonusNumber = Integer.valueOf(readLine());

            validateBonusError(bonusNumber);
        }
    }

    private static void  validateBonusError(int bonusNumber){
        try{
            if(bonusNumber < 1 || bonusNumber > 45){
                throw new IllegalArgumentException();
            } else if(inputWinningNumber.contains(bonusNumber)){
                throw new IllegalArgumentException();
            }
            isCorrectBonusNumber = true;
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 올바른 번호를 입력해 주세요.");
        }
    }
}
