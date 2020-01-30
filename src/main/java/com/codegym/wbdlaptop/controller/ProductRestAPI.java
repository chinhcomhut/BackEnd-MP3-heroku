//package com.codegym.wbdlaptop.controller;
//
//import com.codegym.wbdlaptop.message.request.SearchProductByLineAndName;
//import com.codegym.wbdlaptop.message.request.SearchProductByNameForm;
//import com.codegym.wbdlaptop.model.Song;
//import com.codegym.wbdlaptop.service.IProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//import java.util.Optional;
//
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping("/api/auth")
//public class ProductRestAPI {
//
//    @Autowired
//    private IProductService productService;
//
//    @GetMapping("/product/pagination")
//    public ResponseEntity<?> getListProductAndPagination(@PageableDefault(value = 2 , sort = "date" ,direction = Sort.Direction.ASC) Pageable pageable) {
////        DESC = Old , ASC = new
//        Page<Song> products =  productService.findAll(pageable);
//
//        if (products.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }
//
//    @GetMapping("/product")
//    public ResponseEntity<?> getListProduct() {
//        List<Song> songs = (List<Song>) productService.findAll();
//        if(songs.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//
//        return new ResponseEntity<>(songs,HttpStatus.OK);
//    }
//
//    @GetMapping("/product/{id}")
//    public ResponseEntity<?> getProduct(@PathVariable Long id) {
//        Optional<Song> product = productService.findById(id);
//
//        if (!product.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity<>(product, HttpStatus.OK);
//    }
//
//    @PostMapping("/product")
//    public ResponseEntity<?> createProduct(@Valid @RequestBody Song song) {
//
//        productService.save(song);
//
//        return new ResponseEntity<>(song, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/product/{id}")
//    public ResponseEntity<?> updateProduct(@Valid @RequestBody Song song, @PathVariable Long id) {
//        Optional<Song> product1 = productService.findById(id);
//
//        if (!product1.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        product1.get().(song.getNameSong());
//        product1.get().setCpu(song.getCpu());
//        product1.get().setRam(song.getRam());
//        product1.get().setPrice(song.getPrice());
//        product1.get().setDescription(song.getDescription());
//        product1.get().setUpdate(true);
//        product1.get().setSinger(song.getSinger());
//        product1.get().setUser(song.getUser());
//
//        productService.save(product1.get());
//
//        return new ResponseEntity<>(product1, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/product/{id}")
//    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
//        Optional<Song> product = productService.findById(id);
//
//        if (!product.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        productService.delete(id);
//
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @PostMapping("/product/search-by-name")
//    public ResponseEntity<?> searchProductByName(@RequestBody SearchProductByNameForm nameForm) {
//        if (nameForm.getName() == "" || nameForm.getName() == null ) {
//            List<Song> songs = (List<Song>) productService.findAll();
//
//            if(songs.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            } else {
//                return new ResponseEntity<>(songs,HttpStatus.OK);
//            }
//        }
//
//        List<Song> songs = (List<Song>) productService.findProductsByNameContaining(nameForm.getName());
//        if(songs.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(songs,HttpStatus.OK);
//        }
//    }
//
//    @GetMapping("/product/search-by-lineId/{id}")
//    public ResponseEntity<?> searchByLineId(@PathVariable Long id) {
//        List<Song> songs = (List<Song>) productService.findProductsByLineId(id);
//
//        if (songs.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//
//        return new ResponseEntity<>(songs,HttpStatus.OK);
//    }
//
//    @PostMapping("/product/search-by-line-and-name")
//    public ResponseEntity<?> searchProductByLineAndName(@RequestBody SearchProductByLineAndName searchForm) {
//        if (searchForm.getName() == null && searchForm.getLineId() == null) {
//            List<Song> songs = (List<Song>) productService.findAll();
//            if(songs.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(songs,HttpStatus.OK);
//        }
//
//        if (searchForm.getName() == null && searchForm.getLineId() != null) {
//            List<Song> songs = (List<Song>) productService.findProductsByLineId(searchForm.getLineId());
//            if(songs.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(songs,HttpStatus.OK);
//        }
//
//        if (searchForm.getName() != null && searchForm.getLineId() == null) {
//            List<Song> songs = (List<Song>) productService.findProductsByNameContaining(searchForm.getName());
//            if(songs.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(songs,HttpStatus.OK);
//        }
//
//        if (searchForm.getLineId() != null && searchForm.getName() != null) {
//            List<Song> songs = (List<Song>) productService.findProductsByLineIdAndNameContaining(searchForm.getLineId(),searchForm.getName());
//            if(songs.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(songs,HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}
