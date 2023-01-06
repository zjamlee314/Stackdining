package com.stackdining.www.model.bean;

import java.util.List;

public class NewDishesListBean {

    private List<DataDTO> data;
    private int status;
    private String msg;

    public List<DataDTO> getData() {
        return data;
    }

    public void setData(List<DataDTO> data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataDTO {
        private String category;
        private List<FoodListDTO> food_list;

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public List<FoodListDTO> getFood_list() {
            return food_list;
        }

        public void setFood_list(List<FoodListDTO> food_list) {
            this.food_list = food_list;
        }

        public static class FoodListDTO {
            private int id;
            private String restaurant_code;
            private int category_id;
            private String dish_name;
            private String original_price;
            private int discount;
            private int prep_time;
            private int stock;
            private int state;
            private int cook_time;
            private String portions;
            private String picture_url;
            private int is_limit;
            private int is_recommend;
            //@com.alibaba.fastjson.annotation.JSONField(name = "Introduction")
            private String introduction;
            private int printer_id;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getRestaurant_code() {
                return restaurant_code;
            }

            public void setRestaurant_code(String restaurant_code) {
                this.restaurant_code = restaurant_code;
            }

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public String getDish_name() {
                return dish_name;
            }

            public void setDish_name(String dish_name) {
                this.dish_name = dish_name;
            }

            public String getOriginal_price() {
                return original_price;
            }

            public void setOriginal_price(String original_price) {
                this.original_price = original_price;
            }

            public int getDiscount() {
                return discount;
            }

            public void setDiscount(int discount) {
                this.discount = discount;
            }

            public int getPrep_time() {
                return prep_time;
            }

            public void setPrep_time(int prep_time) {
                this.prep_time = prep_time;
            }

            public int getStock() {
                return stock;
            }

            public void setStock(int stock) {
                this.stock = stock;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public int getCook_time() {
                return cook_time;
            }

            public void setCook_time(int cook_time) {
                this.cook_time = cook_time;
            }

            public String getPortions() {
                return portions;
            }

            public void setPortions(String portions) {
                this.portions = portions;
            }

            public String getPicture_url() {
                return picture_url;
            }

            public void setPicture_url(String picture_url) {
                this.picture_url = picture_url;
            }

            public int getIs_limit() {
                return is_limit;
            }

            public void setIs_limit(int is_limit) {
                this.is_limit = is_limit;
            }

            public int getIs_recommend() {
                return is_recommend;
            }

            public void setIs_recommend(int is_recommend) {
                this.is_recommend = is_recommend;
            }

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public int getPrinter_id() {
                return printer_id;
            }

            public void setPrinter_id(int printer_id) {
                this.printer_id = printer_id;
            }
        }
    }
}
