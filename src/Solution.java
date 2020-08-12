import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {

    public static void main(String[] args) {

        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        List<Word> words = detectAllWords(crossword, "home", "same", "one");

        for (Word w: words) {
            System.out.println(w.toString());
        }
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();

        for (int element=0; element<words.length; element++) { //перебираем слова
            Word word = new Word(words[element]);
            char[] wordChar = word.text.toCharArray();
            for (int m=0; m < crossword.length; m++) {
                for (int n=0; n < crossword[m].length; n++) {
                    if (wordChar[0] == crossword[m][n]) { // 1ая совпавшая буква
                        word.setStartPoint(m,n);
                        if (word.text.length() == 1) {
                            Word copy = new Word(word.text);
                            copy.setStartPoint(word.startY, word.startX);
                            copy.setEndPoint(word.startY, word.startX);
                            list.add(copy);
                        }

                        int k = 0;
                            switch (k) { // проверяем все 8 направлений слова
                                //перебор вправо
                                case (0) : {
                                    if (word.startY + (word.text.length() - 1) < crossword[m].length) {
                                        boolean match = false;
                                        m = word.startX;
                                        n = word.startY;
                                        for (int l = 1; l < wordChar.length; l++) {
                                            n++;
                                            if (wordChar[l] != crossword[m][n]) {
                                                match = false;
                                                k++;
                                                break;
                                            } else if (wordChar[l] == crossword[m][n]) {
                                                match = true;
                                            }
                                        }

                                        if (match) {
                                            Word copy = new Word(word.text);
                                            copy.setStartPoint(word.startY, word.startX);
                                            copy.setEndPoint(n, m);
                                            list.add(copy);
                                        }
                                    }
                                    k++;
                                }
                                //перебор влево
                                case (1) : {
                                    if (0 <= word.startY - (word.text.length() - 1)) {
                                        boolean match = false;
                                        m = word.startX;
                                        n = word.startY;
                                        for (int l = 1; l < wordChar.length; l++) {
                                            n--;
                                            if (wordChar[l] != crossword[m][n]) {
                                                match = false;
                                                k++;
                                                break;
                                            } else if (wordChar[l] == crossword[m][n]) {
                                                match = true;
                                            }
                                        }

                                        if (match) {
                                            Word copy = new Word(word.text);
                                            copy.setStartPoint(word.startY, word.startX);
                                            copy.setEndPoint(n, m);
                                            list.add(copy);
                                        }
                                    }
                                    k++;
                                }
                                //перебор вниз
                                case (2) : {
                                    if (word.startX + (word.text.length() - 1) < crossword.length) {
                                        boolean match = false;
                                        m = word.startX;
                                        n = word.startY;
                                        for (int l = 1; l < wordChar.length; l++) {
                                            m++;
                                            if (wordChar[l] != crossword[m][n]) {
                                                match = false;
                                                k++;
                                                break;
                                            } else if (wordChar[l] == crossword[m][n]) {
                                                match = true;
                                            }
                                        }

                                        if (match) {
                                            Word copy = new Word(word.text);
                                            copy.setStartPoint(word.startY, word.startX);
                                            copy.setEndPoint(n, m);
                                            list.add(copy);
                                        }
                                    }
                                    k++;
                                }
                                //перебор вверх
                                case (3) : {
                                    if (0 <= word.startX - (word.text.length() - 1)) {
                                        boolean match = false;
                                        m = word.startX;
                                        n = word.startY;
                                        for (int l = 1; l < wordChar.length; l++) {
                                            m--;
                                            if (wordChar[l] != crossword[m][n]) {
                                                match = false;
                                                k++;
                                                break;
                                            } else if (wordChar[l] == crossword[m][n]) {
                                                match = true;
                                            }
                                        }

                                        if (match) {
                                            Word copy = new Word(word.text);
                                            copy.setStartPoint(word.startY, word.startX);
                                            copy.setEndPoint(n, m);
                                            list.add(copy);
                                        }
                                    }
                                    k++;
                                }
                                //перебор СВ
                                case (4) : {
                                    if (0 <= word.startX - (word.text.length() - 1) && word.startY + (word.text.length() - 1) < crossword[m].length) {
                                        boolean match = false;
                                        m = word.startX;
                                        n = word.startY;
                                        for (int l = 1; l < wordChar.length; l++) {
                                            n++;
                                            m--;
                                            if (wordChar[l] != crossword[m][n]) {
                                                match = false;
                                                k++;
                                                break;
                                            } else if (wordChar[l] == crossword[m][n]) {
                                                match = true;
                                            }
                                        }

                                        if (match) {
                                            Word copy = new Word(word.text);
                                            copy.setStartPoint(word.startY, word.startX);
                                            copy.setEndPoint(n, m);
                                            list.add(copy);
                                        }
                                    }
                                    k++;
                                }
                                //перебор ЮВ
                                case (5) : {
                                    if (word.startX + (word.text.length() - 1) < crossword.length && word.startY + (word.text.length() - 1) < crossword[m].length) {
                                        boolean match = false;
                                        m = word.startX;
                                        n = word.startY;
                                        for (int l = 1; l < wordChar.length; l++) {
                                            n++;
                                            m++;
                                            if (wordChar[l] != crossword[m][n]) {
                                                match = false;
                                                k++;
                                                break;
                                            } else if (wordChar[l] == crossword[m][n]) {
                                                match = true;
                                            }
                                        }

                                        if (match) {
                                            Word copy = new Word(word.text);
                                            copy.setStartPoint(word.startY, word.startX);
                                            copy.setEndPoint(n, m);
                                            list.add(copy);
                                        }
                                    }
                                    k++;
                                }
                                //перебор СЗ
                                case (6) : {
                                    if (0 <= word.startY - (word.text.length() - 1) && 0 <= word.startX - (word.text.length() - 1)) {
                                        boolean match = false;
                                        m = word.startX;
                                        n = word.startY;
                                        for (int l = 1; l < wordChar.length; l++) {
                                            n--;
                                            m--;
                                            if (wordChar[l] != crossword[m][n]) {
                                                match = false;
                                                k++;
                                                break;
                                            } else if (wordChar[l] == crossword[m][n]) {
                                                match = true;
                                            }
                                        }

                                        if (match) {
                                            Word copy = new Word(word.text);
                                            copy.setStartPoint(word.startY, word.startX);
                                            copy.setEndPoint(n, m);
                                            list.add(copy);
                                        }
                                    }
                                    k++;
                                }
                                //перебор ЮЗ
                                case (7) : {
                                    if (0 <= word.startY - (word.text.length() - 1) && word.startX + (word.text.length() - 1) < crossword.length) {
                                        boolean match = false;
                                        m = word.startX;
                                        n = word.startY;
                                        for (int l = 1; l < wordChar.length; l++) {
                                            n--;
                                            m++;
                                            if (wordChar[l] != crossword[m][n]) {
                                                match = false;
                                                k++;
                                                break;
                                            } else if (wordChar[l] == crossword[m][n]) {
                                                match = true;
                                            }
                                        }

                                        if (match) {
                                            Word copy = new Word(word.text);
                                            copy.setStartPoint(word.startY, word.startX);
                                            copy.setEndPoint(n, m);
                                            list.add(copy);
                                        }
                                    }
                                    k++;
                                }
                            }
                            m = word.startX;
                            n = word.startY;
                        }
                    }
                //}
            }
        }

        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
