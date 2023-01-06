package com.stackdining.www.model.bean;

import java.util.List;

/**
 * Created by Evan
 * on 2022/12/27
 */
public class HomeListBean {

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
        private int id;
        private String restaurant_code;
        private String name;
        private String logo_img_url;
        private String background_img_url;
        private int reviews;
        private String score;
        private String distance;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public int getReviews() {
            return reviews;
        }

        public void setReviews(int reviews) {
            this.reviews = reviews;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }
    }
}
