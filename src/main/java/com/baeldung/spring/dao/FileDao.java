package com.baeldung.spring.dao;


import com.baeldung.spring.entity.File;

public interface FileDao {

    File saveFile(File file);

    File getFile(Long id);
}