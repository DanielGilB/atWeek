package com.atSistemas.atWeek.controller.api;

import com.atSistemas.atWeek.controller.CrudController;
import com.atSistemas.atWeek.exception.NotFoundException;
import com.atSistemas.atWeek.model.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController /* extends CrudController */ {
/*
    @Autowired
    private final ClientRepository repository;

    public ClientController(ClientRepository repository){
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Client findOne(@PathVariable("id") Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found entity with value "+id));
    }

    @GetMapping
    public List<Client> findAll(){
        return repository.findAll();
        //TODO::findAll con paginado
    }


    @PostMapping
    public Client create(@RequestBody Client client){
        return repository.save(client);
    }

    @PutMapping("/{id}")
    public Client edit(@PathVariable("id") Integer id){
        //TODO: crear metodo update
        return repository.findById(id).orElse(new Client());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        //TODO: crear metodo delete con un find primero y que devuelva un 200?
        repository.deleteById(id);
    }

 */

}
