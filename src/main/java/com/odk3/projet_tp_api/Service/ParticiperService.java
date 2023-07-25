package com.odk3.projet_tp_api.Service;

import com.odk3.projet_tp_api.Repository.ParticiperRepository;
import com.odk3.projet_tp_api.model.Participer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticiperService {

    @Autowired // injection de dependance
    ParticiperRepository participerRepository;

    public Participer creerParticiper(Participer participer) {
        if (participerRepository.findByIdParticiper(participer.getIdParticiper()) == null) {
            participerRepository.save(participer);
            return participerRepository.findByIdParticiper(participer.getIdParticiper());
        } else {
            return null;
        }
    }

    public List<Participer> participerList() {
        return participerRepository.findAll();
    }

    public Participer modifierParticiper(Participer participer) {
        if (participerRepository.findByIdParticiper(participer.getIdParticiper()) != null) {
            participerRepository.save(participer);
            return participerRepository.findByIdParticiper(participer.getIdParticiper());
        } else {
            return null;
        }
    }

    public String supprimerParticiper(Participer participer) {
        if (participerRepository.findByIdParticiper(participer.getIdParticiper()) != null) {
            participerRepository.delete(participer);
            return "Sussès";
        } else {
            return "exite pas";
        }
    }


}


