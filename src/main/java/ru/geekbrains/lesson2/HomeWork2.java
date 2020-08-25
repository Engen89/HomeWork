package ru.geekbrains.lesson2;

public class HomeWork2 {
    public static void main(String[] args) {
        invertArray();
        fillArray();
        changeArray();
        fillDiagonal();
        MaxMinArr();
        checkBalance();
    }

    /*1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
   public static void invertArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 1) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
            System.out.println("позиция " + i + " " + arr[i]);
        }
    }
    /*2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
     */

    public static void fillArray() {
        int[] arr = new int[8];
        arr[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i-1]+3;
            System.out.println(arr[i]);
        }
    }

        /*3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
         */

    public static void changeArray() {
        int[] w = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < w.length; i++) {
            if (w[i] < 6) {
                w[i] = w[i] * 2;
            }
            System.out.println(w[i]);
        }
    }

        /*4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
         заполнить его диагональные элементы единицами;
         */

    public static void fillDiagonal() {
        int[][] table = new int[5][5];
        for (int i = 0; i < table.length; i++) {
            for (int j = table.length - 1; j > -1; j--) {
                if (i + j == table.length - 1 || i == j) {
                    table[i][j] = 1;
                }
                System.out.print(table[i][j] + "  ");
            }
            System.out.println();
        }
    }

        /*5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета); */

    public static void MaxMinArr() {
        int[] a = {4, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int max = a[0];
        int min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]){
                max = a[i];
            }
            if (min > a[i]){
                min = a[i];
            }
        }
        System.out.print(max + " " + min);
    }

        /*6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
         если в массиве есть место, в котором сумма левой и правой части массива равны.
         Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
         граница показана символами ||, эти символы в массив не входят.
         */
        public static void checkBalance() {
            int[] a = {2, 2, 2, 1, 2, 2, 10, 1};
            int sumLeft = a[0];
            int j = a.length - 1;
            int sumRigth = a[j];
            for (int i = 1; i < a.length; i++) {
                sumLeft += a[i];
                j--;
                sumRigth += a[j];
                if (sumLeft == sumRigth) {
                    System.out.print(sumLeft + " true " + sumRigth);
                    return;
                }
            }

        }

        /*7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
        или отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи
        нельзя пользоваться вспомогательными массивами.
         */
}