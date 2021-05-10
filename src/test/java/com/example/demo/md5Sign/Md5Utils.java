package com.example.demo.md5Sign;

import lombok.extern.slf4j.Slf4j;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Md5Utils {

    public static void main(String[] args) {

        //修改这两个就可以
        String policyNo = "eee";  //保单号
        String unionId = "11";
        String agentcode = "0635";

        long time = System.currentTimeMillis();
//        String timeStamp = String.valueOf(time);
        String timeStamp = "";
        String[] split = policyNo.split("\n");
        for (int i = 0; i < split.length; i++) {
            Map md5Param = new HashMap<>();
            md5Param.put("appId", "200812120001");
            md5Param.put("policyNo", split[i]);
            md5Param.put("unionId", unionId);
            md5Param.put("timeStamp",timeStamp);
//            md5Param.put("agentCode",agentcode);
            /**
             *   签名验证 S
             */
            //1 拼接请求参数
            String buildQuery = CheckSign.buildQuery(md5Param, "utf-8", true);
            //根据请求参数生成后台签名
            String _sign = CheckSign.sign(buildQuery, "9a5cde958a", "utf-8");
//            log.info("----------------------------后台生成的签名: " + _sign);
//            log.info("----------------------------前台传入的参数: " + buildQuery);
//            log.info("----------------------------: " + "https://zx-uat.e-hqins.com/pages/pageX/tuoguan/bdtg?appId=200812120001&unionId="+unionId+"&policyNo=" + md5Param.get("policyNo") + "&sign=" + _sign+"&timeStamp="+timeStamp);
//            System.out.println("https://zx-uat.e-hqins.com/pages/pageX/memberLevel/memberLevel?appId=200812120001&unionId="+unionId+"&policyNo=" + md5Param.get("policyNo")+ "&sign="+ _sign+"&timeStamp="+timeStamp+"&agentCode="+agentcode);  //成员链接
//            System.out.println("https://zx-uat.e-hqins.com/pages/pageX/memberLevel/memberLevel?appId=200812120001&unionId="+unionId+"&sign=" + _sign+"&timeStamp="+timeStamp);  //成员链接
            System.out.println("https://zx-uat.e-hqins.com/pages/pageX/tuoguan/bdtg?appId=200812120001&unionId="+unionId+"&policyNo=" + md5Param.get("policyNo") + "&sign=" + _sign+"&timeStamp="+timeStamp);  //保单报告
//            System.out.println("http://172.16.12.1/pages/pageX/tuoguan/bdtg?appId=200812120001&unionId="+unionId+"&policyNo=" + md5Param.get("policyNo")+ "&sign="+ _sign+"&timeStamp="+timeStamp+"&agentCode="+agentcode);  //保单报告
        }

    }

//    public static void main(String[] args) {
//
//        //修改这两个就可以
//        String policyNo = "P982041711520";  //保单号
//        String unionId = "odQcRw_gBXT0VWkeDWEs2g8nB1C0";
//
//        long time = System.currentTimeMillis();
//        String timeStamp = String.valueOf(time);
//        String[] split = policyNo.split("\n");
//        for (int i = 0; i < split.length; i++) {
//            Map md5Param = new HashMap<>();
//            md5Param.put("appId", "200812120001");
//            md5Param.put("policyNo", split[i]);
//            md5Param.put("unionId", unionId);
//            md5Param.put("timeStamp",timeStamp);
//            /**
//             *   签名验证 S
//             */
//            //1 拼接请求参数
//            String buildQuery = CheckSign.buildQuery(md5Param, "utf-8", true);
//            //根据请求参数生成后台签名
//            String _sign = CheckSign.sign(buildQuery, "9a5cde958a", "utf-8");
////            log.info("----------------------------后台生成的签名: " + _sign);
////            log.info("----------------------------前台传入的参数: " + buildQuery);
////            log.info("----------------------------: " + "https://zx-uat.e-hqins.com/pages/pageX/tuoguan/bdtg?appId=200812120001&unionId="+unionId+"&policyNo=" + md5Param.get("policyNo") + "&sign=" + _sign+"&timeStamp="+timeStamp);
//
//            System.out.println("https://zx-uat.e-hqins.com/pages/pageX/tuoguan/bdtg?appId=200812120001&unionId="+unionId+"&policyNo=" + md5Param.get("policyNo") + "&sign=" + _sign+"&timeStamp="+timeStamp);
//        }
//
//    }
}
