package com.jack.appnews.bean;

/**
 * GsonFormat gen
 */
public class NewsDetailBean {

    /**
     * status : 1
     * message : 成功
     * data : {"news_id":1001,"news_title":"手机充电速度到底取决于充电头还是数据线？以前一直搞错了","content_type":1,"web_url":"https://m.toutiao.com/i6681254554287211015/?W2atIF=1","content":"搞清楚这个问题，当充电头或者数据线需要更换时，就不会因选错导致手机充电速度比原装的慢了。","created":1555878695,"source_name":"凤凰新闻"}
     */

    private int status;
    private String message;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * news_id : 1001
         * news_title : 手机充电速度到底取决于充电头还是数据线？以前一直搞错了
         * content_type : 1
         * web_url : https://m.toutiao.com/i6681254554287211015/?W2atIF=1
         * content : 搞清楚这个问题，当充电头或者数据线需要更换时，就不会因选错导致手机充电速度比原装的慢了。
         * created : 1555878695
         * source_name : 凤凰新闻
         */

        private int news_id;
        private String news_title;
        private int content_type;
        private String web_url;
        private String content;
        private int created;
        private String source_name;

        public int getNews_id() {
            return news_id;
        }

        public void setNews_id(int news_id) {
            this.news_id = news_id;
        }

        public String getNews_title() {
            return news_title;
        }

        public void setNews_title(String news_title) {
            this.news_title = news_title;
        }

        public int getContent_type() {
            return content_type;
        }

        public void setContent_type(int content_type) {
            this.content_type = content_type;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getCreated() {
            return created;
        }

        public void setCreated(int created) {
            this.created = created;
        }

        public String getSource_name() {
            return source_name;
        }

        public void setSource_name(String source_name) {
            this.source_name = source_name;
        }
    }
}