package ru.geekbrains.lesson3;


       /* Написать программу, которая загадывает случайное число от 0 до 9,
       и пользователю дается 3 попытки угадать это число. При каждой попытке
       компьютер должен сообщить больше ли указанное пользователем число чем
       загаданное, или меньше. После победы или проигрыша выводится запрос –
       «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).*/

import java.util.Scanner;
public class HomeWork3 {
    public static void main(String[] args) {
        Scanner gm = new Scanner(System.in);
        String word = gm.nextLine();
        System.out.print("Угадай число от 0 до 9: ");
        int count = gm.nextInt();
        int a = 1;

        int random_number = a + (int) (Math.random() *10);
        for (int i = 1; i < 10; i++) {
            if (random_number > count) {
                System.out.println("Не верно:)! Мое число больше > твоего ");
                System.out.print("Какое число я загадал?: ");
                int n2 = gm.nextInt();


            } else if (random_number < count) {
                System.out.println("Не верно:)! Мое число меньше < твоего ");
                System.out.print("Какое число я загадал?: ");
                int n3 = gm.nextInt();

            } else {
                System.out.println("Урааа, ты угадал это число!: " + random_number);

            }
        }
    }
}

