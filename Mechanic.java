import java.sql.SQLOutput;
import java.util.Scanner;
public class Mechanic {
    public static Scanner odczyt = new Scanner(System.in);

    public static int Shoot() {


        int trafienieX = odczyt.nextInt();
        int trafienieY = odczyt.nextInt();

        if (Board.board1[trafienieX-1][trafienieY-1] != 0) {
            System.out.println("Trafiłeś statek przeciwnika!");
            Board.board2[trafienieX-1][trafienieY-1] = 'X';
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(Board.board2[i][j]+" ");
                }
                System.out.println();
            }
            if(Board.board1[trafienieX-1][trafienieY-1]==1) {
                System.out.println("Trafiony, zatopiony!");
                --Ships.lenghtShip1;
            }
        }
        else{
            System.out.println("Pudło!");
            Board.board2[trafienieX-1][trafienieY-1] = '~';
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(Board.board2[i][j]+" ");
                }
                System.out.println();
            }
        }
        /*Tutaj zaczęłam robić porównywanie czy pola dookoła sa zarówno 2 w board1 i X w board2, działa ale wchuj roboty*/
        if ((Board.board1[trafienieX - 1][trafienieY - 1] == 2) && ((((Board.board1[trafienieX - 2][trafienieY - 1]) == 2)&&(Board.board2[trafienieX - 2][trafienieY - 1]) == 'X')) || ((Board.board1[trafienieX][trafienieY - 1] == 2) &&(Board.board2[trafienieX][trafienieY - 1]) == 'X')|| ((Board.board1[trafienieX - 1][trafienieY] == 2)&&(Board.board2[trafienieX - 1][trafienieY]) == 'X') || ((Board.board1[trafienieX - 1][trafienieY - 2] == 2)&&(Board.board2[trafienieX - 1][trafienieY - 2]) == 'X')){
            System.out.println("Trafiony,Zatopiony");
            --Ships.lenghtShip2;
        /*Sprawdza po samych X, ale jeśli koło siebie są statki np 4 i 2 to wtedy wypisuje "zatopiony" niezależnie od statku*/
        }else if((Board.board1[trafienieX-1][trafienieY - 1]==3) && ((((Board.board1[trafienieX - 3][trafienieY - 1]) == 3) && (Board.board1[trafienieX-2][trafienieY - 1] == 3)) || ((Board.board1[trafienieX ][trafienieY-1] == 3) && (Board.board1[trafienieX+1][trafienieY - 1] == 3))||((Board.board1[trafienieX-1][trafienieY - 2] == 3)&&(Board.board1[trafienieX-1][trafienieY - 3] == 3))||((Board.board1[trafienieX-1][trafienieY] == 3)&&(Board.board1[trafienieX-1][trafienieY +1] == 3)))){
            System.out.println("Trafiony,Zatopiony");
            --Ships.lenghtShip3;
        }
        else if((Board.board1[trafienieX-1][trafienieY - 1]==4)&&((Board.board1[trafienieX-2][trafienieY - 1] == 4)&&(Board.board1[trafienieX-3][trafienieY - 1] == 4)&&(Board.board1[trafienieX-4][trafienieY - 1] == 4))||((Board.board1[trafienieX][trafienieY - 1] == 4)&&(Board.board1[trafienieX+1][trafienieY - 1] == 4)&&(Board.board1[trafienieX][trafienieY +2] == 4))||((Board.board1[trafienieX-1][trafienieY - 2] == 4)&&(Board.board1[trafienieX-1][trafienieY - 2] == 4)&&(Board.board1[trafienieX-1][trafienieY - 3] == 4))||((Board.board1[trafienieX-1][trafienieY] == 4)&&(Board.board1[trafienieX-1][trafienieY +1] == 4)&&(Board.board1[trafienieX-1][trafienieY +2] == 4))){
            System.out.println("Trafiony,zatopiony");
            --Ships.lenghtShip4;
        }
        /*Nigdy mi się nie udało iks de*/
        System.out.println(Ships.lenghtShip1);
        if((Ships.lenghtShip1 == 0) && (Ships.lenghtShip2 == 0) && (Ships.lenghtShip3 == 0) && (Ships.lenghtShip4 == 0)){
                System.out.println("Zatopiłeś Wszystkie statki! Gratulacje!");
            }
    return Shoot();
}
}