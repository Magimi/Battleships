import java.util.Scanner;
public class Mechanic {

    public static Scanner odczyt = new Scanner(System.in);



    public static int Shoot() {

        System.out.println("Podaj współrzędną X(1-10)");
        int trafienieX = odczyt.nextInt();
        System.out.println("Podaj współrzędną Y(1-10)");
        int trafienieY = odczyt.nextInt();


        if (trafienieX > 0 && trafienieX < 11 && trafienieY > 0 && trafienieY < 11) {
            if (Board.board1[trafienieX - 1][trafienieY - 1] != 0) {
                System.out.println("Trafiłeś statek przeciwnika!");
                Board.board2[trafienieX - 1][trafienieY - 1] = 'X';
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        System.out.print(Board.board2[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();


                if (Board.board1[trafienieX - 1][trafienieY - 1] == 1) {
                    if(Ships.lenghtShip1>0) {
                        System.out.println("Trafiony, zatopiony!");
                        --Ships.lenghtShip1;
                    }
                }
            }
            else {
                System.out.println("Pudło!");
                Board.board2[trafienieX - 1][trafienieY - 1] = '~';
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        System.out.print(Board.board2[i][j] + " ");
                    }
                    System.out.println();
                }
            }
            /*Dla statków o długości 2 ten sposób jest spoko bo sa tylko 2 możliwości zatopienia, git gut*/
            if (Board.board1[trafienieX - 1][trafienieY - 1] == 2) {
                if (trafienieX - 2 >= 0 && trafienieX < 10) {
                    if (((Board.board1[trafienieX - 2][trafienieY - 1] == 2) && ((Board.board2[trafienieX - 2][trafienieY - 1]) == 'X')) || ((Board.board1[trafienieX][trafienieY - 1] == 2) && ((Board.board2[trafienieX][trafienieY - 1]) == 'X'))) {
                        if(Ships.lenghtShip2>0) {
                            System.out.println("Trafiony,Zatopiony");
                            --Ships.lenghtShip2;
                        }
                    }
                } else if (trafienieY - 2 >= 0 && trafienieY < 10) {
                    if ((Board.board1[trafienieX - 1][trafienieY] == 2 && ((Board.board2[trafienieX - 1][trafienieY]) == 'X')) || ((Board.board1[trafienieX - 1][trafienieY - 2] == 2) && ((Board.board2[trafienieX - 1][trafienieY - 2]) == 'X'))) {
                        if(Ships.lenghtShip2>0) {
                            System.out.println("Trafiony,Zatopiony");
                            --Ships.lenghtShip2;
                        }
                    }
                }
                /*dla trójek 3 sposoby rozpisane, działa ale szukam czegoś krótszego*/
            }
            else if (Board.board1[trafienieX - 1][trafienieY - 1] == 3) {
                if (((trafienieX - 3) >= 0) && ((trafienieX - 2) >= 0) && (trafienieX < 10) && ((trafienieX + 1) < 10)) {
                    if ((((Board.board1[trafienieX - 3][trafienieY - 1] == 3) && (Board.board2[trafienieX - 3][trafienieY - 1] == 'X')) && ((Board.board1[trafienieX - 2][trafienieY - 1] == 3) && (Board.board2[trafienieX - 2][trafienieY - 1] == 'X'))) || (((Board.board1[trafienieX][trafienieY - 1] == 3) && (Board.board2[trafienieX][trafienieY - 1] == 'X')) && ((Board.board1[trafienieX + 1][trafienieY - 1] == 3) && (Board.board2[trafienieX + 1][trafienieY - 1] == 'X')))||(((Board.board1[trafienieX-2][trafienieY-1]==3)&&(Board.board2[trafienieX-2][trafienieY-1]=='X'))&&(Board.board1[trafienieX][trafienieY-1]==3)&&(Board.board2[trafienieX][trafienieY-1]=='X'))) {
                        if(Ships.lenghtShip3>0) {
                            System.out.println("Trafiony,Zatopiony");
                            --Ships.lenghtShip3;
                        }
                    }
                } else if ((((trafienieY - 2) >= 0) && ((trafienieY - 3) >= 0) && (trafienieY < 10) && ((trafienieY + 1) < 10))) {
                    if ((((Board.board1[trafienieX - 1][trafienieY - 3] == 3) && (Board.board2[trafienieX - 1][trafienieY - 3] == 'X')) && ((Board.board1[trafienieX - 1][trafienieY - 2] == 3) && (Board.board2[trafienieX - 1][trafienieY - 2] == 'X'))) || (((Board.board1[trafienieX - 1][trafienieY] == 3) && (Board.board2[trafienieX - 1][trafienieY] == 'X')) && ((Board.board1[trafienieX - 1][trafienieY + 1] == 3) && (Board.board2[trafienieX - 1][trafienieY + 1] == 'X')))||(((Board.board1[trafienieX-1][trafienieY-2]==3)&&(Board.board2[trafienieX-1][trafienieY-2]=='X'))&&(Board.board1[trafienieX-1][trafienieY]==3)&&(Board.board2[trafienieX-1][trafienieY]=='X'))) {
                        if(Ships.lenghtShip3>0) {
                            System.out.println("Trafiony,Zatopiony");
                            --Ships.lenghtShip3;
                        }
                    }

                }
                /*Statki o długości 4 mają 4 opcje trafienia i zatopienia, wchuj dużo warunków, niżej są tylko 2 przypadki(kiedy trafimy końcowe współrzedne statku), szukam nowego sposobu*/
            }
            else if (Board.board1[trafienieX - 1][trafienieY - 1] == 4) {
                if (((((trafienieX - 4) >= 0) && ((trafienieX - 3) >= 0) && ((trafienieX - 2) >= 0) && (trafienieX < 10) && ((trafienieX + 1) < 10) && ((trafienieX + 2) < 10)))) {
                    if ((((Board.board1[trafienieX - 4][trafienieY - 1] == 4) && (Board.board2[trafienieX - 4][trafienieY - 1] == 'X')) && ((Board.board1[trafienieX - 3][trafienieY - 1] == 4) && (Board.board2[trafienieX - 3][trafienieY - 1] == 'X')) && ((Board.board1[trafienieX - 2][trafienieY - 1] == 4) && (Board.board2[trafienieX - 2][trafienieY - 1] == 'X'))) || (((Board.board1[trafienieX][trafienieY - 1] == 4) && (Board.board2[trafienieX][trafienieY - 1] == 'X')) && ((Board.board1[trafienieX + 1][trafienieY - 1] == 4) && (Board.board2[trafienieX + 1][trafienieY - 1] == 'X')) && ((Board.board1[trafienieX + 2][trafienieY - 1] == 4) && (Board.board2[trafienieX + 2][trafienieY - 1] == 'X')))) {
                        if(Ships.lenghtShip4>0) {
                            System.out.println("Trafiony,Zatopiony");
                            --Ships.lenghtShip4;
                        }
                    }
                    else if(((Board.board1[trafienieX - 2][trafienieY - 1] == 4) && (Board.board2[trafienieX - 2][trafienieY - 1] == 'X')) && ((Board.board1[trafienieX][trafienieY - 1] == 4) && (Board.board2[trafienieX][trafienieY - 1] == 'X')) && ((Board.board1[trafienieX + 1][trafienieY - 1] == 4) && (Board.board2[trafienieX + 1][trafienieY - 1] == 'X')))
                    {
                        if(Ships.lenghtShip4>0) {
                            System.out.println("Trafiony,Zatopiony");
                            --Ships.lenghtShip4;
                        }
                    }
                    else if(((Board.board1[trafienieX - 3][trafienieY - 1] == 4) && (Board.board2[trafienieX - 3][trafienieY - 1] == 'X')) && ((Board.board1[trafienieX - 2][trafienieY - 1] == 4) && (Board.board2[trafienieX - 2][trafienieY - 1] == 'X')) && ((Board.board1[trafienieX][trafienieY - 1] == 4) && (Board.board2[trafienieX][trafienieY - 1] == 'X')))
                    {
                        if(Ships.lenghtShip4>0) {
                            System.out.println("Trafiony,Zatopiony");
                            --Ships.lenghtShip4;
                        }
                    }
                } else if ((trafienieY - 4 >= 0) && ((trafienieY - 3) >= 0) && ((trafienieY - 2) >= 0) && (trafienieY < 10) && ((trafienieY + 1) < 10) && ((trafienieY + 2) < 10)) {
                    if ((((Board.board1[trafienieX - 1][trafienieY - 4] == 4) && (Board.board2[trafienieX - 1][trafienieY - 4] == 'X')) && ((Board.board1[trafienieX - 1][trafienieY - 3] == 4) && (Board.board2[trafienieX - 1][trafienieY - 3] == 'X')) && ((Board.board1[trafienieX - 1][trafienieY - 2] == 4) && (Board.board2[trafienieX - 1][trafienieY - 2] == 'X'))) || (((Board.board1[trafienieX - 1][trafienieY] == 4) && (Board.board2[trafienieX - 1][trafienieY] == 'X')) && ((Board.board1[trafienieX - 1][trafienieY + 1] == 4) && (Board.board2[trafienieX - 1][trafienieY + 1] == 'X')) && ((Board.board1[trafienieX = 1][trafienieY + 2] == 4) && (Board.board2[trafienieX - 1][trafienieY + 2] == 'X')))) {
                        if (Ships.lenghtShip4 > 0) {
                            System.out.println("Trafiony,Zatopiony");
                            --Ships.lenghtShip4;
                        }
                    }
                    /* tylko to gówno nie działa*/
                    else if(((Board.board1[trafienieX - 1][trafienieY - 2] == 4) && (Board.board2[trafienieX - 1][trafienieY - 2] == 'X')) && ((Board.board1[trafienieX - 1][trafienieY] == 4) && (Board.board2[trafienieX - 1][trafienieY] == 'X')) && ((Board.board1[trafienieX - 1][trafienieY + 1] == 4) && (Board.board2[trafienieX - 1][trafienieY + 1] == 'X')))
                    {
                        if(Ships.lenghtShip4>0) {
                            System.out.println("Trafiony,Zatopiony");
                            --Ships.lenghtShip4;
                        }
                    }
                    else if(((Board.board1[trafienieX - 1][trafienieY - 3] == 4) && (Board.board2[trafienieX - 1][trafienieY - 3] == 'X')) && ((Board.board1[trafienieX - 1][trafienieY - 2] == 4) && (Board.board2[trafienieX - 1][trafienieY - 2] == 'X')) && ((Board.board1[trafienieX - 1][trafienieY] == 4) && (Board.board2[trafienieX - 1][trafienieY] == 'X')))
                    {
                        if(Ships.lenghtShip4>0) {
                            System.out.println("Trafiony,Zatopiony");
                            --Ships.lenghtShip4;
                        }
                    }
                }
            }


            System.out.println("Statki ciągle znajdujące się na mapie:");
            System.out.println("Statki o długości 4:" + Ships.lenghtShip4 + " " + "Statki o długości 3:" + Ships.lenghtShip3 + " " + "Statki o długości 2:" + Ships.lenghtShip2 + " " + "Statki o długości 1:" + Ships.lenghtShip1);
            if ((Ships.lenghtShip1 == 0) && (Ships.lenghtShip2 == 0) && (Ships.lenghtShip3 == 0) && (Ships.lenghtShip4 == 0)) {
                System.out.println("Zatopiłeś Wszystkie statki! Gratulacje!");
            }
            return Shoot();
        }

        else{
            System.out.println("Chyba nie chcesz strzelać do Polaków poza mapą?");

            return Shoot();
        }
    }
}
