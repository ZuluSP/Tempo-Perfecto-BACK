package com.tempoPerfecto.controller;
/*
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileUploadController {

    /*
     * Invoca a la vista principal de la aplicación
     */

   /* @GetMapping("/")
    public String index() {
        return "upload";
    }
*/
    /**
     * @param file       el file como tal
     * @param attributes muestran el resultado de la carga del archivo
     * @return
     */
    /*@PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) throws IOException {
        if(file == null || file.isEmpty()){
            attributes.addFlashAttribute("message", "Por favor, seleccione un archivo");
            return "redirect: status";
        }
        StringBuilder builder = new StringBuilder();
        File directory = new File("./id");
        if(!directory.exists()){
            directory.mkdir();
        }
        String separator = System.getProperty("file.separator");
        builder.append("." + separator + "id");

        byte[] fileBytes = file.getBytes(); //obtenemos los bytes del archivo que el usuario ha subido
        Path path = Paths.get(builder.toString()); //obtiene la ruta y crea el archivo en caso de que no exista
        Files.write(path,fileBytes); //escribimos los bytes del archivo que el usuario subió al nuevo archivo

        attributes.addFlashAttribute("message", "Archivo cargado correctamente [" + builder.toString() + "]");
        return null;
    }
    @GetMapping("/status")
    public String status(){
        return "status";
    }
}*/
