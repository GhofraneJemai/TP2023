public class Main {
    public static void main(String[] args) {
        try {
            // Création du blog
            Blog blog = new Blog("Mon Blog", 10);

            // Création de billets
            Billet message1 = new Message(LocalDate.now(), "Alice", "Ceci est un message de test");
            Billet message2 = new Message(LocalDate.now(), "Bob", "Message important ici");
            BilletTaggable image1 = new Image(LocalDate.now(), "Alice", 5, "https://www.example.com/image1.jpg");
            BilletTaggable video1 = new Video(LocalDate.now(), "Bob", 5, "http://www.example.com/video1.mp4"); // Non sécurisé, erreur attendue
            BilletTaggable video2 = new Video(LocalDate.now(), "Alice", 5, "https://www.example.com/video2.mp4"); // Sécurisé

            // Publication des billets
            blog.post(message1);
            blog.post(message2);
            blog.post(image1);
            blog.post(video2);  // Ce billet doit être publié
            blog.post(video1);  // Cette ligne lancera une exception InvalidURLException

            // Ajout de tags à des billets taggables
            ((BilletTaggable) image1).ajoutTag("vacances");
            ((BilletTaggable) image1).ajoutTag("plage");
            ((BilletTaggable) video2).ajoutTag("video");

            // Recherche de billets taggables par auteur
            Publiable[] taggables = blog.RechercheBilletsTaggablesParAuteur("Alice");
            System.out.println("\nBillets de Alice : ");
            for (Publiable billet : taggables) {
                if (billet != null) {
                    System.out.println(billet);
                }
            }

            // Recherche de billets par contenu
            String[] mots = {"test", "message"};
            Publiable[] result = blog.RechercheBilletsParContenu(mots);
            System.out.println("\nBillets contenant les mots : ");
            for (Publiable billet : result) {
                if (billet != null) {
                    System.out.println(billet);
                }
            }

            // Test du nombre de billets taggables
            int count = blog.getNombreBilletsTaggables();
            System.out.println("\nNombre de billets taggables : " + count);

            // Recherche du billet le plus récent
            Publiable plusRecent = blog.getPlusRécentBillet();
            System.out.println("\nBillet le plus récent : ");
            System.out.println(plusRecent);

        } catch (InvalidURLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}