package facture;

import java.util.HashMap;
import java.util.Map;

public class Catalogue {
    
    Map<String, Article> hm = new HashMap<>(); 
    
    public void addArticle(Article article) {
       
   hm.put(article.getCode(),article); 
        
    }
    
    public Article findByCode(String code) {
      
    return(hm.get(code));     
    }
    
}
