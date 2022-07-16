package com.sofka.Software;

import com.sofka.Software.dto.DTOList;
import com.sofka.Software.dto.DTOListTask;
import com.sofka.Software.models.ListModel;
import com.sofka.Software.models.ListTaskModel;
import com.sofka.Software.repositories.ListRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ListJpaRepositoryTest {
    @Autowired
    private ListRepository listRepository;

    @Test
    public void createList(){
        List <DTOListTask> tareas = new ArrayList();
        DTOList lista = new DTOList("lista1", tareas);

        listRepository.save(lista);
        listRepository.flush();

        assertEquals(1, listRepository.findAll().size());
    }
}
