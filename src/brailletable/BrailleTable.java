package brailletable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrailleTable {

    // ---------------------------------------- Tables group (0004) ----------------------------------------

    // #0004-A
    public static List<String> brailleList() {
        List<String> list = new ArrayList<String>();
        String[] chars = new String[]{
            "⠀","⠁","⠂","⠃","⠄","⠅","⠆","⠇",
            "⠈","⠉","⠊","⠋","⠌","⠍","⠎","⠏",
            "⠐","⠑","⠒","⠓","⠔","⠕","⠖","⠗",
            "⠘","⠙","⠚","⠛","⠜","⠝","⠞","⠟",
            "⠠","⠡","⠢","⠣","⠤","⠥","⠦","⠧",
            "⠨","⠩","⠪","⠫","⠬","⠭","⠮","⠯",
            "⠰","⠱","⠲","⠳","⠴","⠵","⠶","⠷",
            "⠸","⠹","⠺","⠻","⠼","⠽","⠾","⠿"
        };
        for (int i = 0; i < chars.length; i++) {
            list.add(chars[i]);
        }
        return list;
    }

    // #0004-BA
    public static List<List<Integer>> binaryList() {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int number = 0; number < 64; number++) {
            String binaryText = toBinaryPadded(number);
            List<Integer> bits = new ArrayList<Integer>();
            
            for (int i = 0; i < binaryText.length(); i++) {
                char charAt = binaryText.charAt(i);
                bits.add(Character.getNumericValue(charAt));
            }
            result.add(bits);
        }
        return result;
    }

    // #0004-BB
    public static List<List<Integer>> reverseBinaryList() {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int number = 0; number < 64; number++) {
            String binaryText = toBinaryPadded(number);
            List<Integer> bits = new ArrayList<Integer>();
            
            for (int i = binaryText.length() - 1; i >= 0; i--) {
                char charAt = binaryText.charAt(i);
                bits.add(Character.getNumericValue(charAt));
            }
            result.add(bits);
        }
        return result;
    }

    // #0004-CA
    public static List<String> binaryStringList() {
        List<String> result = new ArrayList<String>();
        for (int number = 0; number < 64; number++) {
            result.add(toBinaryPadded(number));
        }
        return result;
    }

    // #0004-CB
    public static List<String> reverseBinaryStringList() {
        List<String> result = new ArrayList<String>();
        for (int number = 0; number < 64; number++) {
            String binaryText = toBinaryPadded(number);
            
            StringBuilder sb = new StringBuilder();
            for (int i = binaryText.length() - 1; i >= 0; i--) {
                sb.append(binaryText.charAt(i));
            }
            result.add(sb.toString());
        }
        return result;
    }

    // #0004-D
    public static List<String> unicodeList() {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < 64; i++) {
            int code = 0x2800 + i;

            String hex = Integer.toHexString(code);
            while (hex.length() < 4) {
                hex = "0" + hex;
            }
            result.add(hex);
        }
        return result;
    }

    // #0004-E
    public static List<Integer> dotCount() {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < 64; i++) {
            
            result.add(Integer.bitCount(i));
        }
        return result;
    }

    // #0004-F
    public static List<List<Integer>> dotNumberingList() {
        List<List<Integer>> lst = new ArrayList<List<Integer>>();
        for (int i = 0; i < 64; i++) {
            List<Integer> dots = new ArrayList<Integer>();
            for (int d = 0; d < 6; d++) {
                if (((i >> d) & 1) == 1) {
                    dots.add(d + 1);
                }
            }
            lst.add(dots);
        }
        return lst;
    }

    // #0004-G
    public static List<String> dotNumberingStringList() {
        List<List<Integer>> allDots = dotNumberingList();
        List<String> result = new ArrayList<String>();

        for (int i = 0; i < allDots.size(); i++) {
            List<Integer> dots = allDots.get(i);
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < dots.size(); j++) {
                sb.append(dots.get(j));
                if (j < dots.size() - 1) {
                    sb.append("-"); 
                }
            }
            result.add(sb.toString());
        }
        return result;
    }

    // ---------------------------------------- Mapping group (0003) ----------------------------------------

    // #0003-AA
    public static int getBrailleToIndex(String braille) {
        Map<String, Integer> brailleToIndex = new HashMap<String, Integer>();
        String[] chars = new String[]{
            "⠀","⠁","⠂","⠃","⠄","⠅","⠆","⠇",
            "⠈","⠉","⠊","⠋","⠌","⠍","⠎","⠏",
            "⠐","⠑","⠒","⠓","⠔","⠕","⠖","⠗",
            "⠘","⠙","⠚","⠛","⠜","⠝","⠞","⠟",
            "⠠","⠡","⠢","⠣","⠤","⠥","⠦","⠧",
            "⠨","⠩","⠪","⠫","⠬","⠭","⠮","⠯",
            "⠰","⠱","⠲","⠳","⠴","⠵","⠶","⠷",
            "⠸","⠹","⠺","⠻","⠼","⠽","⠾","⠿"
        };
        
        for (int i = 0; i < chars.length; i++) {
            brailleToIndex.put(chars[i], i);
        }
        
        Integer index = brailleToIndex.get(braille);
        if (index == null) {
            throw new IllegalArgumentException("Invalid braille character: " + braille);
        }
        return index.intValue();
    }

    // #0003-AB
    public static String getIndexToBraille(int index) {
        List<String> list = brailleList();
        return list.get(index);
    }

    // #0003-B
    public static List<Integer> getBrailleListToIndexList(List<String> brailleList) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < brailleList.size(); i++) {
            result.add(getBrailleToIndex(brailleList.get(i)));
        }
        return result;
    }

    // ---------------------------------------- Helper Methods ----------------------------------------

    private static String toBinaryPadded(int number) {
        String binary = Integer.toBinaryString(number);
        StringBuilder sb = new StringBuilder();
        int paddingNeeded = 6 - binary.length();
        
        for (int i = 0; i < paddingNeeded; i++) {
            sb.append('0');
        }
        sb.append(binary);
        return sb.toString();
    }
}