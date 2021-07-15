package CRUD.apirest.controller;


import CRUD.apirest.model.Contact;
import CRUD.apirest.repository.ContactRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private ContactRepository repository;

    ContactController(ContactRepository contactRepository) {

        this.repository = contactRepository;
    }
    // métodos do CRUD aqui

    /*método para selecionar todos os contatos */
    @RequestMapping("/all")
    public List<Contact> findAll(){
        return repository.findAll();
    }

    /*método para selecionar o contato pelo id*/
    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    /*método para selecionar o contato pelo Nome*/
    //@GetMapping(path = {"nome/{name}"})
    //public Contact findById(@PathVariable String name){
    //   return repository.findByName(name);
    //}

    /*método para selecionar o contato pelo Nome e retornar uma lista*/
    @GetMapping(path = {"lista-nome/{name}"})
    public List<Contact> listById(@PathVariable String name){
        return repository.findByName(name);
    }
    
    /*método para selecionar o contato pelo Nome e retornar uma lista*/
    @GetMapping(path = {"lista-nome2/{name}"})
    public List<Contact> listBynames2(@PathVariable String name){
        return repository.findContacts(name);
    }
    /*método para inserir novo contato na base*/
    @PostMapping("/insert")
    public Contact create(@RequestBody Contact contact){
        return repository.save(contact);
    }

    /*método para atualizar um contato existente na base*/
    @PutMapping(value="/update/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Contact contact) {
        return repository.findById(id)
                .map(record -> {
                    record.setName(contact.getName());
                    record.setEmail(contact.getEmail());
                    record.setPhone(contact.getPhone());          
                    Contact updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    /*método para apagar um contanto da base*/
    @DeleteMapping(path ={"/delete/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}