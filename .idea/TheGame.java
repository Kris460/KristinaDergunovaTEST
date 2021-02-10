package CourseJava.Online;


import java.util.Random;
import java.util.Scanner;

public class TheGame {

        public static final int Size = 3;
        public static final int Win = 3;

        public static final char Empty = '.';
        public static final char Player1 = 'X';
        public static final char Player2 = 'O';

        public static Scanner input = new Scanner(System.in);
        public static char[][] gameField;

        public static void Field1() {
                gameField = new char[Size][Size];
                for (int i = 0; i < Size; i++) {
                        for (int j = 0; j < Size; j++) {
                                gameField[i][j] = Empty;
                        }
                }
        }

        public static void Field2() {
                for (int i = 0; i <= gameField.length; i++) {
                        System.out.print(i == 0 ? "  " : i + " ");
                }
                System.out.println();
                for (int i = 0; i < gameField.length; i++) {
                        System.out.print((i + 1) + " ");
                        for (int j = 0; j < gameField.length; j++) {
                                System.out.print(gameField[i][j] + " ");
                        }
                        System.out.println();
                }
                System.out.println();
        }

        public static boolean available (int x, int y) {
                return x >= 0 && x < Size && y >= 0 && y < Size && gameField[y][x] == Empty;
        }

        public static void player1Move() {
                int x, y;
                do {
                        System.out.printf("Введите координаты хода через пробел  X(= 1..3) Y(= 1..3):\n", Size, Size);
                        x = Integer.valueOf(input.next()) - 1;
                        y = Integer.valueOf(input.next()) - 1;
                } while (!available(x, y));
                gameField[y][x] = Player1;
        }

        public static void player2Move() {
                int x, y;
                do {
                        x = new Random().nextInt(Size);
                        y = new Random().nextInt(Size);
                } while (!available(x, y));
                System.out.println("ИИ походил в ячейку " + (x + 1) + " " + (y + 1));
                gameField[y][x] = Player2;
        }

        public static boolean win(char playerDot) {
                int hor, ver;
                int diagMain, diagReverse;
                for (int i = 0; i < Size; i++) {
                        hor = 0;
                        ver = 0;
                        for (int j = 0; j < Size; j++) {
                                if (gameField[i][j] == playerDot) {
                                        hor++;
                                } else if (gameField[i][j] != playerDot && hor < Win) {
                                        hor = 0;
                                }
                                if (gameField[j][i] == playerDot) {
                                }   else if (gameField[j][i] != playerDot && ver < Win) {
                                        ver = 0;
                                }
                        }
                        if (hor >= Win || ver >= Win) {
                                System.out.println("По горизонтали или вертикали " + hor + " " + ver);
                                return true;
                        }
                }

                for (int j = 0; j < Size; j++) {
                        diagMain = 0;
                        for (int i = 0; i < Size; i++) {
                                int k = j + i;
                                if (k < Size) {
                                        if (gameField[i][k] == playerDot) {
                                                diagMain++;
                                        } else if (gameField[i][k] != playerDot && diagMain < Win) {
                                                diagMain = 0;
                                        }
                                }
                                if (diagMain >= Win) {
                                        System.out.println("По диагонали " + diagMain);
                                        return true;
                                }
                        }
                }
                for (int j = 1; j < Size; j++) {
                        diagMain = 0;
                        for (int i = 0; i < Size; i++) {
                                int k = j + i;
                                if (k < Size) {
                                        if (gameField[k][i] == playerDot) {
                                                diagMain++;
                                        } else if (gameField[k][i] != playerDot && diagMain < Win) {
                                                diagMain = 0;
                                        }
                                }
                                if (diagMain >= Win) {
                                        System.out.println("По диагонали " + diagMain);
                                        return true;
                                }
                        }
                }
                for (int j = 0; j < Size; j++) {
                        diagReverse = 0;
                        for (int i = 0; i < Size; i++) {
                                int k = (Size - 1) - i;
                                int l = j + i;
                                if (k >= 0 && l < Size) {
                                        if (gameField[l][k] == playerDot) {
                                                diagReverse++;
                                        } else if (gameField[l][k] != playerDot && diagReverse < Win) {
                                                diagReverse = 0;
                                        }
                                }
                                if (diagReverse >= Win) {
                                        System.out.println("По диагонали " + diagReverse);
                                        return true;
                                }
                        }
                }
                for (int j = 1; j < Size; j++) {
                        diagReverse = 0;
                        for (int i = 0; i < Size; i++) {
                                int k = (Size - 1) - j - i;
                                if (k >= 0) {
                                        if (gameField[i][k] == playerDot) {
                                                diagReverse++;
                                        } else if (gameField[i][k] != playerDot && diagReverse < Win) {
                                                diagReverse = 0;
                                        }
                                }
                                if (diagReverse >= Win) {
                                        System.out.println("По диагонали " + diagReverse);
                                        return true;
                                }
                        }
                }
                return false;
        }

        public static boolean isDraw() {
                for (char[] aGameField : gameField) {
                        for (int j = 0; j < gameField.length; j++) {
                                if (aGameField[j] == Empty) {
                                        return false;
                                }
                        }
                }
                return true;
        }

        public static void main(String[] args) {
                Field1();
                System.out.printf("Цель игры - заполнить подряд линию по вертикали, горизонтали или диагонали.\n", Win, (Win % 10 == 1 && Win % 100 != 11) ? "его" : "их", (Win % 10 == 1 && Win % 100 != 11) ? "а" : "ов");
                Field2();

                switch (new Random().nextInt(2)) {
                        case 0: {
                                System.out.println("Ваш ход");
                                while (true) {
                                        player1Move();
                                        Field2();
                                        if (win(Player1)) {
                                                System.out.println("Победил Игрок 1");
                                                break;
                                        }
                                        if (isDraw()) {
                                                System.out.println("Ничья");
                                                break;
                                        }
                                        player2Move();
                                        Field2();
                                        if (win(Player2)) {
                                                System.out.println("Победил ИИ");
                                                break;
                                        }
                                        if (isDraw()) {
                                                System.out.println("Ничья");
                                                break;
                                        }
                                }
                                break;
                        }
                        case 1: {
                                System.out.println("Первый ход ИИ!");
                                while (true) {
                                        player2Move();
                                        Field2();
                                        if (win(Player2)) {
                                                System.out.println("Победил ИИ");
                                                break;
                                        }
                                        if (isDraw()) {
                                                System.out.println("Ничья");
                                                break;
                                        }
                                        player1Move();
                                        Field2();
                                        if (win(Player1)) {
                                                System.out.println("Победил Игрок 1");
                                                break;
                                        }
                                        if (isDraw()) {
                                                System.out.println("Ничья");
                                                break;
                                        }
                                }
                        }
                }
        }

}



