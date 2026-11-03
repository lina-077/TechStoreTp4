package techstore;
import java.util.ArrayList;

public class Stock {
    private ArrayList<Element> articleList;

    public Stock() {
        this.articleList = new ArrayList<>();
    }
    public Stock(ArrayList<Element> articleList) {
        this.articleList = articleList;
    }
    public Stock(ArrayList<String> noms, ArrayList<Double> prixs, ArrayList<Long> quantites) {
        this.articleList = new ArrayList<>();
        if (noms != null && prixs != null && quantites != null) {
            int taille = Math.min(noms.size(), Math.min(prixs.size(), quantites.size()));
            for (int i = 0; i < taille; i++) {
                this.articleList.add(new Element(noms.get(i), prixs.get(i), quantites.get(i)));
            }
        }
    }
    public ArrayList<Element> getArticleList() {
        return articleList;
    }
    public void setArticleList(ArrayList<Element> articleList) {
        this.articleList = articleList;
    }
    public int getArticleNb() {
        return this.articleList.size();
    }
    public void ajouterArticle(Article article, long quantite) {
        if (article != null) {
            this.articleList.add(new Element(article, quantite));
        }
    }
    public void ajouterArticle(String nom, double prix, long quantite) {
        this.articleList.add(new Element(nom, prix, quantite));
    }
    public Element trouverArticle(String reference) {
        for (Element e : articleList) {
            if (e.equals(reference)) {
                return e;
            }
        }
        return null;
    }
    public void modifierArticle(String reference, String nouveauNom, double nouveauPrix, long nouvelleQuantite) {
        Element e = trouverArticle(reference);
        if (e != null) {
            e.modifier(nouveauNom, nouveauPrix, nouvelleQuantite);
        }
    }
    public void supprimerArticle(String reference) {
        Element e = trouverArticle(reference);
        if (e != null) {
            this.articleList.remove(e);
        }
    }
    public void incrementerQuantiteArticle(String reference, long q) {
        Element e = trouverArticle(reference);
        if (e != null) {
            e.incrementerQuantite(q);
        }
    }
    public void decrementerQuantiteArticle(String reference, long q) {
        Element e = trouverArticle(reference);
        if (e != null) {
            e.decrementerQuantite(q);
        }
    }
    @Override
    public String toString() {
        String res = "";
        for (Element e : articleList) {
            res += e.toString() + "\n";
        }
        return res;
    }
}