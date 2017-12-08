package facture;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;

public class Facture {

    private final Client destinataire ;
    private Date emission ;
    private int numero ;
    private ArrayList<LigneFacture> lignes = new ArrayList<>();
  
       
    public Facture(Client destinataire, Date emission, int numero) {
      this.destinataire = destinataire ; 
      this.emission = emission ;
      this.numero = numero ;      
    }

    /**
     * Get the value of numero
     *
     * @return the value of numero
     */
    public int getNumero() {
       return numero ;
    }

    /**
     * Get the value of emission
     *
     * @return the value of emission
     */
    public Date getEmission() {
        return emission ; 
    }

    /**
     * Get the value of destinataire
     *
     * @return the value of destinataire
     */
    public Client getDestinataire() {
        return destinataire ;
    }

   
    public void ajouteLigne(Article a, int nombre, float remise) {
       LigneFacture x = new LigneFacture (nombre, this, a, remise);     
       lignes.add(x); 
        
   }

    
   public float montantTTC(float tauxTVA) {
       float total =0f;
       for (LigneFacture  montant : lignes ){
           total += montant.montantLigne();
       }
       total = total*(1+tauxTVA);
       return total ; 
   }
          
       
   public void print(PrintStream out, float tva) {
       out.println("Numéro de facture : " + numero );
       out.println("Date de commande : "   + emission );
       
       for (LigneFacture  i : lignes ){  
           out.println(i.toString());
       }
   }
   
}
