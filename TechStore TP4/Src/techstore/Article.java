package techstore;

public class Article {
    private static int compteur = 1; // Pour l'auto-incrémentation de l'id
    private int id;
    private String nom;
    private String reference;
    private double prix;
    
    public Article(String nom, double prix) {
        this.id = compteur++;
        this.nom = nom;
        this.prix = prix;
        this.reference = genererReference(nom, this.id);
    }
    private String genererReference(String nomArticle, int idArticle) {
        String ref = "";
        for (int i = 0; i < nomArticle.length(); i++) {
            char c = nomArticle.charAt(i);
            if (c != ' ' && i % 5 == 0) {
                ref += c;
            }
        }
        return ref + idArticle;
    }
    public int getId() {
        return id;
    }
    public String getReference() {
        return reference;
    }
    public String getNom() {
        return nom;
    }
    public double getPrix() {
        return prix;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }
    public void setNom(String nom) {
        this.nom = nom;
        this.reference = genererReference(nom, this.id); // Mise à jour automatique de la référence
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public void modifier(String nom) {
        setNom(nom);
    }
    public void modifier(String nom, double prix) {
        setNom(nom);
        this.prix = prix;
    }
    @Override
    public String toString() {
        return "id=" + id + ", nom=" + nom + ", reference=" + reference + ", prix=" + prix;
    }
}