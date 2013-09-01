/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.powha.ecommerse;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jon
 */
@Entity
@Table(name = "Ordering")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordering.findAll", query = "SELECT o FROM Ordering o"),
    @NamedQuery(name = "Ordering.findById", query = "SELECT o FROM Ordering o WHERE o.id = :id"),
    @NamedQuery(name = "Ordering.findByPlacedAt", query = "SELECT o FROM Ordering o WHERE o.placedAt = :placedAt")})
public class Ordering implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "placedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date placedAt;
    @JoinTable(name = "Ordering_has_Product", joinColumns = {
        @JoinColumn(name = "Ordering_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "Product_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Product> productCollection;
    @JoinColumn(name = "Customer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Customer customerid;

    public Ordering() {
    }

    public Ordering(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPlacedAt() {
        return placedAt;
    }

    public void setPlacedAt(Date placedAt) {
        this.placedAt = placedAt;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    public Customer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Customer customerid) {
        this.customerid = customerid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordering)) {
            return false;
        }
        Ordering other = (Ordering) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.powha.ecommerse.Ordering[ id=" + id + " ]";
    }
    
}
