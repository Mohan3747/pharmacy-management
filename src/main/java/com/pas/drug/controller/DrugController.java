package com.pas.drug.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pas.drug.model.Drug;
import com.pas.drug.repository.DrugRepository;

@RestController
@RequestMapping("/pas")
public class DrugController {

    @Autowired
    DrugRepository drugRepository;

    @GetMapping("drugs/{id}")
    public ResponseEntity<Drug> getDrugById(@PathVariable("id") long id) {
        Optional<Drug> drugData = drugRepository.findById(id);

        if (drugData.isPresent()) {
            return new ResponseEntity<>(drugData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addDrugs")
    public ResponseEntity<Drug> createDrug(@RequestBody Drug drug ){
        try{
            Drug dd = new Drug(drug.getId(),drug.getName(),drug.getDescription(),drug.getPrice(),drug.getSupplierName(),drug.getTotalQuantity());
            Drug _drug = drugRepository.save(dd);
            return new ResponseEntity<>(_drug,HttpStatus.CREATED);
        }
        catch(Exception e){
                     return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/drugs/{id}")
    
        public ResponseEntity<Drug> updateDrug(@PathVariable("id") long id,@RequestBody Drug drug ){
         Optional<Drug> drugData = drugRepository.findById(id);

         if(drugData.isPresent())
         {
            Drug  _drug = drugData.get();
             _drug .setName(drug.getName());
            _drug .setDescription(drug.getDescription());    
            _drug .setPrice(drug.getPrice());
            _drug .setSupplierName(drug.getSupplierName());
            _drug .setTotalQuantity(drug.getTotalQuantity());
            return new ResponseEntity<>(drugRepository.save(_drug),HttpStatus.OK);
         }
         else
         {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         } 
    }

    @DeleteMapping("/drugs/{id}")
    public ResponseEntity<HttpStatus> deletedrug(@PathVariable("id") long id){
        try{
            drugRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
  
   @DeleteMapping("/deleteAll")
   public ResponseEntity<HttpStatus> deleteAlldrug(){
   try{
    drugRepository.deleteAll();
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
   catch(Exception e){
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
   }
   }
   

}
