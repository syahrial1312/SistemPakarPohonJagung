import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * UI sistem pakar untuk memeriksa apakah g bernilai true dari fakta a, b, c, f  
 * Sistem ini memiliki 4 pertanyaan yang akan diberikan pada user
 * 4 pertanyaan merepresentasikan 4 fakta
 * fact: a, b, c, f
 * conclussion: g
 * @author AERO
 */
public class Main {

    public static List<Rule> getKnowledge() throws FileNotFoundException, IOException
    {
        //ganti dengan lokasi project Anda nanti
        FileReader reader = new FileReader("D:\\fakhri\\tugas\\sem5\\tugas sempak\\SimpleExpertSystem-main\\SimpleExpertSystem-main\\src\\knowledge_base");
        //"C:\\SimpleExpertSystem-main\\SimpleExpertSystem-main\\src\\knowledge_base"
        BufferedReader bufferedReader = new BufferedReader(reader);
        List<Rule> rules = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            //mengambil string bagian fact dulu baru conclussion
            rules.add(new Rule(
                    Arrays.asList(line.split("-")[0].split(",")), 
                    line.split("-")[1]));
        }
        
        bufferedReader.close();
        reader.close();
        return rules;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        boolean lanjut = true;

        while(lanjut){
            System.out.println();
            System.out.println("========================= SISTEM PAKAR: PENYAKIT PADA TANAMAN JAGUNG =========================================================");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("====================== DIBUAT OLEH: MUHAMMAD FAKHRI & MUHAMMAD SYAHRIAL ======================================================");
            System.out.println();
            UI tampilan = new UI();
            tampilan.showQuestions();
            //initial facts, jawaban user
            Set<String> facts  = tampilan.getFacts();

            //get knowledge base
            List<Rule> rules = getKnowledge();

            // Apply forward chaining
            Set<String> inferedFacts =
                    InferenceForwardChaining.doForwardChaining(rules, facts);

            boolean gIsTrue;
            boolean bIsTrue;
            boolean cIsTrue;
            boolean dIsTrue;
            boolean eIsTrue;
            boolean fIsTrue;

            System.out.println("All facts: " + facts);
            System.out.println("Inferred facts: " + inferedFacts);
            System.out.print("penyakit anda terindikasi: ");

            if(inferedFacts.contains("a"))
                gIsTrue = true;
            else
                gIsTrue = false;
            tampilan.showConclussion(gIsTrue, facts, inferedFacts);

            if(inferedFacts.contains("b"))
                bIsTrue = true;
            else
                bIsTrue = false;
            tampilan.showConclussion1(bIsTrue);

            if(inferedFacts.contains("c"))
                cIsTrue = true;
            else
                cIsTrue = false;
            tampilan.showConclussion2(cIsTrue);

            if(inferedFacts.contains("d"))
                dIsTrue = true;
            else
                dIsTrue = false;
            tampilan.showConclussion3(dIsTrue);

            if(inferedFacts.contains("e"))
                eIsTrue = true;
            else
                eIsTrue = false;
            tampilan.showConclussion4(eIsTrue);

            if(inferedFacts.contains("f"))
                fIsTrue = true;
            else
                fIsTrue = false;
            tampilan.showConclussion5(fIsTrue);

            if (!inferedFacts.contains("a") && !inferedFacts.contains("b") &&
                    !inferedFacts.contains("c") && !inferedFacts.contains("d") &&
                    !inferedFacts.contains("e") && !inferedFacts.contains("f")) {
                System.out.println("Tanaman anda sehat");
            }

            System.out.println("Apakah Anda ingin mengulang konsultasi? (ya/tidak): ");
            String jawaban = scanner.next();

            if (jawaban.equalsIgnoreCase("tidak")) {
                lanjut = false;
                System.out.println("Terima kasih telah menggunakan program ini!");
            }
        }
        scanner.close();



    }
    
}
