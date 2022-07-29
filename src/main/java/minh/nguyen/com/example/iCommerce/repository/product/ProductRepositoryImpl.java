package minh.nguyen.com.example.iCommerce.repository.product;

import minh.nguyen.com.example.iCommerce.entity.Branch;
import minh.nguyen.com.example.iCommerce.entity.Category;
import minh.nguyen.com.example.iCommerce.entity.Color;
import minh.nguyen.com.example.iCommerce.entity.Product;
import minh.nguyen.com.example.iCommerce.filter.ProductFilter;
import minh.nguyen.com.example.iCommerce.repository.product.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class ProductRepositoryImpl implements ProductRepositoryCustom {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Product> filterProduct(ProductFilter productFilter) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> productRoot = cq.from(Product.class);
        List<Predicate> filter = new ArrayList<>();

        if (productFilter.getId() != null) {
            filter.add(cb.equal(productRoot.get("id"), productFilter.getId()));
        }
        if (productFilter.getProductName() != null) {
            filter.add(
                    cb.like(
                        cb.lower(productRoot.get("name")),
                        "%" + productFilter.getProductName().toLowerCase() + "%"
                    )
            );
        }
        if (productFilter.getPrice() != null) {
            filter.add(
                    cb.equal(
                            productRoot.get("price"),
                            productFilter.getPrice()
                    )
            );
        }

        if (productFilter.getBranchName() != null) {
            Join<Product, Branch> branchJoin = productRoot.join("branch");
            filter.add(
                    cb.like(
                            cb.lower(branchJoin.get("branchName")),
                            "%" + productFilter.getBranchName().toLowerCase() + "%"
                    )
            );
        }

        if (productFilter.getCategoryName() != null) {
            Join<Product, Category> categoryJoin = productRoot.join("category");
            filter.add(
                    cb.like(
                            cb.lower(categoryJoin.get("categoryName")),
                            "%" + productFilter.getCategoryName().toLowerCase() + "%"
                    )
            );
        }
        cq.where(filter.toArray(new Predicate[0]));
        TypedQuery<Product> query = em.createQuery(cq);
        List<Product> products = query.getResultList();
        return products;
    }
}
