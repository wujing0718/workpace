package com.huohougongfu.app.Gson;

import java.util.List;

public class DSZhuanChang {

    /**
     * msg : 操作成功
     * result : {"allMaster":{"total":3,"list":[{"id":1,"mId":2,"name":"吴怡霏","portrait":"http://oss.irving.net.cn/tea/1566550352455.jpg","photo":"http://oss.irving.net.cn/tea/1566551744971.jpg","level":"评茶师","specialty":"白茶","status":2,"introduceContent":"","createTime":"2019-08-23T08:47:20.000+0000","updateTime":"2019-08-23T10:23:16.000+0000","masterAddress":"北京市","storeId":36,"isMerchant":true,"nickName":"17355651212","count":0,"isCollection":0,"merchant":true},{"id":3,"mId":1,"name":"汪应龙","portrait":"http://oss.irving.net.cn/tea/1566555619459.jpg","photo":"https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIjv8IiccVtfzLcLTDRcMWwZSuQpjhUfxTZQhK0icQZib5z4zHvbbuISVojeQgW5LWib8mWOROXlAzJeQ/132","level":"评茶师","specialty":"白茶,绿茶,黄茶","status":2,"introduceContent":"万千范德萨范德萨范德萨发","createTime":"2019-08-23T10:17:53.000+0000","updateTime":"2019-08-23T10:20:20.000+0000","masterAddress":"北京市","storeId":null,"isMerchant":false,"nickName":"Drew","count":0,"isCollection":0,"merchant":false},{"id":4,"mId":5,"name":"杨秋梅","portrait":"http://oss.irving.net.cn/tea/1566557735444.jpg","photo":"http://thirdqq.qlogo.cn/g?b=oidb&k=HwgMiaJFexfIoE63JgH3VfQ&s=100&t=1562996187","level":"评茶师","specialty":"绿茶,红茶","status":2,"introduceContent":"杨秋梅大师","createTime":"2019-08-23T10:38:59.000+0000","updateTime":"2019-08-23T10:56:06.000+0000","masterAddress":"","storeId":38,"isMerchant":true,"nickName":"Eyen","count":0,"isCollection":0,"merchant":true}],"pageNum":1,"pageSize":10,"size":3,"startRow":1,"endRow":3,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1},"yourLike":[{"id":1,"mId":2,"name":"吴怡霏","portrait":"http://oss.irving.net.cn/tea/1566550352455.jpg","photo":"http://oss.irving.net.cn/tea/1566551744971.jpg","level":"评茶师","specialty":"白茶","status":2,"introduceContent":"","createTime":"2019-08-23T08:47:20.000+0000","updateTime":"2019-08-23T10:23:16.000+0000","masterAddress":"北京市","storeId":36,"isMerchant":true,"nickName":null,"count":0,"isCollection":0,"merchant":true},{"id":3,"mId":1,"name":"汪应龙","portrait":"http://oss.irving.net.cn/tea/1566555619459.jpg","photo":"https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIjv8IiccVtfzLcLTDRcMWwZSuQpjhUfxTZQhK0icQZib5z4zHvbbuISVojeQgW5LWib8mWOROXlAzJeQ/132","level":"评茶师","specialty":"白茶,绿茶,黄茶","status":2,"introduceContent":"万千范德萨范德萨范德萨发","createTime":"2019-08-23T10:17:53.000+0000","updateTime":"2019-08-23T10:20:20.000+0000","masterAddress":"北京市","storeId":null,"isMerchant":false,"nickName":null,"count":0,"isCollection":0,"merchant":false},{"id":4,"mId":5,"name":"杨秋梅","portrait":"http://oss.irving.net.cn/tea/1566557735444.jpg","photo":"http://thirdqq.qlogo.cn/g?b=oidb&k=HwgMiaJFexfIoE63JgH3VfQ&s=100&t=1562996187","level":"评茶师","specialty":"绿茶,红茶","status":2,"introduceContent":"杨秋梅大师","createTime":"2019-08-23T10:38:59.000+0000","updateTime":"2019-08-23T10:56:06.000+0000","masterAddress":"","storeId":38,"isMerchant":true,"nickName":null,"count":0,"isCollection":0,"merchant":true}]}
     * status : 1
     */

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
         * allMaster : {"total":3,"list":[{"id":1,"mId":2,"name":"吴怡霏","portrait":"http://oss.irving.net.cn/tea/1566550352455.jpg","photo":"http://oss.irving.net.cn/tea/1566551744971.jpg","level":"评茶师","specialty":"白茶","status":2,"introduceContent":"","createTime":"2019-08-23T08:47:20.000+0000","updateTime":"2019-08-23T10:23:16.000+0000","masterAddress":"北京市","storeId":36,"isMerchant":true,"nickName":"17355651212","count":0,"isCollection":0,"merchant":true},{"id":3,"mId":1,"name":"汪应龙","portrait":"http://oss.irving.net.cn/tea/1566555619459.jpg","photo":"https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIjv8IiccVtfzLcLTDRcMWwZSuQpjhUfxTZQhK0icQZib5z4zHvbbuISVojeQgW5LWib8mWOROXlAzJeQ/132","level":"评茶师","specialty":"白茶,绿茶,黄茶","status":2,"introduceContent":"万千范德萨范德萨范德萨发","createTime":"2019-08-23T10:17:53.000+0000","updateTime":"2019-08-23T10:20:20.000+0000","masterAddress":"北京市","storeId":null,"isMerchant":false,"nickName":"Drew","count":0,"isCollection":0,"merchant":false},{"id":4,"mId":5,"name":"杨秋梅","portrait":"http://oss.irving.net.cn/tea/1566557735444.jpg","photo":"http://thirdqq.qlogo.cn/g?b=oidb&k=HwgMiaJFexfIoE63JgH3VfQ&s=100&t=1562996187","level":"评茶师","specialty":"绿茶,红茶","status":2,"introduceContent":"杨秋梅大师","createTime":"2019-08-23T10:38:59.000+0000","updateTime":"2019-08-23T10:56:06.000+0000","masterAddress":"","storeId":38,"isMerchant":true,"nickName":"Eyen","count":0,"isCollection":0,"merchant":true}],"pageNum":1,"pageSize":10,"size":3,"startRow":1,"endRow":3,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1}
         * yourLike : [{"id":1,"mId":2,"name":"吴怡霏","portrait":"http://oss.irving.net.cn/tea/1566550352455.jpg","photo":"http://oss.irving.net.cn/tea/1566551744971.jpg","level":"评茶师","specialty":"白茶","status":2,"introduceContent":"","createTime":"2019-08-23T08:47:20.000+0000","updateTime":"2019-08-23T10:23:16.000+0000","masterAddress":"北京市","storeId":36,"isMerchant":true,"nickName":null,"count":0,"isCollection":0,"merchant":true},{"id":3,"mId":1,"name":"汪应龙","portrait":"http://oss.irving.net.cn/tea/1566555619459.jpg","photo":"https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIjv8IiccVtfzLcLTDRcMWwZSuQpjhUfxTZQhK0icQZib5z4zHvbbuISVojeQgW5LWib8mWOROXlAzJeQ/132","level":"评茶师","specialty":"白茶,绿茶,黄茶","status":2,"introduceContent":"万千范德萨范德萨范德萨发","createTime":"2019-08-23T10:17:53.000+0000","updateTime":"2019-08-23T10:20:20.000+0000","masterAddress":"北京市","storeId":null,"isMerchant":false,"nickName":null,"count":0,"isCollection":0,"merchant":false},{"id":4,"mId":5,"name":"杨秋梅","portrait":"http://oss.irving.net.cn/tea/1566557735444.jpg","photo":"http://thirdqq.qlogo.cn/g?b=oidb&k=HwgMiaJFexfIoE63JgH3VfQ&s=100&t=1562996187","level":"评茶师","specialty":"绿茶,红茶","status":2,"introduceContent":"杨秋梅大师","createTime":"2019-08-23T10:38:59.000+0000","updateTime":"2019-08-23T10:56:06.000+0000","masterAddress":"","storeId":38,"isMerchant":true,"nickName":null,"count":0,"isCollection":0,"merchant":true}]
         */

        private AllMasterBean allMaster;
        private List<YourLikeBean> yourLike;

        public AllMasterBean getAllMaster() {
            return allMaster;
        }

        public void setAllMaster(AllMasterBean allMaster) {
            this.allMaster = allMaster;
        }

        public List<YourLikeBean> getYourLike() {
            return yourLike;
        }

        public void setYourLike(List<YourLikeBean> yourLike) {
            this.yourLike = yourLike;
        }

        public static class AllMasterBean {
            /**
             * total : 3
             * list : [{"id":1,"mId":2,"name":"吴怡霏","portrait":"http://oss.irving.net.cn/tea/1566550352455.jpg","photo":"http://oss.irving.net.cn/tea/1566551744971.jpg","level":"评茶师","specialty":"白茶","status":2,"introduceContent":"","createTime":"2019-08-23T08:47:20.000+0000","updateTime":"2019-08-23T10:23:16.000+0000","masterAddress":"北京市","storeId":36,"isMerchant":true,"nickName":"17355651212","count":0,"isCollection":0,"merchant":true},{"id":3,"mId":1,"name":"汪应龙","portrait":"http://oss.irving.net.cn/tea/1566555619459.jpg","photo":"https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIjv8IiccVtfzLcLTDRcMWwZSuQpjhUfxTZQhK0icQZib5z4zHvbbuISVojeQgW5LWib8mWOROXlAzJeQ/132","level":"评茶师","specialty":"白茶,绿茶,黄茶","status":2,"introduceContent":"万千范德萨范德萨范德萨发","createTime":"2019-08-23T10:17:53.000+0000","updateTime":"2019-08-23T10:20:20.000+0000","masterAddress":"北京市","storeId":null,"isMerchant":false,"nickName":"Drew","count":0,"isCollection":0,"merchant":false},{"id":4,"mId":5,"name":"杨秋梅","portrait":"http://oss.irving.net.cn/tea/1566557735444.jpg","photo":"http://thirdqq.qlogo.cn/g?b=oidb&k=HwgMiaJFexfIoE63JgH3VfQ&s=100&t=1562996187","level":"评茶师","specialty":"绿茶,红茶","status":2,"introduceContent":"杨秋梅大师","createTime":"2019-08-23T10:38:59.000+0000","updateTime":"2019-08-23T10:56:06.000+0000","masterAddress":"","storeId":38,"isMerchant":true,"nickName":"Eyen","count":0,"isCollection":0,"merchant":true}]
             * pageNum : 1
             * pageSize : 10
             * size : 3
             * startRow : 1
             * endRow : 3
             * pages : 1
             * prePage : 0
             * nextPage : 0
             * isFirstPage : true
             * isLastPage : true
             * hasPreviousPage : false
             * hasNextPage : false
             * navigatePages : 8
             * navigatepageNums : [1]
             * navigateFirstPage : 1
             * navigateLastPage : 1
             */

            private int total;
            private int pageNum;
            private int pageSize;
            private int size;
            private int startRow;
            private int endRow;
            private int pages;
            private int prePage;
            private int nextPage;
            private boolean isFirstPage;
            private boolean isLastPage;
            private boolean hasPreviousPage;
            private boolean hasNextPage;
            private int navigatePages;
            private int navigateFirstPage;
            private int navigateLastPage;
            private List<ListBean> list;
            private List<Integer> navigatepageNums;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getPageNum() {
                return pageNum;
            }

            public void setPageNum(int pageNum) {
                this.pageNum = pageNum;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getStartRow() {
                return startRow;
            }

            public void setStartRow(int startRow) {
                this.startRow = startRow;
            }

            public int getEndRow() {
                return endRow;
            }

            public void setEndRow(int endRow) {
                this.endRow = endRow;
            }

            public int getPages() {
                return pages;
            }

            public void setPages(int pages) {
                this.pages = pages;
            }

            public int getPrePage() {
                return prePage;
            }

            public void setPrePage(int prePage) {
                this.prePage = prePage;
            }

            public int getNextPage() {
                return nextPage;
            }

            public void setNextPage(int nextPage) {
                this.nextPage = nextPage;
            }

            public boolean isIsFirstPage() {
                return isFirstPage;
            }

            public void setIsFirstPage(boolean isFirstPage) {
                this.isFirstPage = isFirstPage;
            }

            public boolean isIsLastPage() {
                return isLastPage;
            }

            public void setIsLastPage(boolean isLastPage) {
                this.isLastPage = isLastPage;
            }

            public boolean isHasPreviousPage() {
                return hasPreviousPage;
            }

            public void setHasPreviousPage(boolean hasPreviousPage) {
                this.hasPreviousPage = hasPreviousPage;
            }

            public boolean isHasNextPage() {
                return hasNextPage;
            }

            public void setHasNextPage(boolean hasNextPage) {
                this.hasNextPage = hasNextPage;
            }

            public int getNavigatePages() {
                return navigatePages;
            }

            public void setNavigatePages(int navigatePages) {
                this.navigatePages = navigatePages;
            }

            public int getNavigateFirstPage() {
                return navigateFirstPage;
            }

            public void setNavigateFirstPage(int navigateFirstPage) {
                this.navigateFirstPage = navigateFirstPage;
            }

            public int getNavigateLastPage() {
                return navigateLastPage;
            }

            public void setNavigateLastPage(int navigateLastPage) {
                this.navigateLastPage = navigateLastPage;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public List<Integer> getNavigatepageNums() {
                return navigatepageNums;
            }

            public void setNavigatepageNums(List<Integer> navigatepageNums) {
                this.navigatepageNums = navigatepageNums;
            }

            public static class ListBean {
                /**
                 * id : 1
                 * mId : 2
                 * name : 吴怡霏
                 * portrait : http://oss.irving.net.cn/tea/1566550352455.jpg
                 * photo : http://oss.irving.net.cn/tea/1566551744971.jpg
                 * level : 评茶师
                 * specialty : 白茶
                 * status : 2
                 * introduceContent :
                 * createTime : 2019-08-23T08:47:20.000+0000
                 * updateTime : 2019-08-23T10:23:16.000+0000
                 * masterAddress : 北京市
                 * storeId : 36
                 * isMerchant : true
                 * nickName : 17355651212
                 * count : 0
                 * isCollection : 0
                 * merchant : true
                 */

                private int id;
                private int mId;
                private String name;
                private String portrait;
                private String photo;
                private String level;
                private String specialty;
                private int status;
                private String introduceContent;
                private String createTime;
                private String updateTime;
                private String masterAddress;
                private int storeId;
                private boolean isMerchant;
                private String nickName;
                private int count;
                private int isCollection;
                private boolean merchant;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getMId() {
                    return mId;
                }

                public void setMId(int mId) {
                    this.mId = mId;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPortrait() {
                    return portrait;
                }

                public void setPortrait(String portrait) {
                    this.portrait = portrait;
                }

                public String getPhoto() {
                    return photo;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public String getSpecialty() {
                    return specialty;
                }

                public void setSpecialty(String specialty) {
                    this.specialty = specialty;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getIntroduceContent() {
                    return introduceContent;
                }

                public void setIntroduceContent(String introduceContent) {
                    this.introduceContent = introduceContent;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public String getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateTime(String updateTime) {
                    this.updateTime = updateTime;
                }

                public String getMasterAddress() {
                    return masterAddress;
                }

                public void setMasterAddress(String masterAddress) {
                    this.masterAddress = masterAddress;
                }

                public int getStoreId() {
                    return storeId;
                }

                public void setStoreId(int storeId) {
                    this.storeId = storeId;
                }

                public boolean isIsMerchant() {
                    return isMerchant;
                }

                public void setIsMerchant(boolean isMerchant) {
                    this.isMerchant = isMerchant;
                }

                public String getNickName() {
                    return nickName;
                }

                public void setNickName(String nickName) {
                    this.nickName = nickName;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public int getIsCollection() {
                    return isCollection;
                }

                public void setIsCollection(int isCollection) {
                    this.isCollection = isCollection;
                }

                public boolean isMerchant() {
                    return merchant;
                }

                public void setMerchant(boolean merchant) {
                    this.merchant = merchant;
                }
            }
        }

        public static class YourLikeBean {
            /**
             * id : 1
             * mId : 2
             * name : 吴怡霏
             * portrait : http://oss.irving.net.cn/tea/1566550352455.jpg
             * photo : http://oss.irving.net.cn/tea/1566551744971.jpg
             * level : 评茶师
             * specialty : 白茶
             * status : 2
             * introduceContent :
             * createTime : 2019-08-23T08:47:20.000+0000
             * updateTime : 2019-08-23T10:23:16.000+0000
             * masterAddress : 北京市
             * storeId : 36
             * isMerchant : true
             * nickName : null
             * count : 0
             * isCollection : 0
             * merchant : true
             */

            private int id;
            private int mId;
            private String name;
            private String portrait;
            private String photo;
            private String level;
            private String specialty;
            private int status;
            private String introduceContent;
            private String createTime;
            private String updateTime;
            private String masterAddress;
            private int storeId;
            private boolean isMerchant;
            private Object nickName;
            private int count;
            private int isCollection;
            private boolean merchant;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getMId() {
                return mId;
            }

            public void setMId(int mId) {
                this.mId = mId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPortrait() {
                return portrait;
            }

            public void setPortrait(String portrait) {
                this.portrait = portrait;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getSpecialty() {
                return specialty;
            }

            public void setSpecialty(String specialty) {
                this.specialty = specialty;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getIntroduceContent() {
                return introduceContent;
            }

            public void setIntroduceContent(String introduceContent) {
                this.introduceContent = introduceContent;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getMasterAddress() {
                return masterAddress;
            }

            public void setMasterAddress(String masterAddress) {
                this.masterAddress = masterAddress;
            }

            public int getStoreId() {
                return storeId;
            }

            public void setStoreId(int storeId) {
                this.storeId = storeId;
            }

            public boolean isIsMerchant() {
                return isMerchant;
            }

            public void setIsMerchant(boolean isMerchant) {
                this.isMerchant = isMerchant;
            }

            public Object getNickName() {
                return nickName;
            }

            public void setNickName(Object nickName) {
                this.nickName = nickName;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getIsCollection() {
                return isCollection;
            }

            public void setIsCollection(int isCollection) {
                this.isCollection = isCollection;
            }

            public boolean isMerchant() {
                return merchant;
            }

            public void setMerchant(boolean merchant) {
                this.merchant = merchant;
            }
        }
    }
}
