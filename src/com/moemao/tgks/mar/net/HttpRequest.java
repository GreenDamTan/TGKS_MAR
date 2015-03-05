package com.moemao.tgks.mar.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.moemao.tgks.mar.marz.thread.MarzThreadPoolDiffusion;

public class HttpRequest
{
    private static int SLEEP_TIME = 10 * 1000;
    
    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url 发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public String sendGet(String url, String param)
    {
        String result = "";
        BufferedReader in = null;
        try
        {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet())
            {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null)
            {
                result += line;
            }
        }
        catch (Exception e)
        {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally
        {
            try
            {
                if (in != null)
                {
                    in.close();
                }
            }
            catch (Exception e2)
            {
                e2.printStackTrace();
            }
        }
        try
        {
            byte[] bytes = result.getBytes();
            result = new String(bytes, "UTF-8");
        }
        catch (Exception e)
        {
            
        }
        return result;
    }
    
    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url 发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     * @throws Exception 
     */
    public String sendPost(String url, String param) throws Exception
    {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try
        {
            //synchronized (this)
            //{
                URL realUrl = new URL(url);
                // 打开和URL之间的连接
                URLConnection conn = realUrl.openConnection();
                // 设置通用的请求属性
                conn.setRequestProperty("accept", "*/*");
                conn.setRequestProperty("connection", "Keep-Alive");
                conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
                // 设置超时
                conn.setReadTimeout(10000);
                conn.setConnectTimeout(10000);
                // 发送POST请求必须设置如下两行
                conn.setDoOutput(true);
                conn.setDoInput(true);
                // 获取URLConnection对象对应的输出流
                out = new PrintWriter(conn.getOutputStream());
                // 发送请求参数
                out.print(param);
                // flush输出流的缓冲
                out.flush();
                // 定义BufferedReader输入流来读取URL的响应
                in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                while ((line = in.readLine()) != null)
                {
                    result += line;
                }
            //}
        }
        catch (Exception e)
        {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
            this.notify();
            throw e;
        }
        // 使用finally块来关闭输出流、输入流
        finally
        {
            try
            {
                if (out != null)
                {
                    out.close();
                }
                if (in != null)
                {
                    in.close();
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        
        try
        {
            byte[] bytes = result.getBytes();
            result = new String(bytes, "UTF-8");
        }
        catch (Exception e)
        {
            
        }
        
        if (result.contains("�?,"))
        {
            result = result.replace("�?,", "\",");
        }
        if (result.contains("�?}"))
        {
            result = result.replace("�?}", "\"}");
        }
        
        SLEEP_TIME = (MarzThreadPoolDiffusion.getInstance().getMarzThreadNum() + 1) * 4 *1000;
        
        Thread.sleep(SLEEP_TIME);
        
        return result;
    }
    
    public static void main(String[] args)
    {        
        try
        {
            String url = "https://app.login.kairisei-ma.jp:443/Auth/login.php";
            String paramStr = "{\"uuid\":\"" + UUID.randomUUID().toString() + "\",\"clver\":\"1\",\"os\":0,\"carrier\":3,\"market\":1,\"lang\":0,\"device\":\"iPhone5S\",\"token\":\"\"}";
            String sr = new HttpRequest().sendPost(url, paramStr);
            System.out.println(sr);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
