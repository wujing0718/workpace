package com.huohougongfu.app.Gson;

import java.util.List;

public class ShopFuWuGson{


    /**
     * msg : 操作成功
     * result : {"other":null,"basicService":[{"val":"正品保证","key":"正品保证"},{"val":"七天无理由","key":"七天无理由"},{"val":"48小时发货","key":"48小时发货"}]}
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
         * other : null
         * basicService : [{"val":"正品保证","key":"正品保证"},{"val":"七天无理由","key":"七天无理由"},{"val":"48小时发货","key":"48小时发货"}]
         */

        private String other;
        private List<BasicServiceBean> basicService;

        public String getOther() {
            return other;
        }

        public void setOther(String other) {
            this.other = other;
        }

        public List<BasicServiceBean> getBasicService() {
            return basicService;
        }

        public void setBasicService(List<BasicServiceBean> basicService) {
            this.basicService = basicService;
        }

        public static class BasicServiceBean {
            /**
             * val : 正品保证
             * key : 正品保证
             */

            private String val;
            private String key;

            public String getVal() {
                return val;
            }

            public void setVal(String val) {
                this.val = val;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }
        }
    }
}
