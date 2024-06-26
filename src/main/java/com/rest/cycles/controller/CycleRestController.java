package com.rest.cycles.controller;

import java.util.List;
import java.util.Optional;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.cycles.dto.BrandDTO;
import com.rest.cycles.entity.Brand;
import com.rest.cycles.entity.CartItem;
import com.rest.cycles.entity.Cycle;
import com.rest.cycles.entity.User;
import com.rest.cycles.repository.BorrowRepository;
import com.rest.cycles.repository.BrandRepository;
import com.rest.cycles.repository.CartRepository;
import com.rest.cycles.repository.CycleRepository;
import com.rest.cycles.repository.UserRepository;
import com.rest.cycles.service.BrandService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CycleRestController {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CycleRepository cycleRepository;

    @Autowired
    private BrandService brandService;
    
    @Autowired
    private CartRepository cartRepository;
    
    @Autowired
    private BorrowRepository borrowRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            if (userRepository.existsByName(user.getName())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
            }
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration failed: " + e.getMessage());
        }
    }

    @GetMapping("/health")
    public String checkhealth() {
        return "healthy";
    }

    @GetMapping("/brand/list")
    public List<BrandDTO> all() {
        return brandService.convert((List<Brand>) brandRepository.findAll());
    }

    @PostMapping("/brand/add")
    @ResponseBody
    public List<BrandDTO> addBrand(@RequestBody Map<String, String> reqBody) {
        int qty;
        String name;
        try {
            qty = Integer.valueOf(reqBody.get("qty"));
        } catch (Exception e) {
            qty = 0;
        }
        name = reqBody.get("name");

        System.out.println(name);

        Brand brand = new Brand();
        brand.setName(name);
        brandRepository.save(brand);

        for (int i = 0; i < Math.min(qty, 20); i++) {
            Cycle cycle = new Cycle();
            cycle.setBrand(brand);
            cycle.setAvailable(true);
            cycleRepository.save(cycle);
        }

        return brandService.convert((List<Brand>) brandRepository.findAll());

    }

    @PostMapping("brand/borrow/{id}")
    @ResponseBody
    public List<BrandDTO> borrow(@PathVariable int id, @RequestBody Map<String, Integer> reqBody) {
        int qty;
        try {
            qty = reqBody.get("qty");
        } catch (Exception e) {
            qty = 1;
        }
        System.out.println("borrow function entered");
        for (int i = 0; i < Math.min(qty, 20); i++) {
            Brand brand = brandRepository.findById(id).get();
            Optional<Cycle> c = cycleRepository.findOneAvailableCycle(id);
            System.out.println(id);
            if (c.isPresent()) {
                Cycle cycle = c.get();
                cycle.setAvailable(false);
                cycleRepository.save(cycle);
                brandRepository.save(brand);
            }
            
        }
        return brandService.convert((List<Brand>) brandRepository.findAll());
    }

    @PostMapping("brand/restock/{id}")
    @ResponseBody
    public List<BrandDTO> restock(@PathVariable int id, @RequestBody Map<String, Integer> reqBody) {
        int qty;
        try {
            qty = reqBody.get("qty");
        } catch (Exception e) {
            qty = 1;
        }
        Brand brand = brandRepository.findById(id).get();
        for (int i = 0; i < Math.min(qty, 20); i++) {
            Cycle cycle = new Cycle();
            cycle.setBrand(brand);
            cycle.setAvailable(true);
            cycleRepository.save(cycle);
        }
        
        return brandService.convert((List<Brand>) brandRepository.findAll());
    }

    @GetMapping("cycle/countAvailableByBrand/{id}")
    @ResponseBody
    public int countAvailable(@PathVariable int id) {
        return cycleRepository.countAvailableByBrandId(id);
    }

    @GetMapping("/cycle/borrowedList")
    public List<Cycle> getBorrowedCycles() {
        return (List<Cycle>) cycleRepository.findAllBorrowedCycles();
    }
    
    @GetMapping("/cycle/CartList")
    public List<CartItem> getCartCycles(){
    	System.out.println("hello function");
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        long id = userRepository.findByName(username).get().getId();
    	return cartRepository.customQueryMethodName(id);
    }

    @GetMapping("/cycle/availableList")
    public List<Cycle> getAvailableCycles() {
        return (List<Cycle>) cycleRepository.findAllAvailableCycles();
    }

    @CrossOrigin("*")
    @PostMapping("/cycle/return/{id}")
    @ResponseBody
    public List<Cycle> returnCycle(@PathVariable int id) {
        Cycle cycle = cycleRepository.findById(id).get();
        cycle.setAvailable(true);
        cycleRepository.save(cycle);
        System.out.println(cycle);
        return (List<Cycle>) cycleRepository.findAllBorrowedCycles();
    }

    @PostMapping("/cycle/borrow/{id}")
    @ResponseBody
    public List<Cycle> borrowCycle(@PathVariable int id) {
        Cycle cycle = cycleRepository.findById(id).get();
        cycle.setAvailable(false);
        cycleRepository.save(cycle);
        System.out.println(cycle);
        return (List<Cycle>) cycleRepository.findAllAvailableCycles();
    }
    
    
    @PostMapping("/brand/cart/{id}")
    public ResponseEntity<String> addToCart(@PathVariable int id) {
                        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            
            Optional<User> optionalUser = userRepository.findByName(username);

            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                
                Optional<Cycle> optionalCycle = cycleRepository.findById(id);

                if (optionalCycle.isPresent()) {
                    Cycle cycle = optionalCycle.get();
                    
                    CartItem cartItem = new CartItem();
                    Brand brand = new Brand();
                    brand.setId(id);
                    brand.setName(brandRepository.findById(id).get().getName());
                    cartItem.setBrand(brand);  
                    cartItem.setCost(cycle.getCost());
                    cartItem.setUser(user);
                    cartItem.setQuantity(1);
                    
                    cartRepository.save(cartItem);
                    return ResponseEntity.ok("Cycle added to cart successfully");
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cycle not found");
                }
    }
            return ResponseEntity.ok("user not found");
    }

}