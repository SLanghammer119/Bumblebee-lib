/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Teilnehmer2
 */
@Entity
@Table(name = "bankaccounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bankaccounts.findAll", query = "SELECT b FROM Bankaccounts b")
    , @NamedQuery(name = "Bankaccounts.findByBankid", query = "SELECT b FROM Bankaccounts b WHERE b.bankid = :bankid")
    , @NamedQuery(name = "Bankaccounts.findByFirstname", query = "SELECT b FROM Bankaccounts b WHERE b.firstname = :firstname")
    , @NamedQuery(name = "Bankaccounts.findByLastname", query = "SELECT b FROM Bankaccounts b WHERE b.lastname = :lastname")
    , @NamedQuery(name = "Bankaccounts.findByIban", query = "SELECT b FROM Bankaccounts b WHERE b.iban = :iban")
    , @NamedQuery(name = "Bankaccounts.findByBic", query = "SELECT b FROM Bankaccounts b WHERE b.bic = :bic")
    , @NamedQuery(name = "Bankaccounts.findByBankname", query = "SELECT b FROM Bankaccounts b WHERE b.bankname = :bankname")})
public class Bankaccounts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bankid")
    private Integer bankid;
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "iban")
    private String iban;
    @Column(name = "bic")
    private String bic;
    @Column(name = "bankname")
    private String bankname;
    @JoinColumn(name = "customers_custid", referencedColumnName = "custid")
    @ManyToOne(optional = false)
    private Customer customersCustid;

    public Bankaccounts() {
    }

    public Bankaccounts(Integer bankid) {
        this.bankid = bankid;
    }

    public Bankaccounts(Integer bankid, String lastname, String iban) {
        this.bankid = bankid;
        this.lastname = lastname;
        this.iban = iban;
    }

    public Integer getBankid() {
        return bankid;
    }

    public void setBankid(Integer bankid) {
        this.bankid = bankid;
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

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public Customer getCustomersCustid() {
        return customersCustid;
    }

    public void setCustomersCustid(Customer customersCustid) {
        this.customersCustid = customersCustid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bankid != null ? bankid.hashCode() : 0);
        return hash;
    }
}
