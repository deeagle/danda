package e03;
/*
Zu verwalten sei eine Menge von Zeichenketten (strings), die über dem Alphabet char =
{a, ..., z, A, ..., Z, 0, ...,9} gebildet werden. Sei S = 'x 1 , ... x n ', n > 0, x i ∈ char, 1 ≤ i ≤ n,
ein String. Dann ist n seine Länge. Für n = 0 wird S leerer String (S = ") genannt. Ein
Datentyp string stelle folgende Operationen zur Verfügung:

• append: fügt ein Zeichen am Anfang eines Strings an
• length: ermittelt die Länge eines Strings
• concat: konkateniert zwei Strings
• char_at: liefert das Zeichen an der gewählten Position eines Strings
Geben Sie eine algebraische Spezifikation string für Strings an.
 */
public class NString {
    public static void main(String args[]){

    }
    String s;
    NString(String s) {
        this.s = s;
    }
    NString(){
        s = "";
    }
    private void empty(){
        this.s = "";
    }
    private boolean isempty(String s){
        return s.isEmpty();
    }
    private void append(String s){
        s = s+this.s;
    }
    private int length(){
        return s.length();
    }
    private void concat(String s){
        this.s += s;
    }   
}
