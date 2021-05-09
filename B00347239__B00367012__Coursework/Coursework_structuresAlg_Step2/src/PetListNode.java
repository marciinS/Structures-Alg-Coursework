public class PetListNode {

    public PetListNode next;
    private final PetProducts data;

    public PetListNode(PetProducts data) {
        this.data = data;
        this.next = null;
    }

    public void add(PetProducts o) {
        if (this.next == null) {
            this.next = new PetListNode(o);
        } else {
            this.next.add(o);
        }
    }
    public String getCode() {
        return this.data.getCode();
    }
    public String getName() {
        return this.data.getName();
    }
    public PetListNode getNext() {
        return next;
    }
    public PetProducts getData() {
        return data;
    }
        public String getInformation() {
        return data.getProductInformation();
    }

}