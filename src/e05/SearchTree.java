package e05;

import java.util.Stack;

// Bin�rer Suchbaum, der aus einzelnen Node-Objekten aufgebaut ist.
// Jeder Wert kann im Baum nur einmal vorkommen.
public class SearchTree
{
	//Referenz auf die Wurzel des Baumes
	private Node root;

	// Konstruktor zum Erzeugen des leeren Baumes
	public SearchTree()
	{
		root = null;
	}
	
	// Methode zum Einf�gen eines Nodes in den Baum
	public void insert(int value)
	{
		Node toAdd = new Node(value);
        Node found = root;
        if(isEmpty()){
            root = toAdd;
            return;
        }
        if(member(value)){
            System.out.println("Value bereits vorhanden!");
        }else{
            while(found.left != null || found.right != null){
                if(value < found.data){
                    if(found.left == null){
                        break;
                    }
                    found = found.left;
                }else if(value > found.data){
                    if(found.right == null){
                        break;
                    }
                    found = found.right;
                }
            }
            if(value < found.data){
                found.left = toAdd;
            }else{
                found.right = toAdd;
            }
        }
	}
	
	// L�scht Knoten mit dem �bergebenen Wert aus dem Baum, falls ein
	// solcher vorhanden ist.
	public void delete(int value)
	{
		Node toDelete = find(value);
		
		// Node nicht gefunden
		if (toDelete == null)
		{
			return;
		}
		else
		{	
			// Wenn zu l�schender Knoten nichtleere linke und rechte
			// Teilb�ume hat, wird der zu l�schende Knoten durch das 
			// kleinste Node des rechten Teilbaumes ersetzt
			if ( toDelete.left != null && toDelete.right != null )
			{
				SearchTree temp = new SearchTree();
				temp.root = toDelete;
				Node minRightTree = temp.rightTree().getMin();
				
				toDelete.data = minRightTree.data;
				if (toDelete.right == minRightTree)
				{
					toDelete.right = minRightTree.right;
				}
				else
				{
					temp.rightTree().delete(minRightTree.data);
				}
			}
			else
			{
				Node parent = findParent(toDelete);
				
				// Zu l�schender Knoten ist ein Blatt
				if (toDelete.left == null && toDelete.right == null)
				{
					// Zu l�schendes Node ist die Wurzel
					if (parent == null)
						root = null;
					else if (parent.left == toDelete)
						parent.left = null;
					else
						parent.right = null;
				}
				else
				{
					// Zu l�schender Knoten ist die Wurzel
					if (parent == null)
					{
						if (toDelete.left == null)
							root = toDelete.right;
						else
							root = toDelete.left;
					}
					else if (parent.left == toDelete)
					{
						if (toDelete.left == null)
							parent.left = toDelete.right;
						else
							parent.left = toDelete.left;
					}
					else  // parent.right == toDelete
					{
						if (toDelete.left == null)
							parent.right = toDelete.right;
						else
							parent.right = toDelete.left;
					}
				}
			}	
		}
	}

	// Hilfsmethode, nur aus delete() heraus benutzt
	// liefert den minimalen Knoten eines bin�ren Suchbaums
	private Node getMin()
	{
	    Node mostLeft = root;
		while(mostLeft.left != null){
            mostLeft = mostLeft.left;
        }
        return mostLeft;
	}
	
	// Hilfsmethode, nur aus delete() heraus benutzt
	// liefert zu einem gegebenen Knoten child den Vater-Knoten
	private Node findParent(Node child)
	{
	    Node parent = root;
		while(parent.left != null || parent.right != null){
		    if(parent.left != null){
                if(child.data == parent.left.data){
                    return parent;
                }
            }
            if(parent.right != null){
                if(child.data == parent.right.data){
                    return parent;
                }
            }
            if(parent.data < child.data && parent.left != null){
                parent = parent.left;
            }else if(parent.data > child.data && parent.right != null){
                parent = parent.right;
            }else{
                System.out.println("Kein Parent gefunden");
                return null;
            }
        }
        System.out.println("Kein Parent gefunden");
        return null;
	}
		
	// Testet, ob der Baum leer ist.
	public boolean isEmpty()
	{
		return root == null;
	}
	
	// Sucht einen Knoten mit dem �bergebenen Wert im Suchbaum. Wenn ein
	// solcher vorhanden ist, wird eine Referenz auf diesen Knoten
	// zur�ckgegeben, sonst null.
	public Node find(int value)
	{
	    Node found = root;
	    if(isEmpty()){
	        return null;
        }
        while(found.left != null || found.right != null){
            if(found.data == value){
                return found;
            }
            if(value <  found.data){
                if(found.left == null){
                    return null;
                }
                found = found.left;
            }else if(value > found.data){
                if(found.right == null){
                    return null;
                }
                found = found.right;
            }else{
                return null;
            }
        }
        return null;
	}
	
	// Pr�ft, ob ein Knoten mit dem �bergebenen Wert im Baum vorhanden ist
	public boolean member(int value)
	{
		return find(value) != null;
	}
	
	public SearchTree leftTree()
	{
		if ( root == null)
		{
			System.out.println("Der leere Baum hat keinen linken Teilbaum!");
			return null;
		}
		SearchTree leftTree = new SearchTree();
		leftTree.root = this.root.left;
		return leftTree;
	}
	
	public SearchTree rightTree()
	{
		if ( root == null)
		{
			System.out.println("Der leere Baum hat keinen rechten Teilbaum!");
			return null;
		}
		SearchTree rightTree = new SearchTree();
		rightTree.root = this.root.right;
		return rightTree;
	}
			
	// Gibt die preorder - Darstellung eines Baumes als String zur�ck
    public String preorder() {
        // Base Case
        if (root == null) {
            return "";
        }
        String pre = "";
        // Create an empty stack and push root to it
        Stack<Node> nodeHelpStack = new Stack<Node>();
        nodeHelpStack.push(root);

        /* Pop all items one by one. Do following for every popped item
         a) print it
         b) push its right child
         c) push its left child
         Note that right child is pushed first so that left is processed first */
        while (!nodeHelpStack.empty()) {

            // Pop the top item from stack and print it
            Node mynode = nodeHelpStack.peek();
           pre += mynode.data + " ";
            nodeHelpStack.pop();

            // Push right and left children of the popped node to stack
            if (mynode.right != null) {
                nodeHelpStack.push(mynode.right);
            }
            if (mynode.left != null) {
                nodeHelpStack.push(mynode.left);
            }
        }
        return pre;
    }
	
	// Gibt die inorder - Darstellung eines Baumes als String zur�ck
    public String inorder() {
        if (root == null) {
            return "";
        }
        String in = "";
        //keep the nodes in the path that are waiting to be visited
        Stack<Node> stack = new Stack<Node>();
        Node nodeHelp = root;

        //first nodeHelp to be visited will be the left one
        while (nodeHelp != null) {
            stack.push(nodeHelp);
            nodeHelp = nodeHelp.left;
        }

        // traverse the tree
        while (stack.size() > 0) {

            // visit the top nodeHelp
            nodeHelp = stack.pop();
            in += nodeHelp.data + " ";
            if (nodeHelp.right != null) {
                nodeHelp = nodeHelp.right;

                // the next nodeHelp to be visited is the leftmost
                while (nodeHelp != null) {
                    stack.push(nodeHelp);
                    nodeHelp = nodeHelp.left;
                }
            }
        }
        return in;
    }
	
	// Gibt die postorder - Darstellung eines Baumes als String zur�ck
	public String postorder()
	{
       /*
        1. Push root to first stack.
        2. Loop while first stack is not empty
           2.1 Pop a node from first stack and push it to second stack
           2.2 Push left and right children of the popped node to first stack
        3. Print contents of second stack
        */
       Stack<Node> stack1 = new Stack<>();
       Stack<Node> stack2 = new Stack<>();

       stack1.push(root);
       Node nodehelp;
       String post = "";

       while(!stack1.isEmpty()){
           nodehelp = stack1.pop();

           stack2.push(nodehelp);

           if(nodehelp.left != null){
               stack1.push(nodehelp.left);
           }
           if(nodehelp.right != null){
               stack1.push(nodehelp.right);
           }
       }
       while(!stack2.isEmpty()){
           nodehelp = stack2.pop();
           post += nodehelp.data+" ";
       }
        return post;
	}
	
	// Gibt die Werte der Knoten des Baumes im Breitendurchlauf 
	// als String zur�ck
	public String levelorder()
	{
		ElementQueue eq = new ElementQueue();

		Node nodeHelp;
		String level = "";
        eq.enqueue(root);
        while(!eq.isEmpty()){
            nodeHelp = eq.dequeue();
            level += nodeHelp.data+ " ";
            if(nodeHelp.left != null){
                eq.enqueue(nodeHelp.left);
            }
            if(nodeHelp.right != null){
                eq.enqueue(nodeHelp.right);
            }
        }
        return level;
	}
		
	// main-Methode zum Testen
	public static void main(String[] args)
	{
		SearchTree st = new SearchTree();
		st.insert(2);
		st.insert(10);
		st.insert(-6);
		st.insert(4);
		st.insert(46);
		st.insert(0);
		st.insert(2);
		st.insert(5);
		st.insert(-5);
		st.insert(4);
		st.insert(7);
		st.insert(11);
		st.insert(1);
		
		System.out.println("\n preorder:");
		System.out.println("<" + st.preorder() + ">");
		
		System.out.println(" inorder:");
		System.out.println("<" + st.inorder() + ">");
		
		System.out.println(" postorder:");
		System.out.println("<" + st.postorder() + ">");
		
		System.out.println(" breitendurchlauf:");
		System.out.println("<" + st.levelorder() + ">");
		
		st.delete(0);
		st.delete(8);
		st.delete(2);
		st.delete(4);
		st.delete(11);
		
		System.out.println("\n preorder:");
		System.out.println("<" + st.preorder() + ">");
		
		System.out.println(" inorder:");
		System.out.println("<" + st.inorder() + ">");
		
		System.out.println(" postorder:");
		System.out.println("<" + st.postorder() + ">");
		
		System.out.println(" breitendurchlauf:");
		System.out.println("<" + st.levelorder() + ">");
	}
}