public class Pet {

    String name;
    Pet pet;

    public Pet(String name, Pet pet) {
        this.name = name;
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        System.out.println(this.name + " " + this.pet);

        return "";
    }

}