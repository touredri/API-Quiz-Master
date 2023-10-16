package com.odk3.projet_tp_api.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odk3.projet_tp_api.Repository.CategorieRepositorie;
import com.odk3.projet_tp_api.model.Categorie;

@Service
public class CategorieService {
    
    @Autowired
    CategorieRepositorie categorieRepositorie;

    public String creerCategorie(Categorie categorie) {
       if(categorieRepositorie.findCategorieByIdCategorie(categorie.getIdCategorie())==null){
         categorieRepositorie.save(categorie);
         return "Categorie ajouter avec succès";
       }else{
        return "Cette categorie existe deja";
       }
    }

    public List<Categorie> Lire() {
        return categorieRepositorie.findAll();
    }

    public String supprimer(Long id) {
        categorieRepositorie.deleteById(id);
        return "Categories supprimer avec succès !";
    }

    
}
