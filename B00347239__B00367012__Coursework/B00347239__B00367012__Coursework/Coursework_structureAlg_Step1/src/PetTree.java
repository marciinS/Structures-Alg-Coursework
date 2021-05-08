public class PetTree {

    private PetNode root;

    public PetTree() {
        root = null;
    }
    
    private String findMin(PetNode node) { // finds the minimum
        return node.left == null ? node.getName() : findMin(node.left);

    }

    public void insertNode(String name, Pet petObject) {  //Inserts the data
        if (root == null) {
            root = new PetNode(name, petObject);
        } else {
            root = root.insert(name, petObject);
        }
    }
    
    public String inOrder() {
        return inOrderHelper(root);
    }

    private String inOrderHelper(PetNode node) {
        if (node == null) {
            return "The List is Empty";
        }
        inOrderHelper(node.getLeft());
        System.out.printf("%s ", node.getName());
        inOrderHelper(node.getRight());
        return "";
    }

    public boolean findNode(String name) { // checks if the node exists
        return findNodeHelper(root, name);
    }

    private boolean findNodeHelper(PetNode node, String name) {
        if (node == null) {
            return false;
        } else if (node.getName().equals(name)) {
            return true;
        } else {
            return findNodeHelper(node.left, name) || findNodeHelper(node.right, name);
        }
    }

    public void deleteNode(String name) {
        root = deleteNodeHelper(root, name);// Deletes a node
    }

    private PetNode deleteNodeHelper(PetNode current, String name) {
        if (current == null) {
            return null;
        }

        if (name.compareTo(current.name) == 0) {

            if (current.left == null && current.right == null) {
                return null;
            }

            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }

            current.name = findMin(current.right);
            current.right = deleteNodeHelper(current.right, current.name);
            return current;
        } else if (name.compareTo(current.name) < 0) {
            current.left = deleteNodeHelper(current.left, name);
            return current;
        }

        current.right = deleteNodeHelper(current.right, name);
        return current;
    }

   
    public void search(String query) {
        if (root == null){
            System.out.println("There are no pets stored in the list");  // Displays the products
        }
        else {
            root.search(query);
        }
    }
}