public class PetLinkedList {


    private PetListNode first;
    private final PetListNode current;
    private final PetListNode last;


    public PetLinkedList() {
        this.first = null;
        this.current = null;
        this.last = null;
    }

 
    public PetListNode getFirst() {
        return first;
    }



    // Adds the Product
    public void addProducts(String productName, String productCode, int stockQuantity) {
        //Creates product
        PetProducts newPetProduct = new PetProducts(productName, productCode, stockQuantity);

        int counter = 0;

        if (this.getFirst() == null) {
            this.first = new PetListNode(newPetProduct);
        }

        PetListNode current = this.first;

       
        while (current != null) {
            if (current.getPetProducts().getCode().equals(newPetProduct.code)) {
                counter++;
            }
            current = current.next;
        }

        if (counter == 0) {
            assert this.first != null;
            this.first.add(newPetProduct);
        }
    }

    //Displays the Products
    public void displayProducts() {
        if (this.first == null) {
            System.out.println("No products in the system");
        }
        PetListNode current = this.first;

        while (current != null) {
            System.out.println(current.getPetProducts().getStockQuantity() + current.getPetProducts().getName() + " " + current.getPetProducts().getCode() + " " );
            current = current.getNext();
        }
    }
    
    // Delete a Product from the list
    public void deleteProduct(String code) {
        if (first == null) return;

        if (first.getPetProducts().getCode().equals(code)) {
            first = first.getNext();
            return;
        }

        PetListNode current = first;

        while (current != null) {
            if (current.getNext().getPetProducts().getCode().equals(code)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
}
