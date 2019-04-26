package com.jack.appnews.bean;

import java.io.Serializable;
import java.util.List;

/**
 * GsonFormat gen
 */
public class NewsListBean {

    /**
     * status : 1
     * message : 成功
     * data : {"count":6,"list":[{"news_id":1001,"news_title":"手机充电速度到底取决于充电头还是数据线？以前一直搞错了","content_type":1,"web_url":"https://m.toutiao.com/i6681254554287211015/?W2atIF=1","img_list":["https://p3.pstatp.com/list/190x124/pgc-image/ROHTP7jD0TBlNZ"],"created":1555878709,"source_name":"凤凰新闻"},{"news_id":1002,"news_title":"孙俪《影》之后接新戏，携手《蜗居》编剧六六\u201c卖房\u201d","content_type":1,"web_url":"https://m.toutiao.com/i6681446417610834445/?W2atIF=1","img_list":["https://p3.pstatp.com/list/pgc-image/RO3VqYI8ThviTx","https://p3.pstatp.com/list/pgc-image/RO3VqYp8vyTBxh","https://p3.pstatp.com/list/pgc-image/RO3VqZCHxrRyMs"],"created":1555878707,"source_name":"新浪新闻"},{"news_id":1003,"news_title":"铅笔芯是怎么被塞进木头里的？用了这么多年后总算明白了","content_type":2,"web_url":"https://m.toutiao.com/i6677011253224817160/?W2atIF=1","img_list":["https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3510597035,410014574&fm=173&app=49&f=JPEG?w=218&h=146&s=C7A49C44C7802D4372A975840300C084"],"created":1555878767,"source_name":"光明网"},{"news_id":1001,"news_title":"手机充电速度到底取决于充电头还是数据线？以前一直搞错了","content_type":1,"web_url":"https://m.toutiao.com/i6681254554287211015/?W2atIF=1","img_list":["https://p3.pstatp.com/list/190x124/pgc-image/ROHTP7jD0TBlNZ"],"created":1555878756,"source_name":"财经战略"},{"news_id":1002,"news_title":"孙俪《影》之后接新戏，携手《蜗居》编剧六六\u201c卖房\u201d","content_type":1,"web_url":"https://m.toutiao.com/i6681446417610834445/?W2atIF=1","img_list":["https://p3.pstatp.com/list/pgc-image/RO3VqYI8ThviTx","https://p3.pstatp.com/list/pgc-image/RO3VqYp8vyTBxh","https://p3.pstatp.com/list/pgc-image/RO3VqZCHxrRyMs"],"created":1555878712,"source_name":"一起来养生"},{"news_id":1003,"news_title":"铅笔芯是怎么被塞进木头里的？用了这么多年后总算明白了","content_type":2,"web_url":"https://m.toutiao.com/i6677011253224817160/?W2atIF=1","img_list":["https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3510597035,410014574&fm=173&app=49&f=JPEG?w=218&h=146&s=C7A49C44C7802D4372A975840300C084"],"created":1555878765,"source_name":"凤凰新闻"}]}
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
         * count : 6
         * list : [{"news_id":1001,"news_title":"手机充电速度到底取决于充电头还是数据线？以前一直搞错了","content_type":1,"web_url":"https://m.toutiao.com/i6681254554287211015/?W2atIF=1","img_list":["https://p3.pstatp.com/list/190x124/pgc-image/ROHTP7jD0TBlNZ"],"created":1555878709,"source_name":"凤凰新闻"},{"news_id":1002,"news_title":"孙俪《影》之后接新戏，携手《蜗居》编剧六六\u201c卖房\u201d","content_type":1,"web_url":"https://m.toutiao.com/i6681446417610834445/?W2atIF=1","img_list":["https://p3.pstatp.com/list/pgc-image/RO3VqYI8ThviTx","https://p3.pstatp.com/list/pgc-image/RO3VqYp8vyTBxh","https://p3.pstatp.com/list/pgc-image/RO3VqZCHxrRyMs"],"created":1555878707,"source_name":"新浪新闻"},{"news_id":1003,"news_title":"铅笔芯是怎么被塞进木头里的？用了这么多年后总算明白了","content_type":2,"web_url":"https://m.toutiao.com/i6677011253224817160/?W2atIF=1","img_list":["https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3510597035,410014574&fm=173&app=49&f=JPEG?w=218&h=146&s=C7A49C44C7802D4372A975840300C084"],"created":1555878767,"source_name":"光明网"},{"news_id":1001,"news_title":"手机充电速度到底取决于充电头还是数据线？以前一直搞错了","content_type":1,"web_url":"https://m.toutiao.com/i6681254554287211015/?W2atIF=1","img_list":["https://p3.pstatp.com/list/190x124/pgc-image/ROHTP7jD0TBlNZ"],"created":1555878756,"source_name":"财经战略"},{"news_id":1002,"news_title":"孙俪《影》之后接新戏，携手《蜗居》编剧六六\u201c卖房\u201d","content_type":1,"web_url":"https://m.toutiao.com/i6681446417610834445/?W2atIF=1","img_list":["https://p3.pstatp.com/list/pgc-image/RO3VqYI8ThviTx","https://p3.pstatp.com/list/pgc-image/RO3VqYp8vyTBxh","https://p3.pstatp.com/list/pgc-image/RO3VqZCHxrRyMs"],"created":1555878712,"source_name":"一起来养生"},{"news_id":1003,"news_title":"铅笔芯是怎么被塞进木头里的？用了这么多年后总算明白了","content_type":2,"web_url":"https://m.toutiao.com/i6677011253224817160/?W2atIF=1","img_list":["https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3510597035,410014574&fm=173&app=49&f=JPEG?w=218&h=146&s=C7A49C44C7802D4372A975840300C084"],"created":1555878765,"source_name":"凤凰新闻"}]
         */

        private int count;
        private List<ListBean> list;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Serializable {
            /**
             * news_id : 1001
             * news_title : 手机充电速度到底取决于充电头还是数据线？以前一直搞错了
             * content_type : 1
             * web_url : https://m.toutiao.com/i6681254554287211015/?W2atIF=1
             * img_list : ["https://p3.pstatp.com/list/190x124/pgc-image/ROHTP7jD0TBlNZ"]
             * created : 1555878709
             * source_name : 凤凰新闻
             */

            private int news_id;
            private String news_title;
            private int content_type;
            private String web_url;
            private int created;
            private String source_name;
            private List<String> img_list;

            public ListBean(String news_title, String source_name, int content_type) {
                this.news_title = news_title;
                this.content_type = content_type;
                this.source_name = source_name;
            }

            public ListBean(String news_title, String source_name, int content_type, String web_url, List<String> img_list) {
                this.news_title = news_title;
                this.content_type = content_type;
                this.web_url = web_url;
                this.source_name = source_name;
                this.img_list = img_list;
            }

            public ListBean(String news_title, String source_name, List<String> img_list, int content_type) {
                this.news_title = news_title;
                this.content_type = content_type;
                this.source_name = source_name;
                this.img_list = img_list;
            }

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

            public List<String> getImg_list() {
                return img_list;
            }

            public void setImg_list(List<String> img_list) {
                this.img_list = img_list;
            }
        }
    }
}