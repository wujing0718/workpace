package com.huohougongfu.app.Gson;

public class ALiPay {
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
         * priceTotal : 0.0
         * orderString : alipay_sdk=alipay-sdk-java-3.3.49.ALL&app_id=2019080966170096&biz_content=%7B%22body%22%3A%22%E8%B4%AD%E4%B9%B0%E5%95%86%E5%93%81%22%2C%22out_trade_no%22%3A%22%5BLjava.lang.String%3B%40114250fd%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E6%B5%8B%E8%AF%9521%2C+%E6%B5%8B%E8%AF%9521%2C+%E6%B5%8B%E8%AF%9521%2C+%E6%B5%8B%E8%AF%9521%2C+%E6%B5%8B%E8%AF%9521%2C+%E6%B5%8B%E8%AF%9521%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%220.00%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Fwww.hotkungfu-tea.com%3A8081%2Fpay%2FappCallback&return_url=http%3A%2F%2Fwww.hotkungfu-tea.com%3A8081%2Fpay%2FappCallback&sign=aCKuIdllzd%2FDSiuwWHe25LzA75xhFwtpXpij9MYKGojodoVxG6lFCHLpO%2BTKX9YvzDqlGdMnvyA8OdZTNU6awIjBhOq6Atzbn%2F4meDCGfZdDNR1qOCtbAAkl3y0BoMbHGDb5xQILN6TmGwAuwK3klc6rhaJwfgHdt1HFqvjHfIm6yC8hV%2BbKdf8SQPKpI%2BCWBv4OgCoq341x8Ln0%2FCr09u%2B2qwSoc4lJurKh4W5SJuxET6trpYRDHca6Kuc%2BjsysM97znBmfD8nJ3QTDIUVpVsmptbH2eq5h%2B67egojbmNMNvOnyk5atmKnnO%2B5P72Mot2twNiIZ3eWRwpotscNcng%3D%3D&sign_type=RSA2&timestamp=2019-08-21+16%3A10%3A05&version=1.0
         */

        private double priceTotal;
        private String orderString;

        public double getPriceTotal() {
            return priceTotal;
        }

        public void setPriceTotal(double priceTotal) {
            this.priceTotal = priceTotal;
        }

        public String getOrderString() {
            return orderString;
        }

        public void setOrderString(String orderString) {
            this.orderString = orderString;
        }
    }
}
