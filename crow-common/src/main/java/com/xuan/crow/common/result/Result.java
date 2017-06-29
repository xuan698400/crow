package com.xuan.crow.common.result;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 结果
 * <p>
 * Created by xuan on 17/3/19.
 */
public class Result extends BaseResult {

    /**
     * 构造一个返回结果
     *
     * @param code
     * @param message
     * @param resultValue
     * @param bizCode
     * @return
     */
    public static Result obtain(CodeEnum code, String message, Object resultValue, String bizCode) {
        Result result = new Result();
        result.setCode(code.getCode());
        result.setMessage(message);
        if (null == resultValue) {
            resultValue = new JSONObject();
        }
        result.setResult(result);
        result.setBizCode(bizCode);
        return result;
    }

    /**
     * 成功
     *
     * @param message
     * @param resultValue
     * @return
     */
    public static Result obtainSuccess(String message, Object resultValue) {
        return Result.obtain(CodeEnum.SUCCESS, message, resultValue, null);
    }

    /**
     * 成功
     *
     * @param result
     * @return
     */
    public static Result obtainSuccess(Object result) {
        return Result.obtainSuccess("成功", result);
    }

    /**
     * 成功
     *
     * @return
     */
    public static Result obtainSuccess() {
        return Result.obtainSuccess(new JSONObject());
    }

    /**
     * 成功
     *
     * @param keyList
     * @param valList
     * @return
     */
    public static Result obtainSuccessForKv(List<String> keyList, List<Object> valList) {
        if (null == keyList || keyList.size() == 0) {
            throw new NullPointerException("keyList is empty");
        }
        if (null == valList || valList.size() == 0) {
            throw new NullPointerException("valList is empty");
        }
        if (valList.size() != valList.size()) {
            throw new RuntimeException("keyList.size != valList.size");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        for (int i = 0, n = valList.size(); i < n; i++) {
            if (null == valList.get(i)) {
                map.put(keyList.get(i), new JSONObject());
            } else {
                map.put(keyList.get(i), valList.get(i));
            }
        }
        return Result.obtainSuccess(map);
    }

    /**
     * 成功
     *
     * @param key
     * @param value
     * @return
     */
    public static Result obtainSuccessForKv(String key, Object value) {
        return obtainSuccessForKv(Lists.newArrayList(key), Lists.newArrayList(value));
    }

    /**
     * 成功
     *
     * @param list
     * @return
     */
    public static Result obtainSuccessForList(List list) {
        return obtainSuccessForKv("list", list);
    }

    /**
     * 失败
     *
     * @param bizCode
     * @param message
     * @return
     */
    public static Result obtainError(String bizCode, String message) {
        return Result.obtain(CodeEnum.ERROR, message, null, bizCode);
    }

}
