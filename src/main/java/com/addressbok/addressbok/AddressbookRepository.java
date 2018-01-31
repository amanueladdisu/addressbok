package com.addressbok.addressbok;

import org.springframework.data.repository.CrudRepository;

public interface AddressbookRepository extends CrudRepository<Addressbook, Long>{

         Iterable<Addressbook>findAllBynameofpeople(String search);

}
