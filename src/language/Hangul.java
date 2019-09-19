package language;

public class Hangul {

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

    // 모음
    private static final int VOWEL = 21;
    // 표음문자
    private static final int PHONOGRAM = 28;

    public static boolean isHangul(char c) {
        return c >= 0xAC00 && c <= 0xD7A3;
    }

    public static char[] split(char c) {
        char[] sub = new char[3];
        sub[0] = firstSounds[(c - 0xAC00) / (VOWEL * PHONOGRAM)]; //초성
        sub[1] = middleSounds[((c - 0xAC00) % (VOWEL * PHONOGRAM)) / PHONOGRAM]; //중성
        sub[2] = lastSounds[(c - 0xAC00) % (PHONOGRAM)];//종성
        return sub;
    }
}
