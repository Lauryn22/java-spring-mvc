
package fr.m2i.javaspringmvc.service;



import fr.m2i.javaspringmvc.model.Product;
import fr.m2i.javaspringmvc.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository repo;
    private final UserService userService;

    @Autowired
    public ProductService(ProductRepository repo, UserService userService) {
        this.repo = repo;
        this.userService = userService;
    }
    
    // lister les produits
    
    public List<Product> findAll() {
        return repo.findAll();
    }
    
    
    
    // find by id
    
    // save
    
    // acheter un produit
    // -> Est ce que j'ai assez de crédit ?
    // -> Est ce que le produit existe ? il reste du stock ?
}
