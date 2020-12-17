package com.example.musikshop.Service;

import com.example.musikshop.Entity.Musik;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MusikServiceIF {
    public Musik createMusik(Musik musik);
    public List<Musik> getMusiklist();
    public Optional<Musik> findMusik(long id);
    public long generateIndex();
    public void deleteAll();
}
