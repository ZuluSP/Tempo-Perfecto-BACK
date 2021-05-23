package com.tempoPerfecto.controller.files;

import com.tempoPerfecto.model.files.File;
import com.tempoPerfecto.services.files.FileService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping(value = "files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void createNewFile(
            @RequestPart("file") MultipartFile file,
            @RequestParam("id") Long id) {

        service.addNewFile(file, id);
    }

    @DeleteMapping(value = "files/{fileId}")
    public void deleteFile(@PathVariable("fileId") Long id) {

        service.deleteFile(id);
    }


}
