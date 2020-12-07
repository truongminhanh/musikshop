package com.example.musikshop.Service;

import com.example.musikshop.Entity.Musik;
import com.example.musikshop.repository.MusikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MusikService implements MusikServiceIF {

    @Autowired
    private MusikRepository musikRepository;

    @Override
    public Musik createMusik(Musik musik){
        Musik newMusik = musikRepository.save(musik);
        return newMusik;
    }

    @Override
    public Iterable<Musik> getMusiklist(){
        return musikRepository.findAll();
    }

    @Override
    public Optional<Musik> findMusik(long id){
        return musikRepository.findById(id);
    }

    @Override
    public long generateIndex(){
        Iterable<Musik> list = getMusiklist();
        long size = 0;
        for(Musik musik : list){
            size++;
        }
        return size;
    }
}
