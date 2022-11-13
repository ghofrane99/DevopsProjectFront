package com.esprit.examen.services;

import com.esprit.examen.TpAchatProjectApplication;
import com.esprit.examen.entities.CategorieFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = TpAchatProjectApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class FournisseurServiceImplTest {

    @Mock
    FournisseurRepository fournisseurRepositoryMock;
    @InjectMocks
    FournisseurServiceImpl fournisseurService;


    Fournisseur fournisseur =
            Fournisseur.builder() .code("CODE1") .libelle("LIB1")
                    .categorieFournisseur(CategorieFournisseur.ORDINAIRE) .build();
    List<Fournisseur> listFournisseurs = new ArrayList<Fournisseur>(){
        {
            add(Fournisseur.builder() .code("CODE2") .libelle("LIB2").categorieFournisseur(CategorieFournisseur.ORDINAIRE) .build());
            add(Fournisseur.builder() .code("CODE3") .libelle("LIB3").categorieFournisseur(CategorieFournisseur.ORDINAIRE) .build());
            add(Fournisseur.builder() .code("CODE4") .libelle("LIB4").categorieFournisseur(CategorieFournisseur.ORDINAIRE) .build());
            add(Fournisseur.builder() .code("CODE5") .libelle("LIB5").categorieFournisseur(CategorieFournisseur.ORDINAIRE) .build());
        }
    };

    @Test
    public void testretrieveFournisseur(){
        Mockito.when(fournisseurRepositoryMock.findById(Mockito.anyLong())).thenReturn(Optional.of(fournisseur)); //find all
        Fournisseur f1 = fournisseurService.retrieveFournisseur(2L);
        Assertions.assertNotNull(f1);
        System.out.println("wererey retrieve fournisseur tekhdem !");
    }
    @Test
    public void testaddfournisseur() {
        Mockito.when(fournisseurRepositoryMock.save(fournisseur)).thenReturn(fournisseur);
        Fournisseur f1 = fournisseurService.addFournisseur(fournisseur);
        Assertions.assertNotNull(f1);
        System.out.println("add fournisseur tekhdem !");
    }

    @Test
    public void testretrieveAllfournisseurs() {
        Mockito.when(fournisseurRepositoryMock.findAll()).thenReturn(listFournisseurs);
        List<Fournisseur> listF = fournisseurService.retrieveAllFournisseurs();
        Assertions.assertNotNull(listF);
        System.out.println("all retrieve tekhdem zeda !");

    }





    @Test
    public void testdeletefournisseur() {
        Fournisseur f2 = Fournisseur.builder() .code("DelTest") .libelle("LibDelete")
                .categorieFournisseur(CategorieFournisseur.ORDINAIRE) .build();
        fournisseurService.deleteFournisseur(f2.getIdFournisseur());
        Mockito.verify(fournisseurRepositoryMock).deleteById(f2.getIdFournisseur());
        System.out.println("delete fournisseur works !");


    }
}
