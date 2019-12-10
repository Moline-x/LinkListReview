package Solution;

public class Solution1 {
    public static int[] plusOne(int[] digits) {
        if(digits.length == 1){
            digits[0] += 1;
            if(digits[0] == 10){
                digits[0] = 1;
                int[] newData = new int[2];
                newData[0] = digits[0];
                newData[1] = 0;
                return newData;
            }
            return digits;
        }
        for (int i = digits.length-1; i >=1 ; i--) {
            if(i==digits.length-1){
                digits[i] += 1;
            }
            if(digits[i] == 10){
                digits[i] -= 10;
                digits[i-1] +=1;
                if(i==1 && digits[i-1]==10){
                    i--;
                    digits[i] = 1;
                    int[] newData = new int[digits.length+1];
                    for (int j = 0; j < newData.length-1; j++) {
                        newData[j] = digits[j];
                    }
                    newData[newData.length-1] = 0;
                    return newData;
                }
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] arr = {9,9,9};
        int[] res = plusOne(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
