package com.odk3.projet_tp_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odk3.projet_tp_api.model.Categorie;

public interface CategorieRepositorie extends JpaRepository <Categorie, Long>{

    public Categorie findCategorieByIdCategorie(Long id);
    
}
