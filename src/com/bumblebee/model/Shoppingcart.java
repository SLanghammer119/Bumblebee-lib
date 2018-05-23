/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Teilnehmer2
 */
@Entity
@Table(name = "shoppingcarts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shoppingcarts.findAll", query = "SELECT s FROM Shoppingcarts s")
    , @NamedQuery(name = "Shoppingcarts.findByShopid", query = "SELECT s FROM Shoppingcarts s WHERE s.shopid = :shopid")
    , @NamedQuery(name = "Shoppingcarts.findByShopcardno", query = "SELECT s FROM Shoppingcarts s WHERE s.shopcardno = :shopcardno")
    , @NamedQuery(name = "Shoppingcarts.findByTotal", query = "SELECT s FROM Shoppingcarts s WHERE s.total = :total")
    , @NamedQuery(name = "Shoppingcarts.findByShipping", query = "SELECT s FROM Shoppingcarts s WHERE s.shipping = :shipping")})
public class Shoppingcart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "shopid")
    private Integer shopid;
    @Basic(optional = false)
    @Column(name = "shopcardno")
    private int shopcardno;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private BigDecimal total;
    @Column(name = "shipping")
    private BigDecimal shipping;
    @JoinColumn(name = "customers_custid", referencedColumnName = "custid")
    @ManyToOne(optional = false)
    private Customer customersCustid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shoppingcartsShopid")
    private Collection<Shoppingitems> shoppingitemsCollection;

    public Shoppingcart() {
    }

    public Shoppingcart(Integer shopid) {
        this.shopid = shopid;
    }

    public Shoppingcart(Integer shopid, int shopcardno) {
        this.shopid = shopid;
        this.shopcardno = shopcardno;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public int getShopcardno() {
        return shopcardno;
    }

    public void setShopcardno(int shopcardno) {
        this.shopcardno = shopcardno;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getShipping() {
        return shipping;
    }

    public void setShipping(BigDecimal shipping) {
        this.shipping = shipping;
    }

    public Customer getCustomersCustid() {
        return customersCustid;
    }

    public void setCustomersCustid(Customer customersCustid) {
        this.customersCustid = customersCustid;
    }

    @XmlTransient
    public Collection<Shoppingitems> getShoppingitemsCollection() {
        return shoppingitemsCollection;
    }

    public void setShoppingitemsCollection(Collection<Shoppingitems> shoppingitemsCollection) {
        this.shoppingitemsCollection = shoppingitemsCollection;
    }
    
}