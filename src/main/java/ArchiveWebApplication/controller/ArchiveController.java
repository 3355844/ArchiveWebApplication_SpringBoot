package ArchiveWebApplication.controller;

import ArchiveWebApplication.model.ArchiveNotFoundException;
import ArchiveWebApplication.service.ArchiveService;
import ArchiveWebApplication.model.Box;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by 33558 on 14.03.2017.
 */
@Controller
public class ArchiveController {
    @Autowired
    ArchiveService service;

    @RequestMapping("/box/*")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/box/add", method = RequestMethod.POST)
    public String add(@RequestParam(value = "file") MultipartFile file, Model model) throws IOException {
        if (!file.isEmpty()) {
            Box box = new Box();
            box.setName(file.getOriginalFilename());
            box.setDate(new Date());
            box.setArchive(service.toZipArchive(file));
            service.addBox(box);
            return toAll(model);
        } else {
            model.addAttribute("mess", "File is not selected !!!");
            return "index";
        }
    }

    @RequestMapping ("/box/dell/{boxId}")
    public String dellArchive(@PathVariable("boxId") long id, Model model){
        service.deleteBox(id);
        return toAll(model);
    }

    @RequestMapping("/box/download/{boxId}")
    public ResponseEntity<byte[]> downloadArchive(@PathVariable("boxId") long id) {
        System.out.println("Come to method download archive with id: " + id);
        byte[] archive = service.archiveById(id);
        if (archive == null) throw new ArchiveNotFoundException();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.set("Content-Disposition","attachment; filename=\""
                + service.getBoxName(id)+"_ .zip");
        System.out.println(archive.length);
        return new ResponseEntity<byte[]>(archive, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/box/all")
    public String toAll(Model model) {
        List<Box> boxList;
        boxList = service.findAll();
        for (Box box1 : boxList) {
            System.out.println(box1.toString());
        }
        model.addAttribute("list", boxList);
        return "/box/all";
    }
}
