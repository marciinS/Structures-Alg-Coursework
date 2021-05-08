public class PetTree {

    public Node root;

    public PetTree() {
        root = null;
    }

    //Inserts a new node into the tree
    public boolean insert(String name){
        if (root == null) {
            Pet pet = new Pet();
            root = new Node(name, pet);
            return true;
        } else {
            return root.insert(name);
        }
    }

    // True or False
    public boolean find (String name){
        if (root == null) {
            return false;
        } else {
            return root.find(name);
        }
    }

    // Finds the lowest value
    private String findMin(Node node) {
        return node.left == null ? node.getName() : findMin(node.left);

    }

    public void inorder() {
        if (root == null){
            System.out.println("System doesn't contain any Pets");
        }
        if (root != null) {
            System.out.println("Inorder:");
            root.inorder();
        }
    }

    public void outputAllProducts() {
        if (root != null) {
            System.out.println("All Products:");
            root.outputAllProducts();
        }
    }

    public Node getNode(String petName, Node current){
        Node target = null;

        if (this.root == null){
            System.out.println("Not found");
        }

        if (current != null){
            if (petName.compareTo(current.name)==0){
                target=current;
            }
            else if (petName.compareTo(current.name)<0){
                target = this.getNode(petName, current.left);
            }
            else {
                target = this.getNode(petName,current.right);
            }
        }

        if (current == null){
            System.out.println("Not found");
        }

        return target;
    }

    // Deletes the node stored
    public void deleteNode(String name) {
        root = deleteNodeHelper(root, name);
    }

    private Node deleteNodeHelper(Node current, String name) {
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

}
