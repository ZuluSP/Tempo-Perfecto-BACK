package com.tempoPerfecto.controller.files;

import com.tempoPerfecto.model.files.File;
import com.tempoPerfecto.rest.dto.files.CreateFileDTO;
import com.tempoPerfecto.rest.services.files.StorageService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;


import java.util.List;

@RestController
@RequestMapping("/api")
public class FileController {


    private final StorageService storageService;

    private FileService service;

    //private List<FileDTO> files = new ArrayList<FileDTO>();

    public FileController(FileService service, StorageService storageService) {
        this.service = service;
        this.storageService = storageService;
    }

    @GetMapping(value = "/files")
    public List<File> getFiles() {
        return service.getFiles();
    }

    @PostMapping(value = "/files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void createNewFile(@RequestPart("nuevo") CreateFileDTO nuevo,
                              @RequestPart("file") MultipartFile file,
                              @RequestParam("id") Long id) {

        String urlImagen = null;
        if (!file.isEmpty()) {
            String imagen = storageService.store(file);
            urlImagen = MvcUriComponentsBuilder
                    .fromMethodName(FileUploadController.class, "serveFile", imagen, null)
                    .build().toUriString();
        }

        File createdFile = new File();

        createdFile.setRuta(urlImagen);
        createdFile.setUserId(id);
        //service.addNewFile(file);
    }

    @DeleteMapping(value = "/files/{fileId}")
    public void deleteFile(@PathVariable("fileId") Long id) {
        service.deleteFile(id);
    }


}
