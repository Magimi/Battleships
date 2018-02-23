public class Board {

    public static int board1[][] = new int[11][11];
    public static char board2[][] = new char[11][11];                                                                   /*Plansza 10x10 ale tablice na 11x11 bo gdzieś tam mi błąd wyjebywało IDC*/


    public static void InitialBoard() {
        for (int i = 0; i < 10; i++) {                                                                                  /* Wyświetlanie tablicy statków rozmieszczonych przez komputer*/
            for (int j = 0; j < 10; j++) {
                board1[i][j] = 0;
                System.out.print(board1[i][j]+" ");
            }
            System.out.println();
        }
        for (int i = 0; i < 10; i++) {                                                                                  /*Zapisanie tablicy gracza*/
            for (int j = 0; j < 10; j++) {
                board2[i][j] = 'o';
            }
        }
    }

    public static void PlacementShip4() {

        int x = Randomize.rint(0, 9);                                                                                   /*Umieszczenie największego statku jako pierwszego*/
        int y = Randomize.rint(0, 9);

        if (x - 1 >= 0 && x - 2 >= 0 && x - 3 >= 0) {
            board1[x][y] = 4;
            board1[x - 1][y] = 4;
            board1[x - 2][y] = 4;
            board1[x - 3][y] = 4;

        } else if (x + 1 < 10 && x + 2 < 10 && x + 3 < 10) {
            board1[x][y] = 4;
            board1[x + 1][y] = 4;
            board1[x + 2][y] = 4;
            board1[x + 3][y] = 4;
            board1[x + 4][y] = 4;
        } else if (y - 1 >= 0 && y - 2 >= 0 && x - 3 >= 0) {
            board1[x][y] = 4;
            board1[x][y - 1] = 4;
            board1[x][y - 2] = 4;
            board1[x][y - 3] = 4;

        } else {
            board1[x][y] = 4;
            board1[x][y + 1] = 4;
            board1[x][y + 2] = 4;
            board1[x][y + 3] = 4;
        }
    }

    public static void PlacementShip3() {

        /*Umieszczenie wszystkich statków o wielkości 3*/
        while (Ships.quantityShip3 > 0) {
            int x = Randomize.rint(1, 9);
            int y = Randomize.rint(1, 9);

            /*Warunek czy wylosowana komórka będzie miała wystarczającą ilośc miejsca w kolumnie na umieszczenie statuku o długosci 3*/
            if (((((y - 2) >= 0) && ((y - 1) >= 0)&&((y - 3)>=0)) && (((y + 1) < 10) && ((y + 2) < 10)&& ((y + 3 )<10))) && (((board1[x][y - 1] == 0) && (board1[x][y - 2] == 0)) || ((board1[x][y + 1] == 0) && (board1[x][y - 1] == 0))))
            {
                /*Sprawdzenie czy pola nie są już zajęte*/
                if ((board1[x][y - 2] == 0) && (board1[x][y - 2] == 0) && (board1[x][y] == 0) && ((y - 1) >= 0)) {
                    board1[x][y] = 3;
                    board1[x][y - 1] = 3;
                    board1[x][y - 2] = 3;
                    --Ships.quantityShip3;
                } else if ((board1[x][y + 2] == 0) && (board1[x][y + 1] == 0) && (board1[x][y] == 0) && ((y + 1) < 10)) {
                    board1[x][y] = 3;
                    board1[x][y + 1] = 3;
                    board1[x][y + 2] = 3;
                    --Ships.quantityShip3;
                }
            }
            /*Warunek czy wylosowana komórka będzie posiadała wystarczająco miejsca w wierszu na umieszczenie statku o długości 3*/
            else if (((((x - 2) >= 0) && ((x - 1) >= 0)) && (((x + 2) < 9) && ((x + 1) < 9))) && ((board1[x - 1][y] == 0) || (board1[x + 1][y] == 0)))
            {
                if (((board1[x][y] == 0) && (board1[x - 1][y] == 0)) && (board1[x - 2][y] == 0) && ((x - 1) >= 0)) {
                    board1[x][y] = 3;
                    board1[x - 1][y] = 3;
                    board1[x - 2][y] = 3;
                    --Ships.quantityShip3;
                } else if ((board1[x][y] == 0) && (board1[x + 1][y] == 0) && (board1[x + 2][y] == 0) && ((x + 1) < 10)) {
                    board1[x][y] = 3;
                    board1[x + 1][y] = 3;
                    board1[x + 2][y] = 3;
                    --Ships.quantityShip3;
                }
            }
        }
    }
    /*Umieszczenie wszystkich statków o wielkości 2*/
    public static void PlacementShip2() {

        while (Ships.quantityShip2 > 0) {
            int x = Randomize.rint(0, 9);
            int y = Randomize.rint(0, 9);
            /*Warunek czy wylosowana komórka będzie miała wystarczającą ilośc miejsca w kolumnie na umieszczenie statuku o długosci 2*/
            if (((((y - 1) >= 0) && ((y - 2) >= 0)) && (((y + 1) < 10) && ((y + 2) < 10))) && ((board1[x][y - 1] == 0) || (board1[x][y + 1] == 0)))
            {
                /*Sprawdzenie czy pola nie są już zajęte*/
                if ((board1[x][y - 1] == 0) && (board1[x][y] == 0) && ((y - 1) >= 0)) {
                    board1[x][y] = 2;
                    board1[x][y - 1] = 2;
                    --Ships.quantityShip2;
                } else if ((board1[x][y + 1] == 0) && (board1[x][y] == 0) && ((y + 1) < 10)) {
                    board1[x][y] = 2;
                    board1[x][y + 1] = 2;
                    --Ships.quantityShip2;
                }
            }
            /*Warunek czy wylosowana komórka będzie miała wystarczającą ilośc miejsca w kolumnie na umieszczenie statuku o długosci 2*/
            else if (((((x - 1) >= 0) && ((x - 2) >= 0)) && (((x + 1) < 10) && ((x + 2) < 10))) && ((board1[x - 1][y] == 0) || (board1[x + 1][y] == 0)))
            {
                if (((board1[x][y] == 0) && (board1[x - 1][y] == 0)) && ((x - 1) >= 0)) {
                    board1[x][y] = 2;
                    board1[x - 1][y] = 2;
                    --Ships.quantityShip2;
                } else if ((board1[x][y] == 0) && (board1[x + 1][y] == 0) && ((x + 1) < 10)) {
                    board1[x][y] = 2;
                    board1[x + 1][y] = 2;
                    --Ships.quantityShip2;

                }
            }
        }
    }
    /*Umieszczenie wszystkich statków o wielkości 1*/
    public static void PlacementShip1() {

        while (Ships.quantityShip1 > 0) {
            int x = Randomize.rint(1, 9);
            int y = Randomize.rint(1, 9);

            if (board1[x][y] == 0) {
                board1[x][y] = 1;
                --Ships.quantityShip1;
                /*Sprawdzenie czy pola nie są już zajęte*/
            } else if ((((y - 1) >= 0) || ((y + 1) < 10)) && ((board1[x][y - 1] == 0) || (board1[x][y + 1] == 0))) {
                if (board1[x][y - 1] == 0 && ((y - 1) >= 0)) {
                    board1[x][y - 1] = 1;
                    --Ships.quantityShip1;
                } else if ((board1[x][y + 1] == 0) && ((y + 1) < 10)) {
                    board1[x][y + 1] = 1;
                    --Ships.quantityShip1;
                }
            } else if ((((x - 1) >= 0) || ((x + 1) < 10)) && ((board1[x - 1][y] == 0) || (board1[x + 1][y] == 0))) {
                if ((board1[x - 1][y] == 0) && ((x - 1) >= 0))
                    board1[x - 1][y] = 1;
                --Ships.quantityShip1;
            } else if (board1[x + 1][y] == 0 && ((x + 1) < 10)) {
                board1[x + 1][y] = 1;
                --Ships.quantityShip1;
            }
        }
//Tablica Sprawdzająca(Do usunięcia)
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(board1[i][j] + " ");
            }
            System.out.println();
        }

    }
}





