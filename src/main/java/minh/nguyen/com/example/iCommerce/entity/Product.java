package minh.nguyen.com.example.iCommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<DetailCart> detailCarts;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
//    private Set<ProductColor> productColors;
//
    @ManyToMany(targetEntity = Color.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "product_color",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "color_id")}
    )
    private Set<Color> colors;
}
