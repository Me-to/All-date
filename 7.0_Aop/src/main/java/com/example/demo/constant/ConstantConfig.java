package com.example.demo.constant;

public interface ConstantConfig {
    interface ResponeErrorInfo {
        String SUCCESS = "操作成功";
        String ERROR_RETRY = "操作失败，请尝试重试";
        String ERROR_GREEN = "内容安全检查失败，请尝试重试";
        String ERROR_REQUEST_JSON = "JSON格式错误";
    }



    /**
     * 时间
     */
    interface Time {
        interface Second {
            /**
             * 一周
             */
            Long ONE_WEEK = 604800L;
        }

        /**
         * 毫秒
         */
        interface Millisecond {
            /**
             * 一秒
             */
            Long ONE_SECOND = 1000L;
            /**
             * 一天
             */
            Long ONE_DAY = 86400000L;
            /**
             * 一小时
             */
            Long ONE_HOUR = 3600000L;
            /**
             * 一分钟
             */
            Long ONE_MINUTE = 60000L;
            /**
             * 一周的毫秒
             */
            Long ONE_WEEK = ONE_DAY * 7;
        }
    }




    /**
     * 用户资料常量
     */
    interface UserInfoConstant {
        /**
         * 性别-男性
         */
        byte USER_INFO_SEX_MAN = 1;
        /**
         * 性别-女性
         */
        byte USER_INFO_SEX_FEMALE = 2;
        /**
         * 性别-未知
         */
        byte USER_INFO_SEX_UNKNOWN = 3;


    }


    /**
     * Redis 缓存前缀
     */
    interface RedisKeyPrefix {

        /**
         * 自定义缓存
         */
        String CUSTOM_CACHE = "CUSTOM_CACHE:";

        /**
         * 接口请求日志的统计
         */
        String URL_REQUEST_LOG = "URL_REQUEST_LOG:";

        /**
         * APP  配置参数
         */
        String APP_CONFIG = "APP_CONFIG";
    }

    interface RedisExpireTime {
        /**
         * 解析第三方视频 存入redis的有效时间
         */
        long GRAB_URL_LOG_EXPIRETIME = Time.Millisecond.ONE_MINUTE;
        /**
         * Token 有效期 为一周
         */
        long TOKEN_EFFECTIVE_TIME = Time.Millisecond.ONE_WEEK;
    }
}
