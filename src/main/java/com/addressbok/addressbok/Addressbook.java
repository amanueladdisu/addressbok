package com.addressbok.addressbok;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Addressbook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(max=10)
    private String nameofpeople;

    @NotNull
    @Size(min=10)
    private String contactlist;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameofpeople() {
        return nameofpeople;
    }

    public void setNameofpeople(String nameofpeople) {
        this.nameofpeople = nameofpeople;
    }

    public String getContactlist() {
        return contactlist;
    }

    public void setContactlist(String contactlist) {
        this.contactlist = contactlist;
    }
}
