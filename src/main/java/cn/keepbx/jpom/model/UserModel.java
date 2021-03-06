package cn.keepbx.jpom.model;

import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSONObject;

/**
 * @author jiangzeyin
 * @date 2019/1/16
 */
public class UserModel {
    private String id;
    private String name;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserMd5Key() {
        return SecureUtil.md5(String.format("%s:%s", id, password));
    }

    public JSONObject toJson() {
        return (JSONObject) JSONObject.toJSON(this);
    }
}
