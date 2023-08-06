import java.util.Scanner; 
import java.util.Arrays;
import java.util.InputMismatchException;

public class App {

    public int lar = 0; //? largeur du tableau -
    public int lon = 0; //? longeur du tableau |
    private String[] letter = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"}; //? longeur du tableau |
    public boolean rBool() { // ! aléatoire boolean
        return Math.random() > 0.5 ? true : false ;
    }
    public boolean VerifTable(Boolean[][] table) { // ! verifier si le tableau est bien qu'en false

        for(Boolean[] tab : table){
            if(!Arrays.stream(tab).allMatch(t -> t == false)){
                return true;
            }
        }
        return false;
    }

    public void makeTable(Boolean[][] table) {
        App f = new App();
        System.out.println("------------------");
        
        
        for (int i = 0; i <= table.length ; i++ ){
            if(i == 0){ // ! first line
                System.out.print("\n|");
                if(table.length > 9){
                    System.out.print("  ");
                }else{
                    System.out.print(" ");
                }
                System.out.print("|");
                for (int j = 0; j < table[i].length; j++ ){
                    System.out.print("|");
                    System.out.print(f.letter[j]);
                    System.out.print("|");
                }
            }
            else{
                System.out.print("\n|");
                if(table.length > 9 && i < 10){
                    System.out.print("0"+i);
                }else{
                    System.out.print(i);
                }
                System.out.print("|");
                for (int j = 0; j < table[i -1].length ; j++ ){
                    System.out.print("|");
                    if(table[i -1][j]){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                    System.out.print("|");
                }
            }
        }
        
        System.out.println("\n------------------");
    }
    
    public static void main(String[] args) throws Exception {
    try (Scanner scanner = new Scanner(System.in)) {
        System.out.println("tableau : ");
        App f = new App();

        System.out.println("Bienvenue à Luxland ! Le seul jeux vidéo avec lumière /!\\");

        System.out.println("veuillez choisir la longeur du tableau sur lequel vous voulez jouer :");
        f.lon = scanner.nextInt();

        System.out.println("veuillez choisir la largeuur du tableau :");
        f.lar = scanner.nextInt();

        System.out.println("Merci ... Création du tableau: "+f.lon+"x"+f.lar);
        

        Boolean[][] initTable = new Boolean[f.lon][f.lar];

        for(int i = 0; i < f.lon; i++){
            for(int j = 0; j < f.lar; j++ ){
                initTable[i][j] = f.rBool();
            }
        };

        for(;f.VerifTable(initTable);){
            f.makeTable(initTable);
            System.out.println("\nles éléments sont pas tous éteints !");
            System.out.println("veuillez notez une cordonnée (ex: B2):");
            
            String input = null;
            input = scanner.next("(\\w\\d)|(\\d\\w)");

            String Cletter = input.replaceAll("\\d", "");
            System.out.println(Cletter);

            String Cnum = input.replaceAll("[A-z]", "");
            System.out.println(Cnum);

            int col = Arrays.binarySearch(f.letter, Cletter.toUpperCase());
            int line = Integer.parseInt(Cnum)-1;

            System.out.println(line+ "," +col);

            initTable[line][col] = !initTable[line][col];
            
            if(line != 0){
                initTable[line -1][col] = !initTable[line -1][col];
            }
            if(col != 0){
                initTable[line][col -1] = !initTable[line][col -1];
            }
            if(col != initTable.length -1){
                initTable[line][col +1] = !initTable[line][col +1];
            }
            if(line != initTable[0].length -1){
                initTable[line +1][col] = !initTable[line +1][col];
            }
        }
        System.out.println("tu as gaaaaagné !!! bravo !!!");
    }}
}