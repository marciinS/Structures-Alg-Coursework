public class PetNode {

    String name;
    Pet newPetObject;
    PetNode left, right;

    public PetNode(String petType, Pet petObject) {
        name = petType;
        newPetObject = petObject;
        left = right = null;
    }

    public String getName() {
        return name;
    }

    public PetNode getLeft() {
        return left;
    }

    public PetNode getRight() {
        return right;
    }


    public PetNode insert(String key, Pet payload) {
        if (key.compareTo(name) < 0) {
            if (this.left == null) {
                this.left = new PetNode(key, payload);
            } else {
                this.left = this.left.insert(key, payload);
            }
        } else if (key.compareTo(name) > 0) {
            if (this.right == null) {
                this.right = new PetNode(key, payload);
            } else {
                this.right = this.right.insert(key, payload);
            }
        }
        return this;
    }

    public void search(String query) {

        if (query.equals(this.name)){
            this.newPetObject.toString();
        }

        else if (query.compareTo(this.name) < 0) {
            if (left == null){
                System.out.println("Not Found");
            }
            else{
                left.search(query);
            }
        }

        else if (query.compareTo(this.name) > 0) {
            if (right == null) {
                System.out.println("Not found");
            }
            else{
                right.search(query);
            }
        }
    }

}
