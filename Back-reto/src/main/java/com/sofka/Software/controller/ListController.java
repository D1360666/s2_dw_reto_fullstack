package com.sofka.Software.controller;

import com.sofka.Software.dto.DTOList;
import com.sofka.Software.models.ListModel;
import com.sofka.Software.services.ListService;
//import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@CrossOrigin
@RestController
public class ListController {
        @Autowired
        private ListService listRepository;

        @GetMapping(value = "/listas")
        public Iterable<DTOList> list(){
            return listRepository.list();
        }

        @PostMapping(value="/listas")
        public DTOList saveLista(@RequestBody DTOList lista){
            return this.listRepository.createList(lista);
        }

        @PostMapping(value = "/task")
        public DTOList createList(@RequestBody DTOList lista){
            return listRepository.createList(lista);
        }

         @DeleteMapping(value = "/task/{id}")
         public void deleteTask(@PathVariable("id")Long id){
         listRepository.deleteTask(id);
         }
}
