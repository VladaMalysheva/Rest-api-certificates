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

/**

 This class provides REST API endpoints for managing GiftCertificates and Tags.
 */
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

    /**
     * Retrieves a single GiftCertificate by its id.
     * @param id The id of the GiftCertificate to retrieve.
     * @return The GiftCertificate with the specified id.
     */
    @GetMapping("/giftCertificates/{id}")
    public GiftCertificate showOneCertificate(@PathVariable int id)
    {
        return giftCertificateService.getById(id);
    }

    /**
     * Retrieves a list of all Gift Certificates. Can receive three parameters that are optional and can be used in conjunction.
     * @param tag The name of the tag, which you want your certificate to belong to.
     * @param sort Sorting option, can sort the result in ascent or descent order by name of the GiftCertificate. Accepts either "asc" or "desc" value.
     * @param description Filters Gift Certificates by the part of their name or description.
     * @return List of GiftCertificates that is sorted or filtered depending on parameters.
     */
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

    /**
     * Saves Gift Certificate, which is transmitted through the certificate parameter, to the database.
     * @param certificate GiftCertificate object to add. Should be passed through the RequestBody in JSON format. JSON object should contain the next fields:
     *                    - name (String): the name of the GiftCertificate.
     *                    - description (String): the description of the GiftCertificate.
     *                    - price (float): the price of the GiftCertificate.
     *                    - duration (Date): the duration of the GiftCertificate.
     *                    - createDate (Date): the creation date of the GiftCertificate.
     *                    - lastUpdateDate (Date): the last update date of the GiftCertificate.
     * @return True if the GiftCertificate was added successfully, Exception otherwise.
     */
    @PostMapping("/giftCertificates")
    public boolean addCertificate(@RequestBody GiftCertificate certificate)
    {
        return giftCertificateService.save(certificate);
    }

    /**
     * Updates the existing GiftCertificate in database. Uses id from the certificate parameter in the RequestBody to find the GiftCertificate to update in database.
     * @param certificate GiftCertificate object to update. Should be passed through the RequestBody in JSON format. JSON object should contain the next fields:
     *                   - id (int): the id of the updated GiftCertificate.
     *                   - name (String): the name of the updated GiftCertificate.
     *                   - description (String): the description of the updated GiftCertificate.
     *                   - price (float): the price of the updated GiftCertificate.
     *                   - duration (Date): the duration of the updated GiftCertificate.
     *                   - createDate (Date): the creation date of the updated GiftCertificate.
     *                   - lastUpdateDate (Date): the last update date of the updated GiftCertificate.
     * @return True if the GiftCertificate was updated successfully, Exception otherwise.
     */
    @PutMapping("/giftCertificates")
    public boolean updateCertificate(@RequestBody GiftCertificate certificate)
    {

        return giftCertificateService.update(certificate);
    }

    /**
     * Deletes GiftCertificate with the given id from the database.
     * @param id The id of the GiftCertificate which you want to delete.
     * @return True if the GiftCertificate was deleted successfully, Exception otherwise.
     */
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

    /**
     * Retrieves Tag with the given id from the database.
     * @param id The id of the Tag which you want to retrieve.
     * @return Tag with the specified id.
     */
    @GetMapping("/tags/{id}")
    public Tag showOneTag(@PathVariable int id)
    {
        return tagService.getById(id);
    }

    /**
     * Retrieves all Tags from the database.
     * @return The list of all Tags.
     */
    @GetMapping("/tags")
    public List<Tag> showAllTags()
    {
        return tagService.getAll();
    }

    /**
     * Saves Tag, which is transmitted through the tag parameter, to the database.
     * @param tag The Tag object to add. Should be passed through the RequestBody in JSON format. JSON object should contain the next fields:
     *            - name (String): the name of the tag.
     * @return True if the Tag was added successfully, Exception otherwise.
     */
    @PostMapping("/tags")
    public boolean addTag(@RequestBody Tag tag)
    {
        return tagService.save(tag);
    }

    /**
     * Deletes Tag with the given id from the database.
     * @param id The id of the Tag which you want to delete.
     * @return True if the Tag was deleted successfully, Exception otherwise.
     */
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
