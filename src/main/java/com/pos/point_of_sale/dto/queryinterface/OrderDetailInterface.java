package com.pos.point_of_sale.dto.queryinterface;

import java.util.ArrayList;
import java.util.Date;

public interface OrderDetailInterface {
//these are type methods
    String getCustomerName();
    String getCustomerAddress();
    String getContactNumber();
    Date getDate();
    Double getTotal();
}
