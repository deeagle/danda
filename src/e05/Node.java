package e05;

// Einzelner Knoten (Node) eines Baums (Trees)
class Node
{
	// Der int-Wert (Schluessel), der die Daten des Knotens repr�sentiert
	public int data;

	// Referenz auf linken Sohn
	public Node left;

	// Referenz auf rechten Sohn
	public Node right;

	// Konstruktor, dem der Schluesselwert des Knotens �bergeben wird.
	public Node(int value)
	{
		data = value;
	}
}
