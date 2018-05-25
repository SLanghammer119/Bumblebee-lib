/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author Stefanie Langhammer
 */
@Entity
@Table(name = "shoppingitems")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shoppingitem.findAll", query = "SELECT s FROM Shoppingitem s")
    , @NamedQuery(name = "Shoppingitem.findByShopitemid", query = "SELECT s FROM Shoppingitem s WHERE s.shopitemid = :shopitemid")
    , @NamedQuery(name = "Shoppingitem.findByNumber", query = "SELECT s FROM Shoppingitem s WHERE s.number = :number")
    , @NamedQuery(name = "Shoppingitem.findByTotalLine", query = "SELECT s FROM Shoppingitem s WHERE s.totalLine = :totalLine")})
public class Shoppingitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "shopitemid")
    private Integer shopitemid;
    @Column(name = "number")
    private Integer number;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "totalLine")
    private Double totalLine;
    
    @ManyToOne(targetEntity=Article.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="articles_artid", referencedColumnName = "artid")
    private Article article;
    
    
    public Shoppingitem() {
    }

    public Shoppingitem(Article a) {
        article = new Article(a.getArtid(), a.getArticleno(), a.getName(), a.getPrice(), a.getPhoto(), a.getArticledescriptions(), a.getArticlesizes(), a.getArticlecolors(), a.getArticlematerials(), a.getCare(), a.getSubcategory());
        this.number=0;
        this.totalLine=0.0;
        
    }
    
    public Shoppingitem(Integer shopitemid, Integer number, Double totalLine, Article article) {
        this.shopitemid = shopitemid;
        this.number = number;
        this.totalLine = totalLine;
        this.article = article;
    }
    
    public Integer getShopitemid() {
        return shopitemid;
    }

    public void setShopitemid(Integer shopitemid) {
        this.shopitemid = shopitemid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getTotalLine() {
        return totalLine;
    }

    public void setTotalLine(Double totalLine) {
        this.totalLine = totalLine;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    


    
}
