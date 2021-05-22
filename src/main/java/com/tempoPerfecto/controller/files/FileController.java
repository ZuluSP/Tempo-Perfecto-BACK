package com.tempoPerfecto.controller.files;

import com.tempoPerfecto.model.files.File;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FileController {

    private FileService service;

    //private List<FileDTO> files = new ArrayList<FileDTO>();

    public FileController(FileService service) {
        this.service = service;
    }

    @GetMapping(value = "files")
    public List<File> getFiles() {
        return service.getFiles();
    }

    @PostMapping(value = "files")
    public void createNewFile(@RequestBody File file) {
        service.addNewFile(file);
    }

    @DeleteMapping(value = "files/{fileId}")
    public void deleteFile(@PathVariable("fileId") Long id) {
        service.deleteFile(id);
    }


}
