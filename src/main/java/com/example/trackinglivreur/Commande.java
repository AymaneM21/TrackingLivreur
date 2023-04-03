package com.example.trackinglivreur;

public class Commande {
    private int numéroCommande ;

    private String dateLivraison ;

    private String prixTotal ;

    public Commande() {
    }

    public Commande(int numéroCommande, String dateLivraison, String prixTotal) {
        this.numéroCommande = numéroCommande;
        this.dateLivraison = dateLivraison;
        this.prixTotal = prixTotal;
    }
    public int getNuméroCommande() {
        return numéroCommande;
    }

    public void setNuméroCommande(int numéroCommande) {
        this.numéroCommande = numéroCommande;
    }

    public String getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(String dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public String getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(String prixTotal) {
        this.prixTotal = prixTotal;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "Numéro_Commande=" + numéroCommande +
                ", Date_Livraison='" + dateLivraison + '\'' +
                ", Prix_Total='" + prixTotal + '\'' +
                '}';
    }
}
