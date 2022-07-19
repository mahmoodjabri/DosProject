package com.example.catalog.catalog;

import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CatalogRepository extends JpaRepository <Catalog,Long> {
    @Query("SELECT r.id,r.Title from Catalog  r")
    List getall();
    @Query("select r.id,r.Title from Catalog r where r.Subject=:Subject")
    List gettopic(@Param("Subject")String subject);
    @Query("select r.Title,r.Quantity,r.Price from Catalog r")
    List getallInfo();
    @Query("select r.Title,r.Quantity,r.Price from Catalog r where r.id=:Id")
    List getInfo(@Param("Id")Long id);

    @Query("select r.Quantity from Catalog r where r.id=:Id")
    String getInfoQ(@Param("Id")Long s);
    @Modifying
    @Query("Update Catalog r set r.Quantity =r.Quantity-1 where r.id=:Id")
    void infoedit(@Param("Id") Long s);
}

