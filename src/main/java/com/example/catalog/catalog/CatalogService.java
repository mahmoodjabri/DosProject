package com.example.catalog.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Service
public class CatalogService {
    CatalogRepository repository;
    @Autowired
    public CatalogService(CatalogRepository repository) {
        this.repository = repository;
    }

    public List getListOfCatalogs() {
        return repository.getall();
    }

    public List getListOfTopic(String a) {
        return repository.gettopic(a);
    }

    public List getListOfInfo() {
        return repository.getallInfo();
    }

    public List getInfo(String s) {
        return repository.getInfo(Long.parseLong(s));

    }

    public String getInfoQ(Long s) {
        return repository.getInfoQ(s);
    }
    @Transactional
    public void infoedit(Long s) {
        repository.infoedit(s);
    }
}

