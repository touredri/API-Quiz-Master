package com.odk3.projet_tp_api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.odk3.projet_tp_api.Service.CategorieService;
import com.odk3.projet_tp_api.model.Categorie;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List; // Importez explicitement java.util.List

@Controller
@RequestMapping("/categorie")
public class CategorieController {
    @Autowired
    CategorieService categorieService;

    @PostMapping("/creer")
    @Operation(summary = "Permet de créer une catégorie")
    public String creerCategorie(@RequestBody Categorie categorie) {
        return categorieService.creerCategorie(categorie);
    }

    @GetMapping("/liste")
    @Operation(summary = "Permet d'avoir la liste des types")
    public List<Categorie> Lire() {
        return categorieService.Lire();
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Permet de supprimer un type")
    public String supprimer(@PathVariable Long id) {
        return categorieService.supprimer(id);
    }
}
