public class Node {

    String name;
    Pet petObject;
    Node left, right;

    public Node(String petType, Pet petObject) {
        name = petType;
        this.petObject = petObject;
        left = null;
        right = null;
    }

    public String getName() {
        return name;
    }

    public Pet getPetObject() {
        return petObject;
    }

    // Insert a node into tree
    public boolean insert(String name) {
        boolean added = false;

        if (this == null) {
            Pet pet = new Pet();
            this.petObject = pet;
            return true;
        } else {
            if (name.compareTo(this.name) < 0) {
                if (this.left == null) {
                    Pet pet = new Pet();
                    this.left = new Node(name, pet);
                    return true;
                } else {
                    added = this.left.insert(name);
                }
            } else if (name.compareTo(this.name) > 0) {

                if (this.right == null) {
                    Pet pet = new Pet();
                    this.right = new Node(name, pet);
                    return true;
                } else {
                    added = this.right.insert(name);
                }
            }
        }
        return added;
    }

    //true or false
    boolean find(String name) {
        boolean found = false;

        if (this == null) {
            return false;
        } else {
            if (name.equals(this.name)) {
                return true;
            } else if (name.compareTo(this.name) < 0 && this.left != null) {
                found = this.left.find(name);
            } else if (name.compareTo(this.name) > 0 && this.right != null) {
                found = this.right.find(name);
            }
        }
        return found;
    }

    public void inorder() {
        if (this != null) {
            if (this.left != null)
                this.left.inorder();
            System.out.println(this.name);
            if (this.right != null)
                this.right.inorder();
        }
    }

    // Output all the products & nodes
    public void outputAllProducts() {
        if (this != null) {
            if (this.left != null)
                this.left.outputAllProducts();
            System.out.println(" ");
            System.out.println(this.name);
            this.getPetObject().getPetProducts().displayProducts();
            if (this.right != null)
                this.right.outputAllProducts();
        }
    }


}
