package com.sofka.Software.services;

import com.sofka.Software.dto.DTOList;
import com.sofka.Software.dto.DTOListTask;
import com.sofka.Software.models.ListModel;
import com.sofka.Software.models.ListTaskModel;
import com.sofka.Software.repositories.ListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ListService {
    @Autowired
    private ListRepository listRepository;

    public Iterable<DTOList> list(){

        return listRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    /**
     * metodo crear lista
     * @param lista
     * @return
     */
    public DTOList createList(DTOList lista){
        return convertEntityToDto(listRepository.save(convertDtoToEntity(lista)));
    }

    /**
     * Método para pasar de Entity a Dto
     */
    private DTOList convertEntityToDto(ListModel list) {
        DTOList l = new DTOList();
        l.setId(list.getId());
        l.setName(list.getName());

        List<DTOListTask> ltask = new ArrayList<DTOListTask>();
        for(ListTaskModel lt: list.getListTask()){
            ltask.add(convertEntityToDto(lt));
        }
        l.setListTask(ltask);

        return l;
    }
    private DTOListTask convertEntityToDto(ListTaskModel listTask){
        DTOListTask l = new DTOListTask();
        l.setId(listTask.getId());
        l.setName(listTask.getName());
        l.setCompleted(listTask.getCompleted());
        return l;
    }


    private ListModel convertDtoToEntity( DTOList list) {
        ListModel l = new ListModel();
        l.setId(list.getId());
        l.setName(list.getName());

        List<ListTaskModel> ltask = new ArrayList<ListTaskModel>();
        for(DTOListTask lt: list.getListTask()){
            ltask.add(convertEntityToDto(lt));
        }
        l.setListTask(ltask);

        return l;
    }

    private ListTaskModel convertEntityToDto(DTOListTask listTask){
        ListTaskModel l = new ListTaskModel();
        l.setId(listTask.getId());
        l.setName(listTask.getName());
        l.setCompleted(listTask.getCompleted());
        return l;
    }


    /**
     * metodo eliminar lista
     * @param id
     */
    public void deleteTask(Long id){
        ListModel l = new ListModel();
        l.setId(id);
        listRepository.delete(l);
    }

    /**
     * verificar si el id esta entonces lo retorne , si no retorne error
     * @param id
     * @return
     */
    public DTOList get(Long id){
        return convertEntityToDto(listRepository.findById(id).orElseThrow());
    }


}
