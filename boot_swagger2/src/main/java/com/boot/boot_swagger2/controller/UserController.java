package com.boot.boot_swagger2.controller;

import com.boot.boot_swagger2.entity.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author : kaifa
 * create at:  2019-11-13  11:18
 * @description: 用户控制层
 */
/**
 * 通过在控制器类上增加@Api 注解，可以给控制器增加描述和标签信息。
 */
@Api(tags = "用户相关接口", description = "提供用户相关的 Rest API",produces = "application/json, application/xml")
@RestController
@RequestMapping(value = "/user",produces ={"application/json", "application/xml"} )
public class UserController {

    /**
     * 通过在接口方法上增加 @ApiOperation 注解来展开对接口的描述，
     * 当然这个注解还可以指定很多内容，我们在下面的相关注解说明章节中详细解释。
     */

    @ApiOperation("新增用户接口")
    @PostMapping(value = "/add")
    public boolean addUser(@RequestBody User user) {
        return false;
    }
    @ApiOperation("查询用户接口")
    @GetMapping("/find/{id}")
    public User findById(@PathVariable("id") int id) {
        return new User();
    }
    @PutMapping("/update")
    public boolean update(@RequestBody User user) {
        return true;
    }

    /**
     * 有些时候我们并不是希望所有的 Rest API 都呈现在文档上，
     * 这种情况下 Swagger2 提供给我们了两种方式配置，
     * 一种是基于 @ApiIgnore 注解，另一种是在 Docket 上增加筛选。
     * ApiIgnore 注解。
     * 如果想在文档中屏蔽掉删除用户的接口（user/delete），那么只需要在删除用户的方法上加上 @ApiIgnore 即可。
     */
    @DeleteMapping("/delete/{id}")
    @ApiIgnore
    public boolean delete(@PathVariable("id") int id) {
        return true;
    }

    /**
     * @ApiOperation：方法的说明
     * @ApiOperation："用在请求的方法上，说明方法的作用"
     *        value="说明方法的作用"
     * 	notes="方法的备注说明"
     */
    @ApiOperation(value="用户登录",notes="用户登录swagger")
    /**
     * @ApiImplicitParams：用在请求的方法上，包含一组参数说明
     *        @ApiImplicitParam：对单个参数的说明
     *        name：参数名
     * 	    value：参数的汉字说明、解释
     * 	    required：参数是否必须传
     * 	    paramType：参数放在哪个地方
     * 	        · header --> 请求参数的获取：@RequestHeader
     * 	        · query --> 请求参数的获取：@RequestParam
     * 	        · path（用于restful接口）--> 请求参数的获取：@PathVariable
     * 	        · body（请求体）-->  @RequestBody User user
     * 	        · form（普通表单提交）
     * 	    dataType：参数类型，默认String，其它值dataType="Integer"
     * 	    defaultValue：参数的默认值
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name="mobile",value="手机号",required=true,paramType="form"),
            @ApiImplicitParam(name="password",value="密码",required=true,paramType="form"),
            @ApiImplicitParam(name="age",value="年龄",required=true,paramType="form",dataType="Integer")
    })

    @PostMapping("/login")
    public String login(@RequestParam String mobile, @RequestParam String password,
                        @RequestParam Integer age){
        return mobile+"-"+password+"-"+age;
    }


    /**
     *
     * @param userId
     * @return
     */

    @ApiOperation("获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="userId", dataType="String", required=true, value="用户Id")
    })
    /**
     * @ApiResponses、@ApiResponse：方法返回值的说明
     * @ApiResponses：方法返回对象的说明
     *        @ApiResponse：每个参数的说明
     *        code：数字，例如400
     * 	    message：信息，例如"请求参数没填好"
     * 	    response：抛出异常的类
     */
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @ResponseBody
    @RequestMapping("/user")
    public String finduser(@RequestParam String userId) {
       return userId;
    }

}

