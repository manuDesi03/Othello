class Oth {
    char[][] tabella;
    private final int DIM = 8;
    private final char ch = 'X';
    private final char ch2 = 'O';

    public Oth() {
        tabella = new char[DIM][DIM];
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                tabella[i][j] = '-';
            }
        }

        // Posizioni iniziali dei pezzi
        tabella[3][3] = 'X';
        tabella[3][4] = 'O';
        tabella[4][3] = 'O';
        tabella[4][4] = 'X';
    }

    public void stampa() {
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                System.out.print(tabella[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean estMoveValid(int r, int col, char player) {
        if (tabella[r][col] != '-') {
            return false;
        }

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if (estDirectionValid(r, col, player, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean estDirectionValid(int r, int col, char player, int riga, int colonna) {
        int rigaAttuale = r + riga;
        int colAttuale = col + colonna;

        while (rigaAttuale >= 0 && rigaAttuale < DIM && colAttuale >= 0 && colAttuale < DIM) {
            char cellaAtt = tabella[rigaAttuale][colAttuale];

            if (cellaAtt == player) {
                return tabella[r][col] != player;
            }

            if (cellaAtt == '-') {
                return false;
            }

            rigaAttuale += riga;
            colAttuale += colonna;
        }

        return false;
    }

    public char change(char player) {
        if(player == 'X') {
            player = 'O';
        }
        else {
            player = 'X';
        }
        return player;
    }

    public char control(int r, int col, char player) {
        if(r == 0) {
            if(col == 0) {
                if(tabella[r][col+1] != player && tabella[r+1][col] != player) {
                    tabella[r][col] = player;
                    player = change(player);
                    scambiaPedina(r, col, player);
                }
            }
            else if(col != 7){
                if(tabella[r][col-1] != player && tabella[r][col+1] != player && tabella[r+1][col] != player) {
                    tabella[r][col] = player;
                    player = change(player);
                    scambiaPedina(r, col, player);
                }
            }
            else {
                if(tabella[r][col-1] != player &&  tabella[r+1][col] != player) {
                    tabella[r][col] = player;
                    player = change(player);
                    scambiaPedina(r, col, player);
                }
            }
        }

        if(r == 7) {
            if(col == 0) {
                if(tabella[r][col+1] != player && tabella[r-1][col] != player) {
                    tabella[r][col] = player;
                    player = change(player);
                    scambiaPedina(r, col, player);
                }
            }
            else if(col != 7){
                if(tabella[r][col-1] != player && tabella[r][col+1] != player && tabella[r-1][col] != player) {
                    tabella[r][col] = player;
                    player = change(player);
                    scambiaPedina(r, col, player);
                }
            }
            else {
                if(tabella[r][col-1] != player &&  tabella[r-1][col] != player) {
                    tabella[r][col] = player;
                    player = change(player);
                    scambiaPedina(r, col, player);
                }
            }
        }

        if(r == 7) {
            if(col == 7) {
                if(tabella[r][col-1] != player && tabella[r-1][col] != player) {
                    tabella[r][col] = player;
                    player = change(player);
                    scambiaPedina(r, col, player);
                }
            }
            else if(col != 0){
                if(tabella[r][col-1] != player && tabella[r][col+1] != player && tabella[r-1][col] != player) {
                    tabella[r][col] = player;
                    player = change(player);
                    scambiaPedina(r, col, player);
                }
            }
            else {
                if(tabella[r][col+1] != player &&  tabella[r-1][col] != player) {
                    tabella[r][col] = player;
                    player = change(player);
                    scambiaPedina(r, col, player);
                }
            }
        }

        if(col == 7) {
            if(r == 0) {
                if(tabella[r][col-1] != player && tabella[r+1][col] != player) {
                    tabella[r][col] = player;
                    player = change(player);
                    scambiaPedina(r, col, player);
                }
            }
            else if(r != 7){
                if(tabella[r][col-1] != player && tabella[r+1][col] != player && tabella[r-1][col] != player) {
                    tabella[r][col] = player;
                    player = change(player);
                    scambiaPedina(r, col, player);
                }
            }
            else {
                if(tabella[r][col-1] != player &&  tabella[r-1][col] != player) {
                    tabella[r][col] = player;
                    player = change(player);
                    scambiaPedina(r, col, player);
                }
            }
        }

        if(col == 0) {
            if(r == 0) {
                if(tabella[r][col+1] != player && tabella[r+1][col] != player) {
                    tabella[r][col] = player;
                    player = change(player);
                    scambiaPedina(r, col, player);
                }
            }
            else if(r != 7){
                if(tabella[r][col+1] != player && tabella[r+1][col] != player && tabella[r-1][col] != player) {
                    tabella[r][col] = player;
                    player = change(player);
                    scambiaPedina(r, col, player);
                }
            }
            else {
                if(tabella[r][col+1] != player &&  tabella[r-1][col] != player) {
                    tabella[r][col] = player;
                    player = change(player);
                    scambiaPedina(r, col, player);
                }
            }
        }
        return player;
    }

    public char makeMove(int r, int col, char player) {
        if (!estMoveValid(r, col, player)) {
            System.out.println("Mossa non valida. Riprova.");
        }
        else if(r == 0 || r == 7 || col == 0 || col == 7) {
            player = control(r, col, player);
        }
        else if(tabella[r][col-1] != player && tabella[r-1][col] != player && tabella[r][col+1] != player && tabella[r+1][col] != player) {
            tabella[r][col] = player;
            player = change(player);
            scambiaPedina(r, col, player);
        }
        return player;
    }

    private void scambiaPedina(int r, int col, char player) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if(estDirectionValid(r, col, player, i, j)) {
                    int rigaAttuale = r + i;
                    int colAttuale = col + j;

                    while (tabella[rigaAttuale][colAttuale] != player) {
                        tabella[rigaAttuale][colAttuale] = player;
                        rigaAttuale += i;
                        colAttuale += j;
                    }
                }

                //PROBLEMA SCAMBIO PEDINA --> NON SCAMBIA O SE SCAMBIA SBAGLIA  
            }
        }
    }

    public void mod() {
        int modalita;
        do
        {
            System.out.println("Inserire 1 per giocare contro un player e 2 per giocare contro un bot");
            modalita = Leggi.unInt();
        }
        while(modalita < 1 || modalita > 2);

        if(modalita == 1) {
            play();
        }
        else {
            System.out.println("Ci dispiace... Gli sviluppatori si son dimenticati della parte del bot");
        }
    }

    public int contaPedine(char ch) {
        int cnt = 0;
        for(int i = 0; i < 7; i++) {
            for(int k = 0; k < 7; k++) {
                if(tabella[i][k] == ch) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public int contaPedineO(char ch2) {
        return contaPedine(ch2);
    }

    public void vincitore(int pedineX, int pedineO) {
        int vincita = pedineX - pedineO;
        if(vincita < 0) {
            System.out.println("Ha vinto il giocatore O");
            System.exit(0);
        }
        else {
            System.out.println("Ha vinto il giocatore X");
            System.exit(0);
        }
    }

    public boolean controlloFine() {
        boolean x = false;
        for(int i = 0; i < DIM-1; i++) {
            for(int k = 0; k < DIM-1; k++) {
                if(tabella[i][k] == '-') {
                    x = false;
                    return x;
                }
                else {
                    x = true;
                }
            }
        }
        return x;
    }

    public void play() {
        char currentPlayer = 'X';

        boolean x;

        while (true) {
            x = controlloFine();
            if(x == true) {
                int pedineX = contaPedine(ch);
                int pedineO = contaPedineO(ch2);
                vincitore(pedineX, pedineO);
            }
            else {
                System.out.println("Turno del giocatore " + currentPlayer);
                stampa();

                // Input del giocatore
                System.out.print("Inserisci la riga: ");
                int row = Leggi.unInt();
                System.out.print("Inserisci la colonna: ");
                int col = Leggi.unInt();

                // Esegui la mossa
                currentPlayer = makeMove(row, col, currentPlayer);
            }
        }
    }
}