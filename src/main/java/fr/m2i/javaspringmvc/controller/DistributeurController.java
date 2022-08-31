
package fr.m2i.javaspringmvc.controller;

import fr.m2i.javaspringmvc.form.BalanceForm;
import fr.m2i.javaspringmvc.form.StudentForm;
import fr.m2i.javaspringmvc.model.Product;
import fr.m2i.javaspringmvc.service.ProductService;
import fr.m2i.javaspringmvc.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DistributeurController {

    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public DistributeurController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("/distributeur")
    public String showDistributeurPage() {
        return "distributeur";
    }
    
    @PostMapping("/addBalance")
    public String addBalance(@ModelAttribute("balanceForm") BalanceForm balanceForm) throws Exception{
        userService.addBalance(balanceForm.getBalance());
        return "redirect:distributeur";
    }
    
    @ModelAttribute("balanceForm")
    public BalanceForm addBalanceForm() {
        return new BalanceForm();
    }
    
    @ModelAttribute("balance")
    public Double addBalanceBean() throws Exception {
        return userService.getBalance();
    }

    @ModelAttribute("products")
    public List<Product> addProductsBean() throws Exception {
        return productService.findAll();
    }
}
