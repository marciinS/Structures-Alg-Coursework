public class PetListNode {

    PetListNode next;
    PetProducts Petproducts;

    public PetListNode(PetProducts Petproducts) {
       this.Petproducts = Petproducts;
       this.next = null;
    }

    public PetListNode getNext() {
        return next;
    }

    public PetProducts getPetProducts() {
        return Petproducts;
    }
    
    // Adds product to list
    public void add(PetProducts o) {
        if (this.next == null) {
            this.next = new PetListNode(o);
        } else {
            this.next.add(o);
        }
    }

    Object getProducts() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
