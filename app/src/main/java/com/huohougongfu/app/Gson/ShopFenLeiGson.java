package com.huohougongfu.app.Gson;

import java.util.List;

public class ShopFenLeiGson {
    /**
     * msg : 操作成功
     * result : [{"name":"茶叶","list":[{"name":"白茶","id":4,"pic":"ico","list":[{"id":22,"parentId":4,"name":"茉莉茶","catDir":3,"showOrder":20,"createBy":1,"createTime":"2019-07-11T11:10:46.000+0000","updateBy":null,"updateTime":"2019-07-26T02:58:54.000+0000","ico":"ico","keyWord":null,"productCount":null},{"id":23,"parentId":4,"name":"普洱","catDir":3,"showOrder":22,"createBy":1,"createTime":"2019-07-11T11:11:47.000+0000","updateBy":null,"updateTime":"2019-07-26T02:58:55.000+0000","ico":"ico","keyWord":null,"productCount":null},{"id":24,"parentId":4,"name":"碧螺春","catDir":3,"showOrder":23,"createBy":1,"createTime":"2019-07-11T11:12:39.000+0000","updateBy":null,"updateTime":"2019-07-26T02:58:56.000+0000","ico":"ico","keyWord":null,"productCount":null}],"parentId":1},{"name":"红茶","id":9,"pic":"ico","list":[{"id":29,"parentId":9,"name":"红茶茶","catDir":3,"showOrder":22,"createBy":null,"createTime":"2019-07-11T09:32:49.000+0000","updateBy":null,"updateTime":"2019-07-26T02:59:02.000+0000","ico":"ico","keyWord":null,"productCount":null}],"parentId":1},{"name":"绿茶","id":12,"pic":"ico","list":[],"parentId":1},{"name":"铁观音","id":20,"pic":"ico","list":[],"parentId":1},{"name":"龙井","id":21,"pic":"ico","list":[],"parentId":1}]},{"name":"茶器","list":[{"name":"材质","id":26,"pic":"ico","list":[{"id":27,"parentId":26,"name":"陶瓷","catDir":3,"showOrder":55,"createBy":null,"createTime":"2019-07-19T01:20:01.000+0000","updateBy":null,"updateTime":"2019-07-26T02:58:58.000+0000","ico":"ico","keyWord":null,"productCount":null},{"id":28,"parentId":26,"name":"紫砂","catDir":3,"showOrder":66,"createBy":null,"createTime":"2019-07-16T01:20:40.000+0000","updateBy":null,"updateTime":"2019-07-26T02:58:59.000+0000","ico":"ico","keyWord":null,"productCount":null}],"parentId":25}]}]
     * status : 1
     */

    private String msg;
    private int status;
    private List<ResultBean> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * name : 茶叶
         * list : [{"name":"白茶","id":4,"pic":"ico","list":[{"id":22,"parentId":4,"name":"茉莉茶","catDir":3,"showOrder":20,"createBy":1,"createTime":"2019-07-11T11:10:46.000+0000","updateBy":null,"updateTime":"2019-07-26T02:58:54.000+0000","ico":"ico","keyWord":null,"productCount":null},{"id":23,"parentId":4,"name":"普洱","catDir":3,"showOrder":22,"createBy":1,"createTime":"2019-07-11T11:11:47.000+0000","updateBy":null,"updateTime":"2019-07-26T02:58:55.000+0000","ico":"ico","keyWord":null,"productCount":null},{"id":24,"parentId":4,"name":"碧螺春","catDir":3,"showOrder":23,"createBy":1,"createTime":"2019-07-11T11:12:39.000+0000","updateBy":null,"updateTime":"2019-07-26T02:58:56.000+0000","ico":"ico","keyWord":null,"productCount":null}],"parentId":1},{"name":"红茶","id":9,"pic":"ico","list":[{"id":29,"parentId":9,"name":"红茶茶","catDir":3,"showOrder":22,"createBy":null,"createTime":"2019-07-11T09:32:49.000+0000","updateBy":null,"updateTime":"2019-07-26T02:59:02.000+0000","ico":"ico","keyWord":null,"productCount":null}],"parentId":1},{"name":"绿茶","id":12,"pic":"ico","list":[],"parentId":1},{"name":"铁观音","id":20,"pic":"ico","list":[],"parentId":1},{"name":"龙井","id":21,"pic":"ico","list":[],"parentId":1}]
         */

        private String name;
        private List<ListBeanX> list;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<ListBeanX> getList() {
            return list;
        }

        public void setList(List<ListBeanX> list) {
            this.list = list;
        }

        public static class ListBeanX {
            /**
             * name : 白茶
             * id : 4
             * pic : ico
             * list : [{"id":22,"parentId":4,"name":"茉莉茶","catDir":3,"showOrder":20,"createBy":1,"createTime":"2019-07-11T11:10:46.000+0000","updateBy":null,"updateTime":"2019-07-26T02:58:54.000+0000","ico":"ico","keyWord":null,"productCount":null},{"id":23,"parentId":4,"name":"普洱","catDir":3,"showOrder":22,"createBy":1,"createTime":"2019-07-11T11:11:47.000+0000","updateBy":null,"updateTime":"2019-07-26T02:58:55.000+0000","ico":"ico","keyWord":null,"productCount":null},{"id":24,"parentId":4,"name":"碧螺春","catDir":3,"showOrder":23,"createBy":1,"createTime":"2019-07-11T11:12:39.000+0000","updateBy":null,"updateTime":"2019-07-26T02:58:56.000+0000","ico":"ico","keyWord":null,"productCount":null}]
             * parentId : 1
             */

            private String name;
            private int id;
            private String pic;
            private int parentId;
            private List<ListBean> list;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * id : 22
                 * parentId : 4
                 * name : 茉莉茶
                 * catDir : 3
                 * showOrder : 20
                 * createBy : 1
                 * createTime : 2019-07-11T11:10:46.000+0000
                 * updateBy : null
                 * updateTime : 2019-07-26T02:58:54.000+0000
                 * ico : ico
                 * keyWord : null
                 * productCount : null
                 */

                private int id;
                private int parentId;
                private String name;
                private int catDir;
                private int showOrder;
                private int createBy;
                private String createTime;
                private Object updateBy;
                private String updateTime;
                private String ico;
                private Object keyWord;
                private Object productCount;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getParentId() {
                    return parentId;
                }

                public void setParentId(int parentId) {
                    this.parentId = parentId;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getCatDir() {
                    return catDir;
                }

                public void setCatDir(int catDir) {
                    this.catDir = catDir;
                }

                public int getShowOrder() {
                    return showOrder;
                }

                public void setShowOrder(int showOrder) {
                    this.showOrder = showOrder;
                }

                public int getCreateBy() {
                    return createBy;
                }

                public void setCreateBy(int createBy) {
                    this.createBy = createBy;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public Object getUpdateBy() {
                    return updateBy;
                }

                public void setUpdateBy(Object updateBy) {
                    this.updateBy = updateBy;
                }

                public String getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateTime(String updateTime) {
                    this.updateTime = updateTime;
                }

                public String getIco() {
                    return ico;
                }

                public void setIco(String ico) {
                    this.ico = ico;
                }

                public Object getKeyWord() {
                    return keyWord;
                }

                public void setKeyWord(Object keyWord) {
                    this.keyWord = keyWord;
                }

                public Object getProductCount() {
                    return productCount;
                }

                public void setProductCount(Object productCount) {
                    this.productCount = productCount;
                }
            }
        }
    }
}
