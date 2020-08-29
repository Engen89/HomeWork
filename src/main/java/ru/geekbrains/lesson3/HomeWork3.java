package ru.geekbrains.lesson3;

/*Написать программу, которая загадывает случайное число от 0 до 9,
 и пользователю дается 3 попытки угадать это число. При каждой попытке
  компьютер должен сообщить больше ли указанное пользователем число
  чем загаданное, или меньше. После победы или проигрыша выводится
  запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет)
 */


import java.util.Scanner;
import java.lang.Math;
public class HomeWork3 {

    public static void main(String[] args) {

        games();
        Scanner input = new Scanner(System.in);
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        int UserChoice = input.nextInt();
        if (UserChoice == 1) {
            games();
        }

    }

    public static void games (){

        int UnknownNumber, UserNumber, TrysCount = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("ЗАДАЧА: Угадать число (от 0 до 9).");

        UnknownNumber = (int) Math.floor(Math.random() * 10);


        do {
            TrysCount++;

            System.out.print("Введите ваше число: ");

            UserNumber = input.nextInt();

            if (UserNumber > UnknownNumber)
                System.out.println("Моё число меньше.");

            else if (UserNumber < UnknownNumber)
                System.out.println("Моё число больше.");

            else
                System.out.println("Вы угадали!");

        } while (UserNumber != UnknownNumber && TrysCount < 3);
    }
}

