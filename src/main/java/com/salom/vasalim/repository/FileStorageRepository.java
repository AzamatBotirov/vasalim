package com.salom.vasalim.repository;

import com.salom.vasalim.demain.FileStorage;
import com.salom.vasalim.demain.FileStorageStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileStorageRepository extends JpaRepository<FileStorage, Long> {

        FileStorage findByHashId(String hashId);

        List<FileStorage> findAllByFileStorageStatus(FileStorageStatus status);


}
