package language;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hangul {
    private Hangul() {
    }

    //초성
    private static final char[] firstSounds = {
            'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ',
            'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ',
            'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'
    };

    //중성
    private static final char[] middleSounds = {
            'ㅏ', 'ㅐ', 'ㅑ', 'ㅒ', 'ㅓ', 'ㅔ', 'ㅕ', 'ㅖ',
            'ㅗ', 'ㅘ', 'ㅙ', 'ㅚ', 'ㅛ', 'ㅜ', 'ㅝ', 'ㅞ', 'ㅟ', 'ㅠ', 'ㅡ',
            'ㅢ', 'ㅣ'
    };

    //종성
    private static final char[] lastSounds = {
            ' ', 'ㄱ', 'ㄲ', 'ㄳ', 'ㄴ', 'ㄵ', 'ㄶ', 'ㄷ',
            'ㄹ', 'ㄺ', 'ㄻ', 'ㄼ', 'ㄽ', 'ㄾ', 'ㄿ', 'ㅀ', 'ㅁ',
            'ㅂ', 'ㅄ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'
    };
    private static final Map<Character, char[]> hangulKeyMap = new HashMap<>();

    private static void init() {
        hangulKeyMap.put('ㅘ', new char[]{'ㅗ', 'ㅏ'});
        hangulKeyMap.put('ㅙ', new char[]{'ㅗ', 'ㅐ'});
        hangulKeyMap.put('ㅚ', new char[]{'ㅗ', 'ㅣ'});
        hangulKeyMap.put('ㅝ', new char[]{'ㅜ', 'ㅓ'});
        hangulKeyMap.put('ㅞ', new char[]{'ㅜ', 'ㅔ'});
        hangulKeyMap.put('ㅟ', new char[]{'ㅜ', 'ㅣ'});
        hangulKeyMap.put('ㅢ', new char[]{'ㅡ', 'ㅣ'});
        hangulKeyMap.put('ㄳ', new char[]{'ㄱ', 'ㅅ'});
        hangulKeyMap.put('ㄵ', new char[]{'ㄴ', 'ㅈ'});
        hangulKeyMap.put('ㄶ', new char[]{'ㄴ', 'ㅎ'});
        hangulKeyMap.put('ㄺ', new char[]{'ㄹ', 'ㄱ'});
        hangulKeyMap.put('ㄻ', new char[]{'ㄹ', 'ㅁ'});
        hangulKeyMap.put('ㄼ', new char[]{'ㄹ', 'ㅂ'});
        hangulKeyMap.put('ㄽ', new char[]{'ㄹ', 'ㅅ'});
        hangulKeyMap.put('ㄾ', new char[]{'ㄹ', 'ㅌ'});
        hangulKeyMap.put('ㄿ', new char[]{'ㄹ', 'ㅍ'});
        hangulKeyMap.put('ㅀ', new char[]{'ㄹ', 'ㅎ'});
        hangulKeyMap.put('ㅄ', new char[]{'ㅂ', 'ㅅ'});
    }

    static {
        init();
    }

    // 모음
    private static final int VOWEL = 21;
    // 표음문자
    private static final int PHONOGRAM = 28;

    private static void addToList(ArrayList<Character> list, char c) {
        if (hangulKeyMap.containsKey(c)) {
            for (char character : hangulKeyMap.get(c))
                list.add(character);
        } else {
            list.add(c);
        }
    }

    public static boolean isHangul(char c) {
        return c >= 0xAC00 && c <= 0xD7A3;
    }

    public static ArrayList<Character> split(char c) {
        char[] sub = new char[3];
        sub[0] = firstSounds[(c - 0xAC00) / (VOWEL * PHONOGRAM)]; //초성
        sub[1] = middleSounds[((c - 0xAC00) % (VOWEL * PHONOGRAM)) / PHONOGRAM]; //중성
        sub[2] = lastSounds[(c - 0xAC00) % (PHONOGRAM)]; //종성
        ArrayList<Character> arrayList = new ArrayList();
        for (char character : sub) {
            addToList(arrayList, character);
        }
        return arrayList;
    }
}