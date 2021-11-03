package com.github;
import java.util.Random;
import java.util.Scanner;

public class MainTicTac {

static Random random = new Random();
static Scanner scan = new Scanner(System.in);

public static int[] party = new int[9]; //Основной массив где хранятся данные партии
public static int motion = 0; //Определяет ход компьютера

    public static void main(String[] args) {

        byte b = (byte) (random.nextInt(2) + 1);//Розыгрыш 1 хода
        boolean r = true;

        System.out.println("Уровень сложности Impossible");
        System.out.println("Положение цифр Numpad соответствует положению клеток");
        System.out.println("Ход достаётся случайным образом");
        out();//Вывод партии в консоль
        ///////////////////////////////////////////////////////////////////////

        while(r){
            if(b == 1){ //Если компьютер ходит первым
                motion = 1;

                UnRealAlgorithm.registerChanges(party);//Обращение в регистр изменений UnReal алгоритма
                out();

                b = 0;
            }

            if(UnRealAlgorithm.Tac != "Win"){
              motion++;

              System.out.print("Ваш ход: ");
              int v = scan.nextInt();
              switch(v){
                  case 1: party[6] = 2;  ;break; //Если записано значение 0 то клетка пуста
                  case 2: party[7] = 2;  ;break; //Если записано значение 1 то ход компьютера
                  case 3: party[8] = 2;  ;break; //Если записано значение 2 то ход человека

                  case 4: party[3] = 2;  ;break;
                  case 5: party[4] = 2;  ;break;
                  case 6: party[5] = 2;  ;break;

                  case 7: party[0] = 2;  ;break;
                  case 8: party[1] = 2;  ;break;
                  case 9: party[2] = 2;  ;break;
              }

              UnRealAlgorithm.registerChanges(party);
              out();
            }
            //////////////////////////////////////////////////////////////
            if(UnRealAlgorithm.Tac == "Win") { //Выход из цикла
                System.out.println("Вы проиграли");
                r = false;
            }
            if(UnRealAlgorithm.Tac == "No") { //Выход из цикла
                System.out.println("Ничья");
                r = false;
            }
        }
        scan.close();
    }//Основной цикл программы
    static void out(){
        int j = 0;
        for (int i = 0; i < 9; i++) {
            if(party[i] == 1){System.out.print("X  ");}
            if(party[i] == 2){System.out.print("O  ");}
            if(party[i] == 0){System.out.print("_  ");}

            j++;
            if(j % 3 == 0){ System.out.println();}
        }
    }//Вывод партии в консоль
}
