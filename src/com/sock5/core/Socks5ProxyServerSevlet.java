/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sock5.core;

import javax.annotation.Resource;
import org.redkale.net.http.HttpContext;
import org.redkale.net.http.HttpServlet;
import org.redkale.net.http.WebServlet;
import org.redkale.util.AnyValue;

/**
 *
 * @author SquRab
 */
@WebServlet(value = {"/abcdefglhijklmn/*"}, repair = false, comment = "无效Servlet服务")
public class Socks5ProxyServerSevlet extends HttpServlet {
   

    @Override
    public void init(HttpContext context, AnyValue config) {
       Socks5ProxyServer server = new Socks5ProxyServer();
        Thread thread = new Thread(() -> {
            server.init();
        });
        thread.setName("sockTask -" + 1 + "-Thread");
        thread.setDaemon(true);
        thread.start();
            
    }
}
