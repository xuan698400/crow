var CWLib = {};

//option
CWLib.option = {};
CWLib.option.website = 'http://localhost:9000/';
CWLib.option.appId = '1';
CWLib.option.osType = 'H5';
CWLib.option.token = '123';

//http
CWLib.http = {};
CWLib.http.post = function(subUrl, params, success, fail){
    //通用参数
    params.appId = CWLib.option.appId;
    params.osType = CWLib.option.osType;
    params.token = CWLib.option.token;
    //
    var url = CWLib.option.website + subUrl;
    $.post(url, params, function(r){
        if(r.code == 200){
            if(success){
                success(r.result);
            }
        }else{
            if(fail){
                fail(r.bizCode, r.message);
            }
        }
    });
}

CWLib.api = {};
CWLib.api.getToken = function(option){
    var userId = option.userId;
    var userName = option.userName;
    var userLogo = option.userLogo;
    var success = option.success;
    var fail = option.fail;
    //
    var params = {
        userId : userId,
        userName : userName,
        userLogo : userLogo
    };
    //
    CWLib.http.post('user/getToken.json', params, function(result){
        if(success){
            success(result.token);
        }
    }, function(bizCode, message){
        if(fail){
            fail(bizCode, message);
        }
    });
}