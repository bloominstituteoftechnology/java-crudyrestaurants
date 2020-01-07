package com.lambdaschool.crudyrestaurants.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurants")
@JsonIgnoreProperties("hasvalueforseatcapacity")
public class Restaurant
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long restaurantid;

    @Column(unique = true,
            nullable = false)
    private String name;

    private String address;
    private String city;
    private String state;
    private String telephone;

    @Transient
    public boolean hasvalueforseatcapacity = false;
    private int seatcapacity;

    @OneToMany(mappedBy = "restaurant",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    @JsonIgnoreProperties("restaurant")
    private List<Menu> menus = new ArrayList<>();

    @ManyToMany()
    @JoinTable(name = "restaurantpayments",
               joinColumns = @JoinColumn(name = "restaurantid"),
               inverseJoinColumns = @JoinColumn(name = "paymentid"))
    @JsonIgnoreProperties("restaurants")
    List<Payment> payments = new ArrayList<>();

    public Restaurant()
    {
    }

    public Restaurant(String name,
                      String address,
                      String city,
                      String state,
                      String telephone,
                      int seatcapacity)
    {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.telephone = telephone;
        this.seatcapacity = seatcapacity;
    }

    public long getRestaurantid()
    {
        return restaurantid;
    }

    public void setRestaurantid(long restaurantid)
    {
        this.restaurantid = restaurantid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public List<Menu> getMenus()
    {
        return menus;
    }

    public void setMenus(List<Menu> menus)
    {
        this.menus = menus;
    }

    public int getSeatcapacity()
    {
        return seatcapacity;
    }

    public void setSeatcapacity(int seatcapacity)
    {
        hasvalueforseatcapacity = true;
        this.seatcapacity = seatcapacity;
    }

    public List<Payment> getPayments()
    {
        return payments;
    }

    public void setPayments(List<Payment> payments)
    {
        this.payments = payments;
    }

    public void addPayment(Payment payment)
    {
        payments.add(payment);
        payment.getRestaurants()
               .add(this);
    }

    public void removePayment(Payment payment)
    {
        payments.remove(payment);
        payment.getRestaurants()
               .remove(this);
    }

    @Override
    public String toString()
    {
        return "\n\tRestaurant{" + "restaurantid=" + restaurantid + ", name='" + name + '\'' + ", address='" + address + '\'' + ", city='" + city + '\'' + ", state='" + state + '\'' + ", telephone='" + telephone + '\'' + ", hasvalueforseatcapacity=" + hasvalueforseatcapacity + ", seatcapacity=" + seatcapacity + ", menus=" + menus + ", payments=" + payments + '}';
    }
}