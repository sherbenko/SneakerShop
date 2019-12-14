package com.example.sweater.domain;



import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    private String text;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id")
//    private User author;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Basket() {
    }

    public Basket(Product product, User user) {
        this.product = product;
        this.user = user;
    }
    //    public Basket(Set<Product> product, User user) {
//        this.product = product;
//        this.user = user;
//    }


    public Basket(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Set<Product> getProduct() {
//        return product;
//    }
//
//    public void setProduct(Set<Product> product) {
//        this.product = product;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
