package com.tempoPerfecto.services.files;

import com.tempoPerfecto.model.files.File;
import com.tempoPerfecto.model.files.FileRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Service
public class FileService {

    private FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }


    public void addNewFile(MultipartFile file, Long id) {

        String separator = System.getProperty("file.separator");
        Path path = Path.of(String.format(".%s%d", separator, id));
        String name = file.getOriginalFilename();

        try {
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
            Files.write(Path.of(path.toString(), name), file.getBytes());
            fileRepository.save(new File(path.toString(), name, id));
        } catch (FileNotFoundException e) {
            System.err.println("directory does not exist");
        } catch (IOException e) {
            System.err.println("Cannot create the directory");
        }

    }

    public void deleteFile(Long fileId) {
        boolean exists = fileRepository.existsById(fileId);
        Optional<File> file = fileRepository.findById(fileId);
        String separator = System.getProperty("file.separator");
        if (exists) {
            try {
                Files.delete(Path.of(file.get().getRuta() + separator + file.get().getName()));
            } catch (IOException e) {
                System.err.print("Cannot delete that document");
            }
        }

        if (!exists) {
            throw new IllegalStateException("The file with id " + fileId + " does not exists");
        }
        fileRepository.deleteById(fileId);
    }

    public List<File> getFiles() {
        return fileRepository.findAll();
    }
}
