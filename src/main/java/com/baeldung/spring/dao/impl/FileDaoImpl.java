package com.baeldung.spring.dao.impl;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.baeldung.spring.dao.FileDao;
import com.baeldung.spring.entity.File;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class FileDaoImpl implements FileDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public File saveFile(File file) {
        return entityManager.merge(file);// merge
    }

    @Override
    public File getFile(Long id) {
        return (File) entityManager.createQuery("from File where id = :id").setParameter("id", id).getSingleResult();
    }

    // get all file
    public List<File> getAllFile(){
        return entityManager.createQuery("select f from File f ").getResultList();
    }

    // get Fill by application id
    public List<File> getFileByApplication(Long applicationId){
//        select c from Child c join fetch c.parent
        return entityManager.createQuery("select j from JobApplication j where id = :id join fetch j.file ").setParameter("id",applicationId).getResultList();
    }


}