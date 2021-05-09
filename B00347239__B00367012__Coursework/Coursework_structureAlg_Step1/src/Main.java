public class Main{

    public static void main (String[] args){

        String userSelection;
        String searchTerm;
        PetTree petSupplies = new PetTree();

        do {
            System.out.println(" 1. Add Pet");
            System.out.println(" 2. Find if the company provides products for a particular pet type");
            System.out.println(" 3. Display a specific pet type");
            System.out.println(" 4. Remove a specific pet type");
            System.out.println(" 5. Display list of all the pet types the company provides products for in alphabetical order");
            System.out.println(" 0. Exit");
            System.out.println("\n");
            userSelection = Input.getString("Please Select an Option:  ");

            switch (userSelection) {

                
                case "0" -> System.out.println("Thank you, Goodbye!"); // Exits the program

                case "1" -> {                // Add a pet
                    int repeatOption;

                    do {
                    String petName = Input.getString("Please Enter the Pet Type?: ");
                    Pet newPetObject = new Pet(petName, null);
                    petSupplies.insertNode(newPetObject.getName(), newPetObject);

                   repeatOption = Input.getInteger("If you would like to add another Pet Type Enter: 1" + "\n" + "If not Enter: 0");
                    } while (repeatOption == 1);
                }

                
                case "2" -> {
                    searchTerm = Input.getString("Please enter what pet to search for:  "); // To search for a pet
                    if (!petSupplies.findNode(searchTerm)){
                        System.out.println("Sorry we do not have that in stock");
                    }
                    else {
                        System.out.printf("We do stock products for %s's", searchTerm + "\n");
                    }
                }

                
                case "3" -> {
                    searchTerm = Input.getString("Please enter the Pet Type: "); // Display info about pet
                    petSupplies.search(searchTerm);
                }
                
                case "4" -> {
                    System.out.println("Pet Types in System: " + petSupplies.inOrder());
                    searchTerm = Input.getString("Please enter the Pet Type you want to delete: "); // Deletes a node
                    petSupplies.deleteNode(searchTerm);
                }

                case "5" -> System.out.println(petSupplies.inOrder());

                default -> System.out.println("Please Try again");
            }
        } while (!userSelection.equals("0"));

    }
}
