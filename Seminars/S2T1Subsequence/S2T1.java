package Seminars.S2T1Subsequence;

/**
 * Найти общую подпоследовательность для двух заданных последовательностей.
 */
public class S2T1 {
    public static void main(String[] args) {
        String str =  "00000100012";
        String str2 = "001231000121";
        //0000100012
        System.out.println(getSet(str, str2).length());
    }
    public static String getSet(String str, String str2){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0, lastInd = 0; i < str.length(); i++) {
            for (int j = lastInd; j < str2.length(); j++) {
                if (str.charAt(i) == str2.charAt(j)){
                    stringBuilder.append(str2.charAt(j));
                    lastInd = j + 1;
                    break;
                }
            }
        }
        return stringBuilder.toString();
    }
    
}

