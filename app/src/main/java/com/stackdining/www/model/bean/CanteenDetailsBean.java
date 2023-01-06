package com.stackdining.www.model.bean;

import java.util.List;

/**
 * Created by Evan
 * on 2022/12/27
 */
public class CanteenDetailsBean {

    private DataBean data;
    private int status;
    private String msg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
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

    public static class DataBean {
        private int id;
        private String restaurant_code;
        private String manage_code;
        private String restaurant_name;
        private int state;
        private int diet_style;
        private List<String> service;
        private BusinessHoursBean business_hours;
        private PersonInChargeBean person_in_charge;
        private String phone;
        private String address;
        private String full_address;
        private String nearby_address;
        private String latlng;
        private int total_tables;
        private String logo_img_url;
        private String background_img_url;
        private int point;
        private Object pay;
        private Object deleted_at;
        private String created_at;
        private String updated_at;
        private boolean is_collect;
        private int score;
        private String distance;
        private int reviews;


        public void setDistance(String distance) {
            this.distance = distance;
        }

        public void setReviews(int reviews) {
            this.reviews = reviews;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getReviews() {
            return reviews;
        }

        public int getScore() {
            return score;
        }

        public String getDistance() {
            return distance;
        }

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

        public String getManage_code() {
            return manage_code;
        }

        public void setManage_code(String manage_code) {
            this.manage_code = manage_code;
        }

        public String getRestaurant_name() {
            return restaurant_name;
        }

        public void setRestaurant_name(String restaurant_name) {
            this.restaurant_name = restaurant_name;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getDiet_style() {
            return diet_style;
        }

        public void setDiet_style(int diet_style) {
            this.diet_style = diet_style;
        }

        public List<String> getService() {
            return service;
        }

        public void setService(List<String> service) {
            this.service = service;
        }

        public BusinessHoursBean getBusiness_hours() {
            return business_hours;
        }

        public void setBusiness_hours(BusinessHoursBean business_hours) {
            this.business_hours = business_hours;
        }

        public PersonInChargeBean getPerson_in_charge() {
            return person_in_charge;
        }

        public void setPerson_in_charge(PersonInChargeBean person_in_charge) {
            this.person_in_charge = person_in_charge;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getFull_address() {
            return full_address;
        }

        public void setFull_address(String full_address) {
            this.full_address = full_address;
        }

        public String getNearby_address() {
            return nearby_address;
        }

        public void setNearby_address(String nearby_address) {
            this.nearby_address = nearby_address;
        }

        public String getLatlng() {
            return latlng;
        }

        public void setLatlng(String latlng) {
            this.latlng = latlng;
        }

        public int getTotal_tables() {
            return total_tables;
        }

        public void setTotal_tables(int total_tables) {
            this.total_tables = total_tables;
        }

        public String getLogo_img_url() {
            return logo_img_url;
        }

        public void setLogo_img_url(String logo_img_url) {
            this.logo_img_url = logo_img_url;
        }

        public String getBackground_img_url() {
            return background_img_url;
        }

        public void setBackground_img_url(String background_img_url) {
            this.background_img_url = background_img_url;
        }

        public int getPoint() {
            return point;
        }

        public void setPoint(int point) {
            this.point = point;
        }

        public Object getPay() {
            return pay;
        }

        public void setPay(Object pay) {
            this.pay = pay;
        }

        public Object getDeleted_at() {
            return deleted_at;
        }

        public void setDeleted_at(Object deleted_at) {
            this.deleted_at = deleted_at;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public boolean isIs_collect() {
            return is_collect;
        }

        public void setIs_collect(boolean is_collect) {
            this.is_collect = is_collect;
        }

        public static class BusinessHoursBean {
            private String startWeek;
            private String endWeek;
            private String startTime;
            private String endTime;

            public String getStartWeek() {
                return startWeek;
            }

            public void setStartWeek(String startWeek) {
                this.startWeek = startWeek;
            }

            public String getEndWeek() {
                return endWeek;
            }

            public void setEndWeek(String endWeek) {
                this.endWeek = endWeek;
            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }
        }

        public static class PersonInChargeBean {
            private String name;
            private String phone;
            private String mail;
            private String mailVal;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getMail() {
                return mail;
            }

            public void setMail(String mail) {
                this.mail = mail;
            }

            public String getMailVal() {
                return mailVal;
            }

            public void setMailVal(String mailVal) {
                this.mailVal = mailVal;
            }
        }
    }
}
