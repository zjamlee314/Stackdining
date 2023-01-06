package com.stackdining.www.model.bean;

import java.util.List;

/**
 * Created by Evan
 * on 2022/12/28
 */
public class LoginBean {


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
        private boolean login;
        private MemberInfoBean member_info;
        private int expires_time;
        private String token;
        private List<?> vip_info;

        public boolean isLogin() {
            return login;
        }

        public void setLogin(boolean login) {
            this.login = login;
        }

        public MemberInfoBean getMember_info() {
            return member_info;
        }

        public void setMember_info(MemberInfoBean member_info) {
            this.member_info = member_info;
        }

        public int getExpires_time() {
            return expires_time;
        }

        public void setExpires_time(int expires_time) {
            this.expires_time = expires_time;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public List<?> getVip_info() {
            return vip_info;
        }

        public void setVip_info(List<?> vip_info) {
            this.vip_info = vip_info;
        }

        public static class MemberInfoBean {
            private int id;
            private String uuid;
            private String name;
            private String password;
            private String nickname;
            private String avatar;
            private int gender;
            private String birthday;
            private String phone;
            private int default_card;
            private int country_code;
            private int platform_point;
            private int level;
            private String customer_id;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public int getDefault_card() {
                return default_card;
            }

            public void setDefault_card(int default_card) {
                this.default_card = default_card;
            }

            public int getCountry_code() {
                return country_code;
            }

            public void setCountry_code(int country_code) {
                this.country_code = country_code;
            }

            public int getPlatform_point() {
                return platform_point;
            }

            public void setPlatform_point(int platform_point) {
                this.platform_point = platform_point;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public String getCustomer_id() {
                return customer_id;
            }

            public void setCustomer_id(String customer_id) {
                this.customer_id = customer_id;
            }
        }
    }
}
