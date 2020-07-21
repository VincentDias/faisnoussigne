package com.LSF.faisnoussigne.uploadFile.repository;

import com.LSF.faisnoussigne.uploadFile.model.DBFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {

}