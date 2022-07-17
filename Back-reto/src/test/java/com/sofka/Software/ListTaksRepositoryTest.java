package com.sofka.Software;

import com.sofka.Software.dto.DTOList;
import com.sofka.Software.dto.DTOListTask;
import com.sofka.Software.models.ListModel;
import com.sofka.Software.models.ListTaskModel;
import com.sofka.Software.repositories.ListRepository;
import com.sofka.Software.repositories.ListTaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ListTaksRepositoryTest {
    @Autowired
    private ListTaskRepository repo;

    @Test
    public void createListTask(){

        ListTaskModel l = new ListTaskModel();
        l.setName("prueba");
        l.setCompleted(true);
        ListModel lista = new ListModel();
        lista.setId(6L);
        l.setListaid(lista);

        repo.save(l);
        repo.flush();

        assertEquals(1, repo.findAll().size());
    }
}
