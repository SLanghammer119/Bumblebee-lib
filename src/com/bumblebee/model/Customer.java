/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "customers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c")
    , @NamedQuery(name = "Customers.findByCustid", query = "SELECT c FROM Customers c WHERE c.custid = :custid")
    , @NamedQuery(name = "Customers.findByCustomerno", query = "SELECT c FROM Customers c WHERE c.customerno = :customerno")
    , @NamedQuery(name = "Customers.findByFirstname", query = "SELECT c FROM Customers c WHERE c.firstname = :firstname")
    , @NamedQuery(name = "Customers.findByLastname", query = "SELECT c FROM Customers c WHERE c.lastname = :lastname")
    , @NamedQuery(name = "Customers.findByStreet", query = "SELECT c FROM Customers c WHERE c.street = :street")
    , @NamedQuery(name = "Customers.findByHouseno", query = "SELECT c FROM Customers c WHERE c.houseno = :houseno")
    , @NamedQuery(name = "Customers.findByPostcode", query = "SELECT c FROM Customers c WHERE c.postcode = :postcode")
    , @NamedQuery(name = "Customers.findByTown", query = "SELECT c FROM Customers c WHERE c.town = :town")
    , @NamedQuery(name = "Customers.findByCountry", query = "SELECT c FROM Customers c WHERE c.country = :country")
    , @NamedQuery(name = "Customers.findByPhone", query = "SELECT c FROM Customers c WHERE c.phone = :phone")
    , @NamedQuery(name = "Customers.findByEmail", query = "SELECT c FROM Customers c WHERE c.email = :email")
    , @NamedQuery(name = "Customers.findByPassword", query = "SELECT c FROM Customers c WHERE c.password = :password")
    , @NamedQuery(name = "Customers.findByCategory", query = "SELECT c FROM Customers c WHERE c.category = :category")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "custid")
    private Integer custid;
    @Basic(optional = false)
    @Column(name = "customerno")
    private String customerno;
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "street")
    private String street;
    @Basic(optional = false)
    @Column(name = "houseno")
    private String houseno;
    @Basic(optional = false)
    @Column(name = "postcode")
    private String postcode;
    @Basic(optional = false)
    @Column(name = "town")
    private String town;
    @Column(name = "country")
    private String country;
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "category")
    private String category;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customersCustid")
    private Collection<Shoppingcarts> shoppingcartsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customersCustid")
    private Collection<Deliveryadresses> deliveryadressesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customersCustid")
    private Collection<Bankaccounts> bankaccountsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customersCustid")
    private Collection<Creditcards> creditcardsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customersCustid")
    private Collection<Orders> ordersCollection;

    public Customer() {
    }

    public Customer(Integer custid) {
        this.custid = custid;
    }

    public Customer(Integer custid, String customerno, String lastname, String street, String houseno, String postcode, String town, String email, String password, String category) {
        this.custid = custid;
        this.customerno = customerno;
        this.lastname = lastname;
        this.street = street;
        this.houseno = houseno;
        this.postcode = postcode;
        this.town = town;
        this.email = email;
        this.password = password;
        this.category = category;
    }

    public Integer getCustid() {
        return custid;
    }

    public void setCustid(Integer custid) {
        this.custid = custid;
    }

    public String getCustomerno() {
        return customerno;
    }

    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseno() {
        return houseno;
    }

    public void setHouseno(String houseno) {
        this.houseno = houseno;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @XmlTransient
    public Collection<Shoppingcarts> getShoppingcartsCollection() {
        return shoppingcartsCollection;
    }

    public void setShoppingcartsCollection(Collection<Shoppingcarts> shoppingcartsCollection) {
        this.shoppingcartsCollection = shoppingcartsCollection;
    }

    @XmlTransient
    public Collection<Deliveryadresses> getDeliveryadressesCollection() {
        return deliveryadressesCollection;
    }

    public void setDeliveryadressesCollection(Collection<Deliveryadresses> deliveryadressesCollection) {
        this.deliveryadressesCollection = deliveryadressesCollection;
    }

    @XmlTransient
    public Collection<Bankaccounts> getBankaccountsCollection() {
        return bankaccountsCollection;
    }

    public void setBankaccountsCollection(Collection<Bankaccounts> bankaccountsCollection) {
        this.bankaccountsCollection = bankaccountsCollection;
    }

    @XmlTransient
    public Collection<Creditcards> getCreditcardsCollection() {
        return creditcardsCollection;
    }

    public void setCreditcardsCollection(Collection<Creditcards> creditcardsCollection) {
        this.creditcardsCollection = creditcardsCollection;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }
    
}
