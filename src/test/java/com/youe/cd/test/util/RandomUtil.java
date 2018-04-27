package com.youe.cd.test.util;

import java.util.Random;

public class RandomUtil {
    public static String getRandomString(int strLength) {
        Random random =  new Random();
        String str = "abcdefghijklmnopqrstuvwxyz";

        StringBuffer sb = new StringBuffer();

        for(int i= 0; i< strLength; i++){
            int pos = random.nextInt(26);
            sb.append(str.charAt(pos));
        }

        return sb.toString();
    }

    /*public static String getUniqueString() {
        //Random random =  new Random();
        String str = "abcdefghijklmnopqrstuvwxyz";

        StringBuffer sb = new StringBuffer();

        for(int i= 0; i< 26; i++) {
            for(int j= 0; j< 26; j++) {
                for(int l= 0; l< 26; l++) {
                    for (int m= 0; m< 26; m++) {
                        for (int n= 0; n<26; n++) {
                            sb.append(str.charAt(i));
                            sb.append(str.charAt(j));
                            sb.append(str.charAt(l));
                            sb.append(str.charAt(m));
                            sb.append(str.charAt(n));

                            System.out.println("当前坐标为：（" + i + ", " + j + ", " + l + ", " + m + ", " + n + "), 对应字串为: " + sb.toString());
                        }
                    }
                }

            }

        }

        return sb.toString();
    }*/

}
