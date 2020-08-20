package com.example.demo.entity;



import com.example.demo.constant.ConstantConfig;

import java.io.Serializable;

;

/**
 * Created by ABeen on 2020/02/14/026.
 *
 * @author ABeen
 */
public class ResponeEntity implements Serializable {
    /**
     * 响应成功
     */
    public static final int RESPONE_SUCCESS = 0;
    public static final String RESPONE_SUCCESS_DESC = "SUCCESS";

    public static final int INFO_NOT_FOUND = 404;

    public static final String INFO_NOT_FOUND_DESC = "NOT_FOUND";
    /**
     * 响应失败
     */
    public static final int RESPONE_ERROR = 100;
    public static final String RESPONE_ERROR_DESC = "ERROR";

    /**
     * 服务器异常
     */
    public static final int RESPONE_SERVER_ERROR = 101;

    /**
     * 请求参数错误
     */
    public static final int RESPONE_REQUEST_ERROR = 102;

    /**
     * 访问资源不存在
     */
    public static final int RESPONE_RESOURCES_ERROR = 103;
    /**
     * 用户登录授权错误
     */
    public static final int RESPONE_ACCESS_ERROR = 104;
    /**
     * 视频下架
     */
    public static final int RESPONE_VTOP_LOWER = 105;

    //    @JsonView(JSONViewInterface.Base.class)
    public int codeid;

    //    @JsonView(JSONViewInterface.Base.class)
    public String codedesc;

    //    @JsonView(JSONViewInterface.Base.class)
    public Object data;


    public int getCodeid() {
        return codeid;
    }

    public ResponeEntity setCodeid(int codeid) {
        this.codeid = codeid;
        return this;
    }

    public String getCodedesc() {
        return codedesc;
    }

    public ResponeEntity setCodedesc(String codedesc) {
        this.codedesc = codedesc;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResponeEntity setData(Object data) {
        this.data = data;
        return this;
    }





    public static ResponeEntity build(int codeid) {
        ResponeEntity responeEntity = new ResponeEntity().setCodeid(codeid);
        String codedesc = null;
        switch (codeid) {
            case RESPONE_SUCCESS:
                codedesc = ConstantConfig.ResponeErrorInfo.SUCCESS;
                responeEntity.setData("Success");
                break;
            case RESPONE_ERROR:
                responeEntity.setData("Error");
                codedesc = ConstantConfig.ResponeErrorInfo.ERROR_RETRY;
                break;
            default:
                break;
        }
        responeEntity.setCodedesc(codedesc);
        return responeEntity;
    }

    public static ResponeEntity buildSuccess(Object data) {
        return ResponeEntity
                .build(ResponeEntity.RESPONE_SUCCESS)
                .setData(data)
                .setCodedesc(RESPONE_SUCCESS_DESC);
    }

    public static ResponeEntity buildFail( Object data) {
        return ResponeEntity
                .build(ResponeEntity.RESPONE_ERROR)
                .setData(data)
                .setCodedesc(ResponeEntity.RESPONE_ERROR_DESC);
    }

    @Override
    public String toString() {
        String result = "ResponeEntity{" +
                "codeid=" + codeid +
                ", codedesc='" + codedesc + '\'' +
                ", data=" + data +
                '}';
//        System.out.println(result);
        return result;
    }



}


