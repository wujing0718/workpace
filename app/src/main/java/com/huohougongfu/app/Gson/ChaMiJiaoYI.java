package com.huohougongfu.app.Gson;

import java.util.List;

public class ChaMiJiaoYI {

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
        private int in;
        private RecordBean record;
        private int out;

        public int getIn() {
            return in;
        }

        public void setIn(int in) {
            this.in = in;
        }

        public RecordBean getRecord() {
            return record;
        }

        public void setRecord(RecordBean record) {
            this.record = record;
        }

        public int getOut() {
            return out;
        }

        public void setOut(int out) {
            this.out = out;
        }

        public static class RecordBean {
            /**
             * total : 4
             * list : [{"count":-1,"sendId":3,"receiveId":null,"isReceive":false,"pillowtalk":"收下我的茶米，你就是我的人啦~","createTime":"2019-08-26 15:54:49","updateTime":"2019-08-26 15:54:49","type":"赠送茶米","nickname":"18910328","photo":"http://oss.irving.net.cn/tea/1566804446416.jpg","sendName":null,"isView":false,"tid":19},{"count":-10,"sendId":3,"receiveId":null,"isReceive":false,"pillowtalk":"收下我的茶米，你就是我的人啦~","createTime":"2019-08-26 15:44:18","updateTime":"2019-08-26 15:44:18","type":"赠送茶米","nickname":"18910328","photo":"http://oss.irving.net.cn/tea/1566804446416.jpg","sendName":null,"isView":false,"tid":17},{"count":20,"sendId":3,"receiveId":null,"isReceive":false,"pillowtalk":"","createTime":"2019-08-26 15:26:35","updateTime":"2019-08-26 15:26:35","type":"每日打卡","nickname":"18910328","photo":"http://oss.irving.net.cn/tea/1566804446416.jpg","sendName":null,"isView":false,"tid":14},{"count":300,"sendId":3,"receiveId":null,"isReceive":false,"pillowtalk":"","createTime":"2019-08-26 15:06:40","updateTime":"2019-08-26 15:06:40","type":"注册","nickname":"18910328","photo":"http://oss.irving.net.cn/tea/1566804446416.jpg","sendName":null,"isView":true,"tid":6}]
             * pageNum : 1
             * pageSize : 10
             * size : 4
             * startRow : 1
             * endRow : 4
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
                 * count : -1
                 * sendId : 3
                 * receiveId : null
                 * isReceive : false
                 * pillowtalk : 收下我的茶米，你就是我的人啦~
                 * createTime : 2019-08-26 15:54:49
                 * updateTime : 2019-08-26 15:54:49
                 * type : 赠送茶米
                 * nickname : 18910328
                 * photo : http://oss.irving.net.cn/tea/1566804446416.jpg
                 * sendName : null
                 * isView : false
                 * tid : 19
                 */

                private int count;
                private int sendId;
                private Object receiveId;
                private boolean isReceive;
                private String pillowtalk;
                private String createTime;
                private String updateTime;
                private String type;
                private String nickname;
                private String photo;
                private Object sendName;
                private boolean isView;
                private int tid;

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public int getSendId() {
                    return sendId;
                }

                public void setSendId(int sendId) {
                    this.sendId = sendId;
                }

                public Object getReceiveId() {
                    return receiveId;
                }

                public void setReceiveId(Object receiveId) {
                    this.receiveId = receiveId;
                }

                public boolean isIsReceive() {
                    return isReceive;
                }

                public void setIsReceive(boolean isReceive) {
                    this.isReceive = isReceive;
                }

                public String getPillowtalk() {
                    return pillowtalk;
                }

                public void setPillowtalk(String pillowtalk) {
                    this.pillowtalk = pillowtalk;
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

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public String getPhoto() {
                    return photo;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }

                public Object getSendName() {
                    return sendName;
                }

                public void setSendName(Object sendName) {
                    this.sendName = sendName;
                }

                public boolean isIsView() {
                    return isView;
                }

                public void setIsView(boolean isView) {
                    this.isView = isView;
                }

                public int getTid() {
                    return tid;
                }

                public void setTid(int tid) {
                    this.tid = tid;
                }
            }
        }
    }
}
