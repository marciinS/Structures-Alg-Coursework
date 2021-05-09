import java.util.ArrayList;

public class PetLinkedList {

    private PetListNode head;

    public PetLinkedList() {
        this.head = null;
    }

    public PetListNode getHead() {
        return head;
    }

    public void addProducts(PetProducts o) {
        int counter = 0;

        if (head == null) {
            head = new PetListNode(o);
        }
        
       PetListNode current = head;
        while (current != null) {
            if (current.getCode().equals(o.PetProductCode)) {
                counter++;
            }
            current = current.next;
        }

        if (counter == 0) {
            head.add(o);
        }
        else {
            System.out.println("Your product has already been added");// a message to display if the product is already added              
        }
    }

    public void displayProducts(PetListNode head) {
        if (head == null) {
            System.out.println("No products in the system");
            return;
        }
        PetListNode current = head;

        while (current != null) {
            System.out.println(current.getInformation());
            current = current.getNext();
        }
    }

    public void findProduct(String searchTerm, PetListNode head) {

        ArrayList<PetProducts> searchResults = new ArrayList<>();
        
        if (head == null) {
            System.out.println("List is empty");//if there is nothing stored will say its empty
            return;
        }
        PetListNode current = head;

        while (current != null) {
            if (current.getName().equals(searchTerm) || current.getCode().equals(searchTerm)) {
                searchResults.add(current.getData());
            }
            current = current.getNext();
        }

        if (searchResults.isEmpty()) {
            System.out.println("No products found..."); //Display if nothing was found
        }
        
        else {
            for (PetProducts searchResult : searchResults) {
                System.out.println(searchResult.getProductInformation());
            }
        }
    }
//deleting nodes
    public void deleteNode(String code) {
        if (head == null) return;

        if (head.getCode().equals(code)) {
            head = head.getNext();
            return;
        }

        PetListNode current = head;

        while (current != null) {
            if (!current.getNext().getCode().equals(code)) {
            } else {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

}