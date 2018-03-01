import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.util.Util;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.junit.Test;

import java.io.File;
import java.io.IOException;


public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "10135741";
    public static final String API_KEY = "eILRPmhvqkZ1gWxQSVwYCQTI";
    public static final String SECRET_KEY = "c99691a7d6ba86c45c979ab4d2d95b1b";

    private static final Logger logger = Logger.getLogger(Sample.class);

    public static void main(String[] args) {
        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "/home/vincent/IdeaProjects/BaiduSpeech/resources/log4j.properties");

        // 调用接口
        JSONObject res = client.asr("/home/vincent/IdeaProjects/BaiduSpeech/resources/16k.pcm", "pcm", 16000, null);
        System.out.println(res.toString(2));
    }


    @Test
    public void synthesis(AipSpeech client)
    {
        // 对本地语音文件进行识别
        String path = "resources/16k.pcm";
        JSONObject asrRes = client.asr(path, "pcm", 16000, null);
        System.out.println(asrRes);

        // 对语音二进制数据进行识别
        try{
            byte[] data = FileUtils.readFileToByteArray(new File(path));     //readFileByBytes仅为获取二进制数据示例
            JSONObject asrRes2 = client.asr(data, "pcm", 16000, null);
            System.out.println(asrRes);

        } catch (IOException e){
            logger.error("IO exception found during reading source file");
        }

        // 对网络上音频进行识别
        String url = "http://somehost/res/16k_test.pcm";
        String callback = "http://callbackhost/aip/dump";
        JSONObject res = client.asr(url, callback, "pcm", 16000, null);
        System.out.println(res);
    }

}