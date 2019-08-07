package com.huohougongfu.app.Gson;

public class RenZhengZhuangTai {

    private String msg;
    private ResultBean result;
    private int status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class ResultBean {
        /**
         * person : {"code":2,"info":{"realName":"汪","level":"发多少","idCard":"421333********3333"}}
         * specialBrand : {"code":3,"info":{"realName":"汪","bankCard":"111111********1111","idCard":"421333********3333","storeName":"店铺名称1"}}
         * store : {"code":2,"info":{"realName":"汪","bankCard":"111111********1111","idCard":"421333********3333","storeName":"店铺名称1"}}
         * master : {"info":{"realName":"汪","specialty":"发多少","level":"发多少","idCard":"421333********3333","photo":"http://oss.irving.net.cn/tea/1564739194592.jpg"},"code":1}
         */

        private PersonBean person;
        private SpecialBrandBean specialBrand;
        private StoreBean store;
        private MasterBean master;

        public PersonBean getPerson() {
            return person;
        }

        public void setPerson(PersonBean person) {
            this.person = person;
        }

        public SpecialBrandBean getSpecialBrand() {
            return specialBrand;
        }

        public void setSpecialBrand(SpecialBrandBean specialBrand) {
            this.specialBrand = specialBrand;
        }

        public StoreBean getStore() {
            return store;
        }

        public void setStore(StoreBean store) {
            this.store = store;
        }

        public MasterBean getMaster() {
            return master;
        }

        public void setMaster(MasterBean master) {
            this.master = master;
        }

        public static class PersonBean {
            /**
             * code : 2
             * info : {"realName":"汪","level":"发多少","idCard":"421333********3333"}
             */

            private int code;
            private InfoBean info;

            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }

            public InfoBean getInfo() {
                return info;
            }

            public void setInfo(InfoBean info) {
                this.info = info;
            }

            public static class InfoBean {
                /**
                 * realName : 汪
                 * level : 发多少
                 * idCard : 421333********3333
                 */

                private String realName;
                private String level;
                private String idCard;

                public String getRealName() {
                    return realName;
                }

                public void setRealName(String realName) {
                    this.realName = realName;
                }

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public String getIdCard() {
                    return idCard;
                }

                public void setIdCard(String idCard) {
                    this.idCard = idCard;
                }
            }
        }

        public static class SpecialBrandBean {
            /**
             * code : 3
             * info : {"realName":"汪","bankCard":"111111********1111","idCard":"421333********3333","storeName":"店铺名称1"}
             */

            private int code;
            private InfoBeanX info;

            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }

            public InfoBeanX getInfo() {
                return info;
            }

            public void setInfo(InfoBeanX info) {
                this.info = info;
            }

            public static class InfoBeanX {
                /**
                 * realName : 汪
                 * bankCard : 111111********1111
                 * idCard : 421333********3333
                 * storeName : 店铺名称1
                 */

                private String realName;
                private String bankCard;
                private String idCard;
                private String storeName;

                public String getRealName() {
                    return realName;
                }

                public void setRealName(String realName) {
                    this.realName = realName;
                }

                public String getBankCard() {
                    return bankCard;
                }

                public void setBankCard(String bankCard) {
                    this.bankCard = bankCard;
                }

                public String getIdCard() {
                    return idCard;
                }

                public void setIdCard(String idCard) {
                    this.idCard = idCard;
                }

                public String getStoreName() {
                    return storeName;
                }

                public void setStoreName(String storeName) {
                    this.storeName = storeName;
                }
            }
        }

        public static class StoreBean {
            /**
             * code : 2
             * info : {"realName":"汪","bankCard":"111111********1111","idCard":"421333********3333","storeName":"店铺名称1"}
             */

            private int code;
            private InfoBeanXX info;

            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }

            public InfoBeanXX getInfo() {
                return info;
            }

            public void setInfo(InfoBeanXX info) {
                this.info = info;
            }

            public static class InfoBeanXX {
                /**
                 * realName : 汪
                 * bankCard : 111111********1111
                 * idCard : 421333********3333
                 * storeName : 店铺名称1
                 */

                private String realName;
                private String bankCard;
                private String idCard;
                private String storeName;

                public String getRealName() {
                    return realName;
                }

                public void setRealName(String realName) {
                    this.realName = realName;
                }

                public String getBankCard() {
                    return bankCard;
                }

                public void setBankCard(String bankCard) {
                    this.bankCard = bankCard;
                }

                public String getIdCard() {
                    return idCard;
                }

                public void setIdCard(String idCard) {
                    this.idCard = idCard;
                }

                public String getStoreName() {
                    return storeName;
                }

                public void setStoreName(String storeName) {
                    this.storeName = storeName;
                }
            }
        }

        public static class MasterBean {
            /**
             * info : {"realName":"汪","specialty":"发多少","level":"发多少","idCard":"421333********3333","photo":"http://oss.irving.net.cn/tea/1564739194592.jpg"}
             * code : 1
             */

            private InfoBeanXXX info;
            private int code;

            public InfoBeanXXX getInfo() {
                return info;
            }

            public void setInfo(InfoBeanXXX info) {
                this.info = info;
            }

            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }

            public static class InfoBeanXXX {
                /**
                 * realName : 汪
                 * specialty : 发多少
                 * level : 发多少
                 * idCard : 421333********3333
                 * photo : http://oss.irving.net.cn/tea/1564739194592.jpg
                 */

                private String realName;
                private String specialty;
                private String level;
                private String idCard;
                private String photo;

                public String getRealName() {
                    return realName;
                }

                public void setRealName(String realName) {
                    this.realName = realName;
                }

                public String getSpecialty() {
                    return specialty;
                }

                public void setSpecialty(String specialty) {
                    this.specialty = specialty;
                }

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public String getIdCard() {
                    return idCard;
                }

                public void setIdCard(String idCard) {
                    this.idCard = idCard;
                }

                public String getPhoto() {
                    return photo;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }
            }
        }
    }
}
