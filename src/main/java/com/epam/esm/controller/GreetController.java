package com.epam.esm.controller;

import com.epam.esm.repository.entities.GiftCertificate;
import com.epam.esm.repository.entities.Tag;
import com.epam.esm.service.GiftCertificateService;
import com.epam.esm.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetController {

    @Autowired
    private GiftCertificateService giftCertificateService;

    @Autowired
    private TagService tagService;

    public GreetController(GiftCertificateService giftCertificateService, TagService tagService) {
        this.giftCertificateService = giftCertificateService;
        this.tagService=tagService;
    }

    @GetMapping("/giftCertificates/{id}")
    public GiftCertificate showOneCertificate(@PathVariable int id)
    {
        return giftCertificateService.getById(id);
    }

    @GetMapping("/giftCertificates")
    public List<GiftCertificate> showAll()
    {
        return giftCertificateService.getAll();
    }

    @PostMapping("/giftCertificates")
    public boolean addCertificate(@RequestBody GiftCertificate certificate)
    {
        return giftCertificateService.save(certificate);
    }

    @PutMapping("/giftCertificates")
    public boolean updateCertificate(@RequestBody GiftCertificate certificate)
    {

        return giftCertificateService.update(certificate);
    }

    @DeleteMapping("/giftCertificates/{id}")
    public boolean deleteCertificate(@PathVariable int id)
    {
        return giftCertificateService.delete(id);
    }


    @GetMapping("/tags/{id}")
    public Tag showOneTag(@PathVariable int id)
    {
        return tagService.getById(id);
    }

    @GetMapping("/tags")
    public List<Tag> showAllTags()
    {
        return tagService.getAll();
    }

    @PostMapping("/tags")
    public boolean addTag(@RequestBody Tag tag)
    {
        return tagService.save(tag);
    }

    @DeleteMapping("/tags/{id}")
    public boolean deleteTag(@PathVariable int id)
    {
        return tagService.delete(id);
    }
}
