package com.aas.hybrid.abehayat;

import java.util.Date;

/**
 * Created by Mansoor ul Islam on 6/12/2018.
 */

public final class OrderClass {
    private OrderClass(){}

    public static class ord{
        public static final String tablename = "CustomerOrder";

        public static final String ordNo = "OrderNo";
        public static final String ordSt = "OrderStatus";
        public static final String OrdDate = "OrderDate";
        public static final String ordDelDate = "DeliveryDate";
        public static final String ordQuan = "BottleQuantity";
        public static final String BotlSize = "BottleSize";
        public static final String CusmID = "CustomerID";

        private long customerId;
        private Date DeliveryDate;
        private Date OrderDate;
        private long OrderNo;
        private String OrderStatus;
        private int Quantity;
        private int Size;


        public void setOrderDate() {

            //  Calendar calender=Calendar.getInstance();
            // OrderDate= DateFormat.getDateInstance().format(calender.getTime());
            //  TextView ordate= findviewbyid(R.id.ordate);

        }
        public Date getOrderDate() {
            return OrderDate;
        }



        public void setOrderNo(int OrderNo) {
            this.OrderNo = OrderNo;
        }
        public long getOrderNo() {
            return OrderNo;
        }

        public void setDeliveryDate() {

        }
        public Date getDeliveryDate() {
            return DeliveryDate;
        }

        public void setQuantity() {

            this.Quantity = Quantity;
        }
        public int getQuantity() {
            return Quantity;
        }



        public String getOrderStatus() {
            return OrderStatus;
        }

        public void setOrderStatus(String OrderStatus) {
            this.OrderStatus = OrderStatus;
        }

        private void MangaeOrderStatus() {
            // TODO Auto-generated method
        }

    }
}
