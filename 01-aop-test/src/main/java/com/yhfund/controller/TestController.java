package com.yhfund.controller;

import com.alibaba.fastjson.JSON;
import com.yhfund.bean.Student;
import com.yhfund.bean.Worker;
import com.yhfund.bean.impl.StudentA;
import com.yhfund.common.Constans;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 张鹏
 *         Date: 2018/8/15
 *         Time: 14:48
 *         Description:
 */
@Controller
public class TestController {

    private static final ThreadLocal THREAD_LOCAL = new ThreadLocal();
    private static Logger logger = LoggerFactory.getLogger(TestController.class);
    @RequestMapping(value = "/get.do")
    public String get(Model model, HttpServletRequest request, HttpSession session){

        String lang = request.getParameter("lang");
        String sessionId = session.getId();
        model.addAttribute("sessionId",sessionId);
        Student stu1 = new StudentA("18","张三");
        Student stu2 = new StudentA("14","tom");
        System.out.println("核心业务");
        List<Student> list = new ArrayList<>();
        model.addAttribute("list1",list);
        list.add(stu1);
        list.add(stu2);
        model.addAttribute("list",JSON.toJSONString(list));
        model.addAttribute("stu2",stu2);
        model.addAttribute("stu1",JSON.toJSONString(stu1));
        System.out.println(JSON.toJSONString(stu1));
        model.addAttribute("lang",lang);
        return  "hello";
    }

    @RequestMapping(value = "/set.do")
    public String set(){
        return "test01";
    }

    @RequestMapping(value = "/test.do")
    public Worker test(Worker worker){
        return worker;
    }

    public static void main(String[] args) throws InterruptedException {
        Map<String,String> map = new Hashtable<>();
        map.put("1","zhangs");
        map.put("2","lisi");
        map.put("3","niu");
        map.put("4","haha");

//        System.out.println(map.toString());
//        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<String, String> it = iterator.next();
//            System.out.println(it.getKey() + "," + it.getValue());
//            //这么表达是错误的
////            System.out.println(iterator.next().getKey() + "," + iterator.next().getValue());
//        }


        List<String> list = new ArrayList<>();
        list.add("3");
        list.add("2");
        System.out.println(list.contains("2"));

        try {
            Date date = DateUtils.parseDate("2018-02-20", "yyyy-MM-dd");
            Date date1 = DateUtils.addYears(new Date(), 2);
            System.out.println(date1);
            System.out.println(date.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1);

        Thread.sleep(100);
        System.out.println(System.currentTimeMillis() - l1);
//        object 类型强转为string类型，报错ClassCaseException;集合转数组，先创建一个长度与集合一致的数组，然后用集合的toStirng的有参方法，得到数组
//        String[] objects = (String[]) list.toArray();
//        System.out.println(Arrays.toString(objects));
//        String[] array = new String[list.size()];
//        array = list.toArray(array);
//        System.out.println(Arrays.toString(array));
//        Arrays.sort(array);
//        System.out.println(Arrays.toString(array));

//        for (String s: list) {
//            if ("2".equals(s)){
//                list.remove(s);
//            }
//        }
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            if ("2".equals(iterator.next())) {
//                iterator.remove();
//            }
//        }
//        System.out.println(list.toString());


//        String s = "{37:1|38:1|39:1|40:1|41:1|42:1|43:1|44:1|45:1|46:1}";
//
//        String str = s.replace("|",",");
//        JSONObject jsonObject = JSON.parseObject(str);
//        System.out.println(jsonObject.get("37"));

//        Student stu1 = new StudentA("18","张三");
//        Student stu2 = new StudentA("14","tom");
//        System.out.println("stu1 : " + JSON.toJSONString(stu1));
//        List<Student> list2 = new ArrayList<>();
//        list2.add(stu1);
//        list2.add(stu2);
//        System.out.println(list2.get(0).toString());

//        String jsonList = JSON.toJSONString(list);
//        System.out.println("list : " + jsonList);
//
//        THREAD_LOCAL.set(jsonList);
//
//        THREAD_LOCAL.get();
//        System.out.println(THREAD_LOCAL.get());


//        BigDecimal bigDecimal = new BigDecimal("2.2235");
//        bigDecimal.setScale(4,BigDecimal.ROUND_HALF_UP);
//        System.out.println(bigDecimal.setScale(3,BigDecimal.ROUND_HALF_UP));
//        System.out.println(bigDecimal.setScale(3,BigDecimal.ROUND_HALF_DOWN));
    }

    @RequestMapping("/imgTest")
    public String imgTest(HttpServletRequest request, MultipartFile file){

        return "img";
    }

    @RequestMapping("/uploadImg")
    public void uploadPicture(@RequestParam(value="file",required=false)MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> map = new HashMap<String, Object>();
        File targetFile=null;
        String url="";//返回存储路径
        int code=1;
        System.out.println(file);
        String fileName=file.getOriginalFilename();//获取文件名加后缀
        if(fileName!=null&&fileName!=""){
            String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() +"/upload/imgs/";//存储路径
            String path = request.getSession().getServletContext().getRealPath("upload/imgs"); //文件存储位置
            String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
            fileName=new Date().getTime()+"_"+new Random().nextInt(1000)+fileF;//新的文件名

            //先判断文件是否存在
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String fileAdd = sdf.format(new Date());
            //获取文件夹路径
            File file1 =new File(path+"/"+fileAdd);
            //如果文件夹不存在则创建
            if(!file1 .exists()  && !file1 .isDirectory()){
                file1 .mkdir();
            }
            //将图片存入文件夹
            targetFile = new File(file1, fileName);
            try {
                //将上传的文件写到服务器上指定的文件。
                file.transferTo(targetFile);
                url=returnUrl+fileAdd+"/"+fileName;
                code=0;
                map.put("url", url);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * IO流读取图片 by:url
     * @return
     */
    @RequestMapping(value = "/ioReadImage.do")
    public void IoReadImage(HttpServletResponse response) throws IOException {
        long l1 = System.currentTimeMillis(); // 开始时间
        String filePath = Constans.FOLDER_IMAGE4M; // 图片url

        URL url = new URL(filePath);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(2 * 1000);
        InputStream in = connection.getInputStream();
        try {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream(); //创建一个Buffer字符串
            byte[] buffer = new byte[4096]; //每次读取的字节长度
            int len;
            int count = 0;
            while ((len = in.read(buffer)) != -1) {
                //把in读取并存储在buffer中的数据，写入到对象outStream中，中间参数代表从哪个位置开始读，len代表读取的长度
                outStream.write(buffer, 0, len);
                count++;
            }
            byte[] bytes = outStream.toByteArray();
            System.out.println("读取次数count：" + count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            long l2 = System.currentTimeMillis();
            System.out.println("读取图片并转为字节数组耗时：" + (l2-l1));
            in.close(); //关闭输入流
        }
    }

}
