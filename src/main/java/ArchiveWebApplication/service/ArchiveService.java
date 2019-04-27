package ArchiveWebApplication.service;

import ArchiveWebApplication.model.Box;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by 33558 on 14.03.2017.
 */
@Service
public class ArchiveService {

    @Autowired
    private Archiver archiver;

    @Transactional
    public Box addBox(Box box) {
        Box tmpBox = archiver.save(box);
        return tmpBox;
    }

    @Transactional
    public String getBoxName(long id) {
        return archiver.getBoxById(id).getName();
    }

    @Transactional
    public void deleteBox(long id) {
        archiver.delete(id);
    }

    @Transactional(readOnly = true)
    public List<Box> findAll() {
        return archiver.findAll();
    }

    @Transactional
    public byte[] archiveById(long id) {
        Box box = archiver.getBoxById(id);
        return box.getArchive();
    }

    @Transactional
    public byte[] toZipArchive(MultipartFile file) {
        byte[] array = null;
        try {
            array = file.getBytes();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ZipOutputStream zos = new ZipOutputStream(bos);
            ZipEntry ze = new ZipEntry( file.getOriginalFilename());
            ze.setSize(array.length);
            zos.putNextEntry(ze);
            zos.write(array);
            zos.closeEntry();
            zos.close();
            array = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }
}
