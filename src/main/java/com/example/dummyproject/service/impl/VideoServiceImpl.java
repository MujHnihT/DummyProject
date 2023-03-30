package com.example.dummyproject.service.impl;

import com.example.dummyproject.model.entity.seconddb.File;
import com.example.dummyproject.repo.seconddb.FileRepo;
import com.example.dummyproject.service.VideoService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    FileRepo repo;


    @Override
    public File getVideo(String name) {
        Optional<File> file = repo.findByName(name);
        return file.orElse(null);
    }

    @Override
    public void saveVideo(MultipartFile file, String name) throws IOException {

        File newVid = new File();
        newVid.setName(name);

        newVid.setData(IOUtils.toByteArray(file.getInputStream()));
        repo.save(newVid);
    }

    @Override
    public List<String> getAllVideoNames() {
        return null;
    }
}
