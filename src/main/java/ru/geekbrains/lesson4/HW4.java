package ru.geekbrains.lesson4;

import java.util.Random;
import java.util.Scanner;

public class HW4 {
    static final int SIZE = 5;
//    static final int DOT_TO_WIN = 3;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if(checkWin(DOT_X)){
                System.out.println("Вы победили! Поздравляем!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printMap();
            if(checkWin(DOT_O)){
                System.out.println("Компьютер победил.");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }
        }

    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= map.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < map[i].length; j++) {
                System.out.printf("%c ", map[i][j]);
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x;
        int y;

        do {
            System.out.println("input X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x));

        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int y, int x) {
        if (y < 0 || x < 0 || y >= SIZE || x >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
//        if (map[y][x] == DOT_EMPTY) {
//            return true;
//        } else {
//            return false;
//        }
    }

    public static void aiTurn() {
        int x;
        int y;

        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(y, x));

        map[y][x] = DOT_O;
    }

    public static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkWin(char c) {
        // проверка победы по вертикали
        for (int y = 0; y <=1 ; y++) {
            for (int i = 0; i < SIZE; i++) {
                if (map[i][y] == c && map[i][y+1] == c && map[i][y+2] == c && map[i][y+3] == c) {return true; }
            }
        }
        // проверка победы по горизонтали
        for (int x = 0; x <=1 ; x++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[x][j] == c && map[x+1][j] == c && map[x+2][j] == c && map[x+3][j] == c) {return true; }
            }
        }
        // проверка победы по диагонали 1
        int x = 0;
        for (int y = 0; y <= 1; y++) {
            if (map[x][y] == c && map[x+1][y+1] == c && map[x+2][y+2] == c && map[x+3][y+3] == c) {return true; }
            if (map[x+1][y] == c && map[x+2][y+1] == c && map[x+3][y+2] == c && map[x+4][y+3] == c) {return true; }
        }
        // проверка победы по диагонали 2
        for (int y = 0; y <= 1; y++) {
            if (map[x+4][y] == c && map[x+3][y+1] == c && map[x+2][y+2] == c && map[x+1][y+3] == c) {return true; }
            if (map[x+3][y] == c && map[x+2][y+1] == c && map[x+1][y+2] == c && map[x][y+3] == c) {return true; }
        }
        return false;
    }

}
