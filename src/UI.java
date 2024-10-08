import java.util.*;

/**
 * UI sistem pakar untuk memeriksa apakah g bernilai true dari fakta a, b, c, f
 * Sistem ini memiliki 31 pertanyaan. User diberikan daftar masalah, lalu menjawab
 * dengan memilih nomor masalah yang dialami di akhir.
 * @author AERO
 */
public class UI {

    private ArrayList<String> questions;
    private int answers[];

    public UI() {
        this.answers = new int[31];  // 31 pertanyaan
        this.questions = new ArrayList<>();
        this.setQuestions();
    }

    private void setQuestions() {
        // Daftar masalah atau pertanyaan
        questions.add("1. Daun tanaman jagung berwarna klorotif");
        questions.add("2. Tanaman pertumbuhannya terhambat");
        questions.add("3. Permukaan atas daun berwarna putih dan bagian bawah berwarna klorotif");
        questions.add("4. Daun tanaman berbentuk keriting dan melengkung");
        questions.add("5. Batang jagung mengalami gangguan pembentukan");
        questions.add("6. Daun tanaman terlihat layu");
        questions.add("7. Pada tanaman terlihat bercak kecil dan bersatu menjadi besar");
        questions.add("8. Tanaman memiliki bercak coklat muda yang panjang seperti bentuk perahu");
        questions.add("9. Tanaman memiliki bintik-bintik coklat berbentuk elips");
        questions.add("10. Daun tanaman terlihat kering");
        questions.add("11. Tanaman terlihat bintik-bintik kecil berwarna coklat atau kuning pada daunnya");
        questions.add("12. Daun tanaman terlihat bintik merah");
        questions.add("13. Pada jagung terdapat benang yang berbentuk tidak beraturan dan berwarna putih serta coklat");
        questions.add("14. Tanaman mengeluarkan serbuk seperti tepung berwarna coklat kekuningan");
        questions.add("15. Pada jagung terdapat pembengkakan pada batang");
        questions.add("16. Tanaman terdapat jamur berwarna putih hingga hitam");
        questions.add("17. Pada jagung terdapat biji jagung yang bengkak");
        questions.add("18. Pada biji jagung tumbuh suatu kelenjar");
        questions.add("19. Daun pembungkus jagung terbuka dan muncul jamur berwarna putih hingga hitam");
        questions.add("20. Daun pembungkus jagung memiliki lubang kecil");
        questions.add("21. Pada batang jagung terdapat celah");
        questions.add("22. Pada tanaman jagung terdapat bunga jantan atau pangkal tongkol");
        questions.add("23. Pada batang jagung mudah patah");
        questions.add("24. Pada tanaman terdapat rumbai yang rusak");
        questions.add("25. Bunga jantan pada tanaman tidak terbentuk");
        questions.add("26. Disekitar kerekan terdapat tanah atau debu yang menempel");
        questions.add("27. Daun pada tanaman berwarna agak kekuning-kuningan");
        questions.add("28. Pada tanaman terdapat lubang yang melintang pada daun fase vegetatif");
        questions.add("29. Pada rambut jagung jumlahnya berkurang atau terlihat kering");
        questions.add("30. Pada tanaman memiliki kerekan pada ujung tongkol");
        questions.add("31. Pada tanaman sering dihinggapi larva");
    }


    public void showQuestions() {
        // Menampilkan seluruh pertanyaan ke pengguna
        System.out.println("Berikut adalah daftar masalah yang mungkin dialami tanaman jagung Anda:");
        for (String q : this.questions) {
            System.out.println(q);
        }
        System.out.println("\nMasukkan nomor masalah yang dialami, dipisahkan dengan koma (contoh: 1,3,5,8): ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        // Menerima input pengguna


        // Memproses input pengguna
        String[] selectedProblems = input.split(",");
        for (String problem : selectedProblems) {
            try {
                int problemIndex = Integer.parseInt(problem.trim()) - 1;  // Mengubah input ke indeks
                if (problemIndex >= 0 && problemIndex < this.questions.size()) {
                    answers[problemIndex] = 1;  // Menandai masalah yang dipilih
                } else {
                    System.out.println("Nomor " + (problemIndex + 1) + " tidak valid.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid: " + problem);
            }
        }
    }

    public void getAnswers() {

    }

    public Set<String> getFacts() {
        Set<String> facts = new HashSet<>();
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == 1) {
                facts.add(Character.toString((char)('A' + i)));  // Mengubah indeks ke huruf (a, b, c, ...)
            }
        }
        return facts;
    }
    
    public void showConclussion(boolean gIsTrue, Set<String> facts, Set<String> inferedFacts)
    {
        /*System.out.println("All facts: " + facts);
        System.out.println("Inferred facts: " + inferedFacts);*/
        if(gIsTrue == true)
        {
            System.out.print("Bulai, ");
        }
        /*else
        {
            System.out.println("A tidak terbukti");
        }*/
    }

    public void showConclussion1(boolean bIsTrue)
    {
        /*System.out.println("All facts: " + facts);
        System.out.println("Inferred facts: " + inferedFacts);*/
        if(bIsTrue == true)
        {
            System.out.print("Blight, ");
        }
        /*else
        {
            System.out.println("B tidak terbukti");
        }*/
    }
    public void showConclussion2(boolean cIsTrue)
    {
        /*System.out.println("All facts: " + facts);
        System.out.println("Inferred facts: " + inferedFacts);*/
        if(cIsTrue == true)
        {
            System.out.print("Leaf Rust, ");
        }
        /*else
        {
            System.out.println("C tidak terbukti");
        }*/
    }
    public void showConclussion3(boolean dIsTrue)
    {
        /*System.out.println("All facts: " + facts);
        System.out.println("Inferred facts: " + inferedFacts);*/
        if(dIsTrue == true)
        {
            System.out.println("Burn, ");
        }
        /*else
        {
            System.out.println("D tidak terbukti");
        }*/
    }
    public void showConclussion4(boolean eIsTrue)
    {
        /*System.out.println("All facts: " + facts);
        System.out.println("Inferred facts: " + inferedFacts);*/
        if(eIsTrue == true)
        {
            System.out.println("stem borer, ");
        }
        /*else
        {
            System.out.println("E tidak terbukti");
        }*/
    }
    public void showConclussion5(boolean fIsTrue)
    {
        /*System.out.println("All facts: " + facts);
        System.out.println("Inferred facts: " + inferedFacts);*/
        if(fIsTrue == true)
        {
            System.out.println("cob borer, ");
        }
        /*else
        {
            System.out.println("F tidak terbukti");
        }*/
    }
    /*public void showConclussion6(boolean gIsTrue, boolean bIsTrue, boolean cIsTrue, boolean dIsTrue, boolean eIsTrue, boolean fIsTrue){
        if((gIsTrue == false)&&(bIsTrue == false)&&(cIsTrue == false)&&(dIsTrue == false)&&(eIsTrue == false)&&(fIsTrue == false)){
            System.out.println("tanaman anda sehat selalu, jaga selalu tanaman anda ya");
        }
    }*/
    
    
}
