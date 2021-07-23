package CRUD.apirest.repository;

import CRUD.apirest.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    //Contact findByName(String name);

    Contact findByEmail(String email);
    
    List<Contact> findByName(String name)   ;

    //@Query("SELECT u.username FROM User u WHERE u.username LIKE CONCAT('%',:username,'%')")
    //List<String> findUsersWithPartOfName(@Param("username") String username);

    @Query
    ("SELECT c FROM Contact c WHERE c.name LIKE CONCAT('%',:name,'%')")
    List<Contact> findContacts(@Param("name") String name);


}



