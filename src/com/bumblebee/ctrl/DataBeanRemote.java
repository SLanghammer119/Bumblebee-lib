/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.ctrl;

import com.bumblebee.model.Customer;
import javax.ejb.Remote;

/**
 *
 * @author Stefanie Langhammer
 */
@Remote
public interface DataBeanRemote {
    
    public Customer getCustomer(String email);
    
    
}
