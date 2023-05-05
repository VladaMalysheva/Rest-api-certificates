package com.epam.esm.controller;

import com.epam.esm.errorHandling.DbException;
import com.epam.esm.errorHandling.ErrorResponse;
import com.epam.esm.repository.entities.GiftCertificate;
import com.epam.esm.repository.entities.Tag;
import com.epam.esm.service.GiftCertificateService;
import com.epam.esm.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class GreetController {

    @ExceptionHandler(DbException.class)
    public ResponseEntity<ErrorResponse> handleDbException(DbException exc){
        ErrorResponse err = new ErrorResponse();
        err.setStatus(exc.getStatus().value());
        err.setMessage(exc.getMessage());
        err.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(err, exc.getStatus());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoHandlerFoundException(NoHandlerFoundException exc) {
        ErrorResponse err = new ErrorResponse();
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage("Endpoint "+exc.getRequestURL()+" not found");
        err.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAllExceptions(Exception exc) {
        ErrorResponse err = new ErrorResponse();
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage(exc.getMessage());
        err.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

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
    public List<GiftCertificate> showAll(@RequestParam(required = false) String tag, @RequestParam(required = false) String sort,@RequestParam(required = false) String description)
    {
        if (sort!=null) {
            if(!(sort.equalsIgnoreCase("asc")||sort.equalsIgnoreCase("desc")))throw new RuntimeException("error");
        }

        if (tag!=null) {
            return giftCertificateService.getByTagName(tag, sort, description);
        } else if (description!=null) {
            return giftCertificateService.getByDescriptionOrName(description, sort);
        } else {
            return giftCertificateService.getAll(sort);
        }

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

//    @GetMapping("/giftCertificates/tag/{name}")
//    public List<GiftCertificate> getCertificateByTagName(@PathVariable String name)
//    {
//        return giftCertificateService.getByTagName(name);
//    }


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

    @RequestMapping(value = "{path:[^\\\\.]*}/**")
    public void handleNotFound(HttpServletRequest request) throws NoHandlerFoundException {
        String httpMethod = request.getMethod();
        String requestUrl = request.getRequestURI();
        HttpHeaders headers = new HttpHeaders();

        throw new NoHandlerFoundException(httpMethod, requestUrl, headers);
    }
}
