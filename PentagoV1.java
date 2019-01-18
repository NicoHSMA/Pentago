import java.util.*;
public class PentagoV1 {
int[] [] feld = new int [6] [6];
int zug = 1;
public void Spielen() {
    erzeugeSpielfeld();
    System.out.println("Pentago");
    System.out.println("Spielregeln: Die Spieler sind abwechselnd an der Reihe. Wer zuerst 3 Steine in einer Reihe hat gewinnt das Spiel");     
    ausgabeSpielfeld();
    while (gewonnen((zug % 2)+1) == false ) {       
    zug++;
    setzeStein((zug % 2)+1);
    ausgabeSpielfeld();        
    }
}

 public void setzeStein(int Spieler) {     
     int i=0;
     int eingabe;
     int frei = 5;
     System.out.println("Spieler "+Spieler+" Spalte:");
     Scanner eingabewert = new Scanner(System.in);
     eingabe = eingabewert.nextInt();
     
     if (eingabe > 5) {
        System.out.println("Das ist keine Zahl zwischen 0 und 5! Vielleicht hast du ja in der nächsten Runde dazugelernt :-)"); 
        i=6;
     }    
    
     while (i<6) {    
         if (feld[frei][eingabe] == 0) {
         feld[frei][eingabe] = Spieler;
         i=6;
         }
         else {
         frei--;
         i++;
         }
     }
}

public boolean gewonnen(int Spieler) {
    for (int i=0;i<6;i++) {
        for (int j=0; j<6;j++) {
            if (horizontal(Spieler,i,j) || vertikal(Spieler,i,j) || schräg(Spieler,i,j)) {
                System.out.println("Spieler " +Spieler+ " hat gewonnen");    
                return true;
                    
            }
        }
    }
    return false;
}

public boolean horizontal(int Spieler,int i,int j) {
    if (j>3) {
    j = j - 3;
    }
    if (feld[i][j]==Spieler && feld[i][j+1]==Spieler && feld[i][j+2]==Spieler) {
        return true;
    }
    else return false;
}

public boolean vertikal(int Spieler,int i, int j) {
        if (i>3) {
    i = i - 3;
    }
    if (feld[i][j]==Spieler && feld[i+1][j]==Spieler && feld[i+2][j]==Spieler) {
        return true;
    }
    else return false;
}

public boolean schräg(int Spieler, int i, int j) {
    if (schrägLinksOben(Spieler,i,j) || schrägRechtsOben(Spieler,i,j)) {
        return true;
    }
    return false;
}

public boolean schrägLinksOben(int Spieler, int i, int j) {
    if (j<3 || i>3) {
        return false;
    }
    if (feld[i][j]==Spieler && feld[i+1][j-1]==Spieler && feld[i+2][j-2]==Spieler) {
        return true;
    }
    else return false;
}

public boolean schrägRechtsOben(int Spieler, int i, int j) {
    if (j>3 || i>3) {
        return false;
    }
    if (feld[i][j]==Spieler && feld[i+1][j+1]==Spieler && feld[i+2][j+2]==Spieler) {
        return true;
    }
    else return false;
}

public void erzeugeSpielfeld() {       
    
    for(int x=0; x < 6; x++) {
        for(int y=0; y < 6; y++) {
        feld[x][y] = 0;
        }
}
}

public void ausgabeSpielfeld() {
System.out.println("Bitte wähle eine Zahl zwischen 0 und 5"); 
System.out.println("\n");
System.out.print("  0    1    2    3    4    5\n");          
    
    for(int x=0; x < 6; x++) {
        for(int y=0; y < 6; y++) { 
                System.out.print("| " + feld[x][y] + " |");  
        }
        System.out.println("\n");  
}
}

}
// 3227 Zeichen
