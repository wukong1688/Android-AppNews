package com.jack.appnews.bean;

import java.util.List;


/**
 * GsonFormat gen
 */
public class NewsCateBean {


    /**
     * status : 1
     * message : 成功
     * data : {"count":7,"list":[{"cate_id":1001,"cate_name":"推荐"},{"cate_id":1002,"cate_name":"热门"},{"cate_id":1003,"cate_name":"国内"},{"cate_id":1004,"cate_name":"互联网"},{"cate_id":1005,"cate_name":"娱乐"},{"cate_id":1006,"cate_name":"健康"},{"cate_id":1007,"cate_name":"美文"}]}
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
         * count : 7
         * list : [{"cate_id":1001,"cate_name":"推荐"},{"cate_id":1002,"cate_name":"热门"},{"cate_id":1003,"cate_name":"国内"},{"cate_id":1004,"cate_name":"互联网"},{"cate_id":1005,"cate_name":"娱乐"},{"cate_id":1006,"cate_name":"健康"},{"cate_id":1007,"cate_name":"美文"}]
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

        public static class ListBean {
            /**
             * cate_id : 1001
             * cate_name : 推荐
             */

            private int cate_id;
            private String cate_name;

            public int getCate_id() {
                return cate_id;
            }

            public void setCate_id(int cate_id) {
                this.cate_id = cate_id;
            }

            public String getCate_name() {
                return cate_name;
            }

            public void setCate_name(String cate_name) {
                this.cate_name = cate_name;
            }
        }
    }
}