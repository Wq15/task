package tools;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class AliyunMessageUtil {
    //产品名称:云通信短信API产品,开发者无需替换
//    static final String product = "Dysmsapi";
//    //产品域名,开发者无需替换
//    static final String domain = "dysmsapi.aliyuncs.com";
//
//    //  此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
//    static final String accessKeyId = "LTAI4FiNnh1nnNBKUYvnx3my";
//    static final String accessKeySecret = "JcPI8WSglwWDFgLhXuPwqb8fRNZd5m";
//    //  短信签名
//    static final String signName = "个人用户";
//    //  短信模板code(根据需要,注册、密码重置可用不同的模板code,阿里云访问控制台设置多套模板)
//    static final String identityTemplateCode = "SMS_173346936";// 验证码模板

    private static String product;
    private static String domain;
    private static String accessKeyId;
    private static String accessKeySecret;
    private static String signName;
    private static String identityTemplateCode;

    public void setProduct(String product) {
        AliyunMessageUtil.product = product;
    }

    public String getProduct() {
        return product;
    }

    public void setDomain(String domain) {
        AliyunMessageUtil.domain = domain;
    }

    public String getDomain() {
        return domain;
    }

    public void setAccessKeyId(String accessKeyId) {
        AliyunMessageUtil.accessKeyId = accessKeyId;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        AliyunMessageUtil.accessKeySecret = accessKeySecret;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setSignName(String signName) {
        AliyunMessageUtil.signName = signName;
    }

    public String getSignName() {
        return signName;
    }

    public void setIdentityTemplateCode(String identityTemplateCode) {
        AliyunMessageUtil.identityTemplateCode = identityTemplateCode;
    }

    public String getIdentityTemplateCode() {
        return identityTemplateCode;
    }


    // 随机生成验证码(六位数)
    private static int identifyingCode;

    public static int getIdentifyingCode() {
        return identifyingCode = new Random().nextInt(900000) + 100000;
        //每次调用生成一次六位数的随机数
    }

    //发送验证码
    public static SendSmsResponse sendSms(String phoneNumber, String templateCode, String templateParam) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(phoneNumber);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(signName);
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(templateCode);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        //request.setTemplateParam("{\"name\":\"Tom\", \"code\":\"123\"}");
        request.setTemplateParam(templateParam);


        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        return sendSmsResponse;
    }


    public static QuerySendDetailsResponse querySendDetails(String bizId, String phoneNumber) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        //必填-号码
        request.setPhoneNumber(phoneNumber);

        //可选-流水号
        request.setBizId(bizId);
        //必填-发送日期 支持30天内记录查询，格式yyyyMMdd
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        request.setSendDate(ft.format(new Date()));
        //必填-页大小
        request.setPageSize(10L);
        //必填-当前页码从1开始计数
        request.setCurrentPage(1L);

        //hint 此处可能会抛出异常，注意catch
        QuerySendDetailsResponse querySendDetailsResponse = acsClient.getAcsResponse(request);

        return querySendDetailsResponse;
    }


    /**
     * 修改密码发送验证码短信（templateParam 根据模板需要传入的参数进行json格式拼接）
     *
     * @param phoneNumber
     * @throws ClientException
     * @throws InterruptedException
     */
    public static SendSmsResponse sendIdentifyingCode(String phoneNumber, int identifyingCode) throws ClientException {
        String templateParam = "{\"code\":\"" + identifyingCode + "\"}";
        return sendSms(phoneNumber, identityTemplateCode, templateParam);
    }


//    public static void main(String[] args) throws ClientException, InterruptedException {
//
//        //发短信
//        SendSmsResponse response = sendSms(args[0],identityTemplateCode,"{\"code\":\"" + getIdentifyingCode() + "\"}");
//        Thread.sleep(3000L);
//
//        //查明细
//        if(response.getCode() != null && response.getCode().equals("OK")) {
//            QuerySendDetailsResponse querySendDetailsResponse = querySendDetails(response.getBizId(),"18879753873");
//            System.out.println("短信明细查询接口返回数据----------------");
//            System.out.println("Code=" + querySendDetailsResponse.getCode());
//            System.out.println("Message=" + querySendDetailsResponse.getMessage());
//            int i = 0;
//            for(QuerySendDetailsResponse.SmsSendDetailDTO smsSendDetailDTO : querySendDetailsResponse.getSmsSendDetailDTOs())
//            {
//                System.out.println("SmsSendDetailDTO["+i+"]:");
//            }
//        }
//
//    }

}