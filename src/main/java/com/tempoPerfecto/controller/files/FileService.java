package com.tempoPerfecto.controller.files;

import com.tempoPerfecto.model.files.File;
import com.tempoPerfecto.model.files.FileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    private FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public void addNewFile(File file) {
        fileRepository.save(file);
    }

    public void deleteFile(Long fileId) {
        boolean exists = fileRepository.existsById(fileId);
        if (!exists) {
            throw new IllegalStateException("The file with id " + fileId + " does not exists");
        }
        fileRepository.deleteById(fileId);
    }

    public List<File> getFiles() {
        return fileRepository.findAll();
    }
}
