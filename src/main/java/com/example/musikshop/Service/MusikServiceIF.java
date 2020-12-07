package com.example.musikshop.Service;

import com.example.musikshop.Entity.Musik;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface MusikServiceIF {
    public Musik createMusik(Musik musik);
    public Iterable<Musik> getMusiklist();
    public Optional<Musik> findMusik(long id);
    public long generateIndex();
}
